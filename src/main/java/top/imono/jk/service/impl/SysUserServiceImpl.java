package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.jwt.JwtUtil;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.po.SysUser;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.req.LoginReqVo;
import top.imono.jk.pojo.vo.resp.LoginVo;
import top.imono.jk.service.SysUserService;
import top.imono.jk.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.UUID;
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

        // 生成token
        String token = jwtUtil.generateToken(user.getUsername(), user.getId().toString());
        response.setHeader(JwtUtil.HEADER, token);
        response.setHeader("Access-control-Expost-Headers", JwtUtil.HEADER);
        // 放入缓存
        stringRedisTemplate.boundValueOps("token_" + user.getId()).set(token, 10, TimeUnit.MINUTES);
//        redisTemplate.boundValueOps("user_" + user.getId()).set(user, 1, TimeUnit.MINUTES);
//        String test = stringRedisTemplate.boundValueOps("test").get();
//        log.debug(test + "");

//        EhCaches.tokenPut(token, user);
        LoginVo vo = MapStructs.INSTANCE.po2loginVo(user);
        vo.setToken(token);
        return vo;
    }
}



