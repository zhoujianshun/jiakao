package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.pojo.query.DictTypeQuery;
import top.imono.jk.pojo.result.R;
import top.imono.jk.service.DictTypeService;

@RestController
@RequestMapping("/dictTypes")
public class DictTypeController extends BaseController<DictType> {
    @Autowired
    private DictTypeService service;

    @GetMapping
    public R list(DictTypeQuery dictTypeQuery) {
        service.list(dictTypeQuery);
        return Rs.success(dictTypeQuery);
//        return new R().setSuccess(true).setContent(dictTypeQuery);
    }

    @Override
    protected IService<DictType> getService() {
        return service;
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
