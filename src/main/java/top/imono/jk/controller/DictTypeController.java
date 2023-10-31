package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.pojo.query.DictTypeQuery;
import top.imono.jk.pojo.result.R;
import top.imono.jk.service.DictTypeService;

@Tag(name = "数据字典类型", description = "查询管理数据字典类型")
@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType> {
    @Autowired
    private DictTypeService service;

    @Operation(summary = "查询数据字典类型", description = "管理员访问")
    @GetMapping
    public R list(@Parameter(description = "查询参数") DictTypeQuery dictTypeQuery) {
        service.list(dictTypeQuery);
        return Rs.success(dictTypeQuery);
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @Override
    protected IService<DictType> getService() {
        return service;
    }

    @Operation(summary = "删除数据字典类型", description = "管理员访问")
    @Override
    public R remove(@Parameter(description = "字符串，多个id用'，'分割") String ids) {
        return super.remove(ids);
    }

    //    @PostMapping("/save")
//    public R save(DictType dictType) {
//        boolean result = service.saveOrUpdate(dictType);
//        if (result) {
//            return Rs.success(service.getById(dictType.getId()), "保存成功");
////            return new R().setSuccess(true)
////                    .setMsg("保存成功")
////                    .setContent(service.getById(dictType.getId()));
//        }
//        // 使用统一错误处理
//        throw new CommonException("保存失败");
////        return Rs.error("保存失败");
////        return new R().setSuccess(false).setMsg("保存失败");
//    }
//
//    @DeleteMapping("/delete")
//    public R delete(String ids) {
//        boolean result = service.removeBatchByIds(Arrays.stream(ids.split(",")).toList());
//        if (result) {
//            return Rs.success(true,"删除成功");
////            return new R().setSuccess(true).setMsg("删除成功").setContent(true);
//        }
//        throw new CommonException("删除失败");
////        return Rs.error("删除失败");
////        return new R().setSuccess(false).setMsg("删除失败");
//    }
}
