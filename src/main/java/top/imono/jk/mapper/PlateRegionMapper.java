package top.imono.jk.mapper;

import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.po.PlateRegion;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【plate_region(省份、城市)】的数据库操作Mapper
* @createDate 2023-10-30 18:42:07
* @Entity top.imono.jk.pojo.po.PlateRegion
*/
public interface PlateRegionMapper extends BaseMapper<PlateRegion> {

    List<ProvinceVo> selectRegions();
}




