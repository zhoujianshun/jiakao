package top.imono.jk.service;

import top.imono.jk.pojo.po.DictItem;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.query.DictItemQuery;

/**
* @author zhoujianshun
* @description 针对表【dict_item(数据字典条目)】的数据库操作Service
* @createDate 2023-10-26 16:26:19
*/
public interface DictItemService extends IService<DictItem> {

    void list(DictItemQuery dictTypeQuery);
}
