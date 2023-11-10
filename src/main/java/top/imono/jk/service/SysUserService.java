package top.imono.jk.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.imono.jk.pojo.po.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.req.LoginReqVo;
import top.imono.jk.pojo.vo.req.list.SysUserPageReqVo;
import top.imono.jk.pojo.vo.resp.LoginVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.SysUserVo;

/**
* @author zhoujianshun
* @description 针对表【sys_user(用户（可以登录后台系统的）)】的数据库操作Service
* @createDate 2023-11-04 13:07:48
*/
public interface SysUserService extends IService<SysUser> {
    LoginVo login(LoginReqVo loginVo, HttpServletResponse response);

    Boolean logout(HttpServletRequest request);

    PageVo<SysUserVo> list(SysUserPageReqVo reqVo);
}
