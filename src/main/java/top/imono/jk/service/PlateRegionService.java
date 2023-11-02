package top.imono.jk.service;

import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.PlateRegionVo;
import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.po.PlateRegion;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.vo.req.list.ProvincesPageReqVo;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【plate_region(省份、城市)】的数据库操作Service
* @createDate 2023-10-30 18:42:07
*/
public interface PlateRegionService extends IService<PlateRegion> {

    PageVo<PlateRegionVo> listProvinces(ProvincesPageReqVo provincesQuery);

    List<ProvinceVo> listRegions();
}
