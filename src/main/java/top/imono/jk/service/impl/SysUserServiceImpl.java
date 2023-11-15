package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.shiro.JwtToken;
import top.imono.jk.common.utils.JwtUtil;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.dto.SysUserDto;
import top.imono.jk.pojo.po.*;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.req.LoginReqVo;
import top.imono.jk.pojo.vo.req.list.SysUserPageReqVo;
import top.imono.jk.pojo.vo.resp.LoginVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysUserVo;
import top.imono.jk.service.SysResourceService;
import top.imono.jk.service.SysRoleService;
import top.imono.jk.service.SysUserService;
import top.imono.jk.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import top.imono.jk.common.utils.Constants;

/**
 * @author zhoujianshun
 * @description 针对表【sys_user(用户（可以登录后台系统的）)】的数据库操作Service实现
 * @createDate 2023-11-04 13:07:48
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysResourceService sysResourceService;

    @Override
    public LoginVo login(LoginReqVo loginReqVo, HttpServletResponse response) {
        MpLambdaQueryWrapper<SysUser> wrapper = new MpLambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, loginReqVo.getUsername());

        SysUser user = baseMapper.selectOne(wrapper);
        if (user == null) {
            return JsonVos.raise(CodeMsg.WRONG_USERNAME);
        }
        if (!loginReqVo.getPassword().equals(user.getPassword())) {
            return JsonVos.raise(CodeMsg.WRONG_PASSWORD);
        }
        if (user.getStatus() == Constants.SysUserStatus.LOCKED) {
            return JsonVos.raise(CodeMsg.USER_LOCKED);
        }

        // 更新登录时间
        user.setLoginTime(new Date());
        baseMapper.updateById(user);

        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setUser(user);
        List<SysRole> sysRoles = sysRoleService.listByUserId(user.getId());
        if (!CollectionUtils.isEmpty(sysRoles)) {
            sysUserDto.setRoles(sysRoles);
            List<Integer> roleIds = sysRoles.stream().map(SysRole::getId).toList();
            List<SysResource> sysResources = sysResourceService.listByRoleIds(roleIds);
            sysUserDto.setResources(sysResources);
        }
        String username = user.getUsername();
        // 生成token
        String token = jwtUtil.generateToken(username);
//        response.setHeader(JwtUtil.HEADER, token);
//        response.setHeader("Access-control-Expost-Headers", JwtUtil.HEADER);
        // 放入缓存
        stringRedisTemplate.boundValueOps("token_" + username).set(token, JwtUtil.EXPIRE, TimeUnit.MINUTES);
        // 保存权限信息，避免在接口查询的时候时，为验证权限多次查询数据库
        redisTemplate.boundValueOps("user_" + username).set(sysUserDto, JwtUtil.EXPIRE, TimeUnit.MINUTES);

//        redisTemplate.boundValueOps("user_" + user.getId()).set(user, 1, TimeUnit.MINUTES);
//        String test = stringRedisTemplate.boundValueOps("test").get();
//        log.debug(test + "");

//        EhCaches.tokenPut(token, user);
        LoginVo vo = MapStructs.INSTANCE.po2loginVo(user);
        vo.setToken(token);
        return vo;
    }

    @Override
    public Boolean logout(HttpServletRequest request) {
        String token = JwtUtil.getTokenFromRequest(request);
        if (!StringUtils.hasLength(token)) {
            return JsonVos.raise(CodeMsg.NO_TOKEN);
        }
        JwtToken jwtToken = new JwtToken(token);
//        String userId = jwtUtil.getClaimFiled(token, "id");
        String username = jwtToken.getUsername();
        if (username == null) {
            return JsonVos.raise(CodeMsg.BAD_REQUEST);
        }
        stringRedisTemplate.delete("token_" + username);
        redisTemplate.delete("user_" + username);

        return true;
    }

    @Override
    public PageVo<SysUserVo> list(SysUserPageReqVo reqVo) {
        MpLambdaQueryWrapper<SysUser> wrapper = new MpLambdaQueryWrapper<>();
        /*对上面关键字查询进行分装*/
        wrapper.like(reqVo.getKeyword(),
                SysUser::getNickname,
                SysUser::getUsername);
        //        通过id排序
        wrapper.orderByDesc(SysUser::getId);

        return baseMapper.selectPage(new MpPage<>(reqVo), wrapper)
                .buildPageVo(MapStructs.INSTANCE::po2vo);
    }
}




