package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.enhance.MpQueryWrapper;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.query.DictItemQuery;
import top.imono.jk.service.DictItemService;
import top.imono.jk.mapper.DictItemMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
    public void list(DictItemQuery dictTypeQuery) {
        MpQueryWrapper<DictItem> wrapper = new MpQueryWrapper<>();

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


        baseMapper.selectPage(new MpPage<>(dictTypeQuery), wrapper)
                .updateQuery(dictTypeQuery);
    }
}




