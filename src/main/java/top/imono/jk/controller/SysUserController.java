package top.imono.jk.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
public class SysUserController{

    @Autowired
    private SysUserService service;

    @PostMapping("/login")
    @Operation(summary = "登录")
    public DataJsonVo<LoginVo> login(@Valid LoginReqVo loginVo, HttpServletRequest request) {
        return JsonVos.success(service.login(loginVo));
    }

}
