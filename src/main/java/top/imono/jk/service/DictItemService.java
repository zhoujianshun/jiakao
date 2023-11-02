package top.imono.jk.service;

import top.imono.jk.pojo.po.DictItem;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.list.DictItemPageReqVo;
import top.imono.jk.pojo.vo.resp.DictItemVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;

/**
* @author zhoujianshun
* @description 针对表【dict_item(数据字典条目)】的数据库操作Service
* @createDate 2023-10-26 16:26:19
*/
public interface DictItemService extends IService<DictItem> {

    ListJsonVo<DictItemVo> list(DictItemPageReqVo dictTypeQuery);
}
