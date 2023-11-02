package top.imono.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.common.enhance.MpQueryWrapper;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.pojo.vo.resp.PlateRegionVo;
import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.vo.req.list.ProvincesPageReqVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;
import top.imono.jk.service.PlateRegionService;
import top.imono.jk.mapper.PlateRegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【plate_region(省份、城市)】的数据库操作Service实现
* @createDate 2023-10-30 18:42:07
*/
@Service
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion>
    implements PlateRegionService{

    @Override
    public ListJsonVo<PlateRegionVo> listProvinces(ProvincesPageReqVo provincesQuery) {
        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        /*对上面关键字查询进行分装*/
        wrapper.like(provincesQuery.getKeyword(),
                PlateRegion::getName,
                PlateRegion::getPlate,
                PlateRegion::getPinyin);
        //        通过id排序
        wrapper.orderByDesc(PlateRegion::getId);

        return baseMapper.selectPage(new MpPage<>(provincesQuery), wrapper)
                .buildListJsonVo(MapStructs.INSTANCE::po2vo);
    }

    @Override
    public List<ProvinceVo> listRegions() {
        return baseMapper.selectRegions();
    }
}




