package top.imono.jk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.vo.req.LoginReqVo;
import top.imono.jk.pojo.vo.resp.LoginVo;
import top.imono.jk.pojo.vo.resp.json.DataJsonVo;
import top.imono.jk.service.SysUserService;

@RestController
@RequestMapping("/user")
@Tag(name = "用户相关")
public class UserController {

    @Autowired
    private SysUserService service;

    @PostMapping("/login")
    @SecurityRequirements() // 设置文档中不需要auth验证
    @Operation(summary = "登录")
    public DataJsonVo<LoginVo> login(@Valid LoginReqVo loginVo, HttpServletRequest request, HttpServletResponse response) {
        return JsonVos.success(service.login(loginVo, response));
    }

    @PostMapping("/logout")
    @SecurityRequirements() // 设置文档中不需要auth验证
    @Operation(summary = "登出")
    public DataJsonVo<Boolean> logout(HttpServletRequest request) {
        return JsonVos.success(service.logout(request));
    }
}
