package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.vo.req.list.DictItemPageReqVo;
import top.imono.jk.pojo.vo.req.list.PageReqVo;
import top.imono.jk.pojo.vo.req.save.DictItemReqVo;
import top.imono.jk.pojo.vo.resp.DictItemVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;
import top.imono.jk.service.DictItemService;

import java.util.List;

@Tag(name = "DictItemController", description = "查询管理数据字典")
@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem, DictItemReqVo> {
    @Autowired
    private DictItemService service;

    @Operation(summary = "查询数据字典值")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = DictItemVo.class))}),
            @ApiResponse(responseCode = "405", description = "非法输入",
                    content = @Content)
    })
    @GetMapping
    public ListJsonVo<DictItemVo> list(@Valid DictItemPageReqVo dictTypeQuery) {
        return JsonVos.success(service.list(dictTypeQuery));
    }


    @Override
    protected IService<DictItem> getService() {
        return service;
    }

    @Override
    protected DictItem getPo(DictItemReqVo reqV) {
        return MapStructs.INSTANCE.reqVo2po(reqV);
    }
}
