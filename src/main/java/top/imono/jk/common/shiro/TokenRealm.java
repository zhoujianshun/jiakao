package top.imono.jk.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import top.imono.jk.common.utils.JwtUtil;
import top.imono.jk.common.utils.Constants;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.dto.SysUserDto;
import top.imono.jk.pojo.po.SysResource;
import top.imono.jk.pojo.po.SysRole;
import top.imono.jk.pojo.po.SysUser;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.service.SysUserService;

import java.util.List;

@Slf4j
public class TokenRealm extends AuthorizingRealm {

    public TokenRealm(TokenMatcher tokenMatcher) {
        super(tokenMatcher);
    }

    @Resource
    private RedisTemplate<String, String> stringRedisTemplate;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private SysUserService userService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 多重写一个support
     * 标识这个Realm是专门用来验证JwtToken
     * 不负责验证其他的token（UsernamePasswordToken）
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("TokenRealm - supports - {}", token);
        return token instanceof JwtToken;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String jwtToken = (String) authenticationToken.getCredentials();
        log.debug("TokenRealm - doGetAuthorizationInfo - {}", jwtToken);

        // token是否有效
        jwtUtil.isVerify(jwtToken);

        Claims claims = jwtUtil.getClaimsByToken(jwtToken);
        // 获取jwt中关于用户名
        String id = (String) claims.get("id");
        // 获取缓存中的token
        String cacheToken = stringRedisTemplate.boundValueOps("token_" + id).get();

        if (cacheToken == null) {
            return JsonVos.raise(CodeMsg.TOKEN_EXPIRED);
        } else if (!jwtToken.equals(cacheToken)) {
            return JsonVos.raise(CodeMsg.LOGIN_OTHER_DEVICE);
        }

        // 查询用户
        SysUser user = userService.getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getId, id));
        if (user == null) {
            return JsonVos.raise(CodeMsg.WRONG_USERNAME);
        }
        if (user.getStatus() == Constants.SysUserStatus.LOCKED) {
            return JsonVos.raise(CodeMsg.USER_LOCKED);
        }

        return new SimpleAuthenticationInfo(user, jwtToken, getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        SysUserDto userDto = (SysUserDto) redisTemplate.boundValueOps("user_" + user.getId()).get();
        if (userDto == null) {
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<SysRole> roles = userDto.getRoles();
        if (CollectionUtils.isEmpty(roles)) return info;

        // 添加角色
        for (SysRole role : roles) {
            info.addRole(role.getName());
        }

        List<SysResource> resources = userDto.getResources();
        if (CollectionUtils.isEmpty(resources)) return info;
        // 添加权限
        for (SysResource resource : resources) {
            info.addStringPermission(resource.getPermission());
        }
        return info;
    }
}
