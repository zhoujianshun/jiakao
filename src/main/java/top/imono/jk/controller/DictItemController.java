package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.query.DictItemQuery;
import top.imono.jk.pojo.result.R;
import top.imono.jk.service.DictItemService;

@Tag(name = "DictItemController", description = "查询管理数据字典")
@RestController
@RequestMapping("/dictItems")
public class DictItemController extends BaseController<DictItem> {
    @Autowired
    private DictItemService service;

    @Operation(summary = "查询数据字典值")
    @GetMapping
    public R list(DictItemQuery dictTypeQuery) {
        service.list(dictTypeQuery);
        return Rs.success(dictTypeQuery);
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }


    @Override
    protected IService<DictItem> getService() {
        return service;
    }
}
