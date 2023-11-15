package top.imono.jk.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.imono.jk.common.utils.Constants;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.req.list.SysUserPageReqVo;
import top.imono.jk.pojo.vo.resp.SysUserVo;
import top.imono.jk.pojo.vo.resp.json.JsonVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;
import top.imono.jk.service.SysUserService;

import java.util.Arrays;

@RestController
@RequestMapping("/sysUsers")
@Tag(name = "用户相关")
public class SysUserController {

    @Autowired
    private SysUserService service;

//    @SaCheckPermission("sysUser.list")
    @GetMapping
    @Operation(description = "分页查询用户")
    public ListJsonVo<SysUserVo> list(SysUserPageReqVo reqVo) {
        return JsonVos.success(service.list(reqVo));
    }

//    @SaCheckRole("总经理")
    @Operation(summary = "删除")
    @DeleteMapping("/{ids}")
    public JsonVo delete(@Parameter(description = "需要删除的id，多个id可以使用','隔开") @PathVariable String ids) {
        boolean result = service.removeByIds(Arrays.stream(ids.split(",")).toList());
        if (result) {
            return JsonVos.success(CodeMsg.REMOVE_OK);
        }
        return JsonVos.raise(CodeMsg.REMOVE_ERROR);
    }
}
