package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.enhance.MpLambdaQueryWrapper;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.pojo.vo.req.list.DictTypePageReqVo;
import top.imono.jk.pojo.vo.resp.DictTypeVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.service.DictTypeService;
import top.imono.jk.mapper.DictTypeMapper;
import org.springframework.stereotype.Service;


/**
 * @author zhoujianshun
 * @description 针对表【dict_type(数据字典类型)】的数据库操作Service实现
 * @createDate 2023-10-26 16:26:19
 */
@Service
@Transactional
public class DictTypeServiceImpl extends ServiceImpl<DictTypeMapper, DictType>
        implements DictTypeService {

    @Override
    @Transactional(readOnly = true)
    public PageVo<DictTypeVo> list(DictTypePageReqVo dictTypeQuery) {
        MpLambdaQueryWrapper<DictType> wrapper = new MpLambdaQueryWrapper<>();
//        String keyword = dictTypeQuery.getKeyword();
//        if (StringUtils.hasLength(keyword)) {
//            wrapper.like(DictType::getName, keyword).or()
//                    .like(DictType::getIntro, keyword).or()
//                    .like(DictType::getValue, keyword);
//        }
        /*对上面关键字查询进行分装*/
        wrapper.like(dictTypeQuery.getKeyword(), DictType::getName, DictType::getIntro, DictType::getValue);

//        wrapper.eq(DictType::getId,'1');
        //        通过id排序
        wrapper.orderByDesc(DictType::getId);

//        MpPage<DictType> page = new MpPage<>(dictTypeQuery);
//        mapper.selectPage(page, wrapper);
//        page.updateQuery(dictTypeQuery);
//        简化写法，等同于上面三行
        return baseMapper.selectPage(new MpPage<>(dictTypeQuery), wrapper)
                .buildPageVo(MapStructs.INSTANCE::po2vo);
    }


//    @Override
//    public boolean removeByIds(Collection<?> list) {
//        return super.removeByIds(list);
//    }
}




