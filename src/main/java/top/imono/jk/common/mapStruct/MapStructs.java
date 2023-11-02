package top.imono.jk.common.mapStruct;


import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.pojo.po.ExamPlace;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.vo.req.save.DictItemReqVo;
import top.imono.jk.pojo.vo.req.save.DictTypeReqVo;
import top.imono.jk.pojo.vo.req.save.ExamPlaceReqVo;
import top.imono.jk.pojo.vo.req.save.PlateRegionReqVo;
import top.imono.jk.pojo.vo.resp.DictItemVo;
import top.imono.jk.pojo.vo.resp.DictTypeVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceVo;
import top.imono.jk.pojo.vo.resp.PlateRegionVo;

@Mapper(uses = {
    Date2Millis.Date2MillisFormatter.class
})
public interface MapStructs {
    MapStructs INSTANCE = Mappers.getMapper(MapStructs.class);

    DictItem reqVo2po(DictItemReqVo reqVo);
    DictType reqVo2po(DictTypeReqVo reqVo);
    ExamPlace reqVo2po(ExamPlaceReqVo reqVo);
//    ExamPlaceCourse reqVo2po(ExamPlaceCourseReqVo reqVo);
    PlateRegion reqVo2po(PlateRegionReqVo reqVo);
//    SysResource reqVo2po(SysResourceReqVo reqVo);
//    SysRole reqVo2po(SysRoleReqVo reqVo);
//    SysUser reqVo2po(SysUserReqVo reqVo);
//
    ExamPlaceVo po2vo(ExamPlace po);
    DictItemVo po2vo(DictItem po);
    DictTypeVo po2vo(DictType po);
//    ExamPlaceCourseVo po2vo(ExamPlaceCourse po);
    PlateRegionVo po2vo(PlateRegion po);
//    SysResourceVo po2vo(SysResource po);
//    SysRoleVo po2vo(SysRole po);
//    @Mapping(source = "loginTime",
//            target = "loginTime",
//            qualifiedBy = Date2Millis.class)
//    SysUserVo po2vo(SysUser po);
//    LoginVo po2loginVo(SysUser po);
}
