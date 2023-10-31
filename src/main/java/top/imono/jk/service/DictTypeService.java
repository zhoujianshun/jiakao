package top.imono.jk.service;

import top.imono.jk.pojo.po.DictType;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.query.DictTypeQuery;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【dict_type(数据字典类型)】的数据库操作Service
* @createDate 2023-10-26 16:26:19
*/
public interface DictTypeService extends IService<DictType> {

    void list(DictTypeQuery dictTypeQuery);
}
