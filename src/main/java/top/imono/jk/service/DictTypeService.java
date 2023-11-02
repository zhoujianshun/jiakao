package top.imono.jk.service;

import top.imono.jk.pojo.po.DictType;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.list.DictTypePageReqVo;
import top.imono.jk.pojo.vo.resp.DictTypeVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;

/**
* @author zhoujianshun
* @description 针对表【dict_type(数据字典类型)】的数据库操作Service
* @createDate 2023-10-26 16:26:19
*/
public interface DictTypeService extends IService<DictType> {

    PageVo<DictTypeVo> list(DictTypePageReqVo dictTypeQuery);
}
