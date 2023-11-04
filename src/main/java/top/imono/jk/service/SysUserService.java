package top.imono.jk.service;

import top.imono.jk.pojo.po.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.LoginReqVo;
import top.imono.jk.pojo.vo.resp.LoginVo;

/**
* @author zhoujianshun
* @description 针对表【sys_user(用户（可以登录后台系统的）)】的数据库操作Service
* @createDate 2023-11-04 13:07:48
*/
public interface SysUserService extends IService<SysUser> {
    LoginVo login(LoginReqVo loginVo);
}
