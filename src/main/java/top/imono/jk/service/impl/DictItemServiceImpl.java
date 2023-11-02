package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.vo.req.list.DictItemPageReqVo;
import top.imono.jk.pojo.vo.resp.DictItemVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.service.DictItemService;
import top.imono.jk.mapper.DictItemMapper;
import org.springframework.stereotype.Service;

/**
 * @author zhoujianshun
 * @description 针对表【dict_item(数据字典条目)】的数据库操作Service实现
 * @createDate 2023-10-26 16:26:19
 */
@Service
@Transactional
public class DictItemServiceImpl extends ServiceImpl<DictItemMapper, DictItem>
        implements DictItemService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictItemVo> list(DictItemPageReqVo dictTypeQuery) {
        MpLambdaQueryWrapper<DictItem> wrapper = new MpLambdaQueryWrapper<>();

        /*对上面关键字查询进行分装*/
        wrapper.like(dictTypeQuery.getKeyword(),
                DictItem::getName,
                DictItem::getValue);
//
        Integer typeId = dictTypeQuery.getTypeId();
        if (typeId != null && typeId > 0) {
            wrapper.eq(DictItem::getTypeId, dictTypeQuery.getTypeId());
        }
        //        通过id排序
        wrapper.orderByDesc(DictItem::getId);

        return baseMapper.selectPage(new MpPage<>(dictTypeQuery), wrapper)
                .buildPageVo(MapStructs.INSTANCE::po2vo);
    }
}




