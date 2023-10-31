package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.imono.jk.common.exception.CommonException;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.pojo.result.R;

import java.util.Arrays;

public abstract class BaseController<T> {
    protected abstract IService<T> getService();
    @PostMapping("/save")
    public R save(T item) {
        boolean result = getService().saveOrUpdate(item);
        if (result) {
            return Rs.success("保存成功").setData(item);
        }
        // 使用统一错误处理
        throw new CommonException("保存失败");
    }

    @DeleteMapping("/remove")
    public R remove(String ids) {
        boolean result = getService().removeByIds(Arrays.stream(ids.split(",")).toList());
        if (result) {
            return Rs.success(true,"删除成功");
        }
        throw new CommonException("删除失败");
    }
}
