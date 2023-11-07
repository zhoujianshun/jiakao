package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.resp.json.JsonVo;

import java.util.Arrays;

@Validated
public abstract class BaseController<Po, ReqVo> {
    protected abstract IService<Po> getService();
    protected abstract Po getPo(ReqVo reqV);


    @Operation(summary = "删除")
    @DeleteMapping("/{ids}")
    public JsonVo delete(@Parameter(description = "需要删除的id，多个id可以使用','隔开") @PathVariable String ids) {
        boolean result = getService().removeByIds(Arrays.stream(ids.split(",")).toList());
        if (result) {
            return JsonVos.success(CodeMsg.REMOVE_OK);
        }
        return JsonVos.raise(CodeMsg.REMOVE_ERROR);
    }
//
//    @Operation(summary = "保存")
//    @PostMapping("/save")
//    public JsonVo save(@Valid ReqVo item) {
//        boolean result = getService().saveOrUpdate(getPo(item));
//        if (result) {
//            return JsonVos.success(CodeMsg.SAVE_OK);
//        }
//        // 使用统一错误处理
//        return JsonVos.raise(CodeMsg.SAVE_ERROR);
//    }
//
//    @Operation(summary = "删除")
//    @DeleteMapping("/remove")
//    public JsonVo remove(@NotBlank(message = "ids不能为空") String ids) {
//        boolean result = getService().removeByIds(Arrays.stream(ids.split(",")).toList());
//        if (result) {
//            return JsonVos.success(CodeMsg.REMOVE_OK);
//        }
//        return JsonVos.raise(CodeMsg.REMOVE_ERROR);
//    }
}
