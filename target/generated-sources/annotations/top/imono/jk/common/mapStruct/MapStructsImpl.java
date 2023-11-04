package top.imono.jk.common.mapStruct;

import javax.annotation.processing.Generated;
import top.imono.jk.pojo.po.DictItem;
import top.imono.jk.pojo.po.DictType;
import top.imono.jk.pojo.po.ExamPlace;
import top.imono.jk.pojo.po.ExamPlaceCourse;
import top.imono.jk.pojo.po.PlateRegion;
import top.imono.jk.pojo.po.SysUser;
import top.imono.jk.pojo.vo.req.save.DictItemReqVo;
import top.imono.jk.pojo.vo.req.save.DictTypeReqVo;
import top.imono.jk.pojo.vo.req.save.ExamPlaceCourseReqVo;
import top.imono.jk.pojo.vo.req.save.ExamPlaceReqVo;
import top.imono.jk.pojo.vo.req.save.PlateRegionReqVo;
import top.imono.jk.pojo.vo.resp.DictItemVo;
import top.imono.jk.pojo.vo.resp.DictTypeVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceCourseVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceVo;
import top.imono.jk.pojo.vo.resp.LoginVo;
import top.imono.jk.pojo.vo.resp.PlateRegionVo;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-04T13:49:14+0800",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
public class MapStructsImpl implements MapStructs {

    @Override
    public DictItem reqVo2po(DictItemReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        DictItem dictItem = new DictItem();

        dictItem.setId( reqVo.getId() );
        dictItem.setName( reqVo.getName() );
        dictItem.setValue( reqVo.getValue() );
        dictItem.setSn( reqVo.getSn() );
        dictItem.setDisabled( reqVo.getDisabled() );
        dictItem.setTypeId( reqVo.getTypeId() );

        return dictItem;
    }

    @Override
    public DictType reqVo2po(DictTypeReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        DictType dictType = new DictType();

        dictType.setId( reqVo.getId() );
        dictType.setName( reqVo.getName() );
        dictType.setValue( reqVo.getValue() );
        dictType.setIntro( reqVo.getIntro() );

        return dictType;
    }

    @Override
    public ExamPlace reqVo2po(ExamPlaceReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        ExamPlace examPlace = new ExamPlace();

        examPlace.setId( reqVo.getId() );
        examPlace.setName( reqVo.getName() );
        examPlace.setProvinceId( reqVo.getProvinceId() );
        examPlace.setCityId( reqVo.getCityId() );
        examPlace.setAddress( reqVo.getAddress() );
        examPlace.setLatitude( reqVo.getLatitude() );
        examPlace.setLongitude( reqVo.getLongitude() );

        return examPlace;
    }

    @Override
    public ExamPlaceCourse reqVo2po(ExamPlaceCourseReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        ExamPlaceCourse examPlaceCourse = new ExamPlaceCourse();

        examPlaceCourse.setId( reqVo.getId() );
        examPlaceCourse.setName( reqVo.getName() );
        examPlaceCourse.setPrice( reqVo.getPrice() );
        if ( reqVo.getType() != null ) {
            examPlaceCourse.setType( reqVo.getType().intValue() );
        }
        examPlaceCourse.setIntro( reqVo.getIntro() );
        examPlaceCourse.setCover( reqVo.getCover() );
        examPlaceCourse.setPlaceId( reqVo.getPlaceId() );

        return examPlaceCourse;
    }

    @Override
    public PlateRegion reqVo2po(PlateRegionReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        PlateRegion plateRegion = new PlateRegion();

        plateRegion.setId( reqVo.getId() );
        plateRegion.setName( reqVo.getName() );
        plateRegion.setParentId( reqVo.getParentId() );
        plateRegion.setPlate( reqVo.getPlate() );

        return plateRegion;
    }

    @Override
    public ExamPlaceVo po2vo(ExamPlace po) {
        if ( po == null ) {
            return null;
        }

        ExamPlaceVo examPlaceVo = new ExamPlaceVo();

        examPlaceVo.setId( po.getId() );
        examPlaceVo.setName( po.getName() );
        examPlaceVo.setProvinceId( po.getProvinceId() );
        examPlaceVo.setCityId( po.getCityId() );
        examPlaceVo.setAddress( po.getAddress() );
        examPlaceVo.setLatitude( po.getLatitude() );
        examPlaceVo.setLongitude( po.getLongitude() );

        return examPlaceVo;
    }

    @Override
    public DictItemVo po2vo(DictItem po) {
        if ( po == null ) {
            return null;
        }

        DictItemVo dictItemVo = new DictItemVo();

        dictItemVo.setId( po.getId() );
        dictItemVo.setName( po.getName() );
        dictItemVo.setValue( po.getValue() );
        dictItemVo.setSn( po.getSn() );
        dictItemVo.setDisabled( po.getDisabled() );
        dictItemVo.setTypeId( po.getTypeId() );

        return dictItemVo;
    }

    @Override
    public DictTypeVo po2vo(DictType po) {
        if ( po == null ) {
            return null;
        }

        DictTypeVo dictTypeVo = new DictTypeVo();

        dictTypeVo.setId( po.getId() );
        dictTypeVo.setName( po.getName() );
        dictTypeVo.setValue( po.getValue() );
        dictTypeVo.setIntro( po.getIntro() );

        return dictTypeVo;
    }

    @Override
    public ExamPlaceCourseVo po2vo(ExamPlaceCourse po) {
        if ( po == null ) {
            return null;
        }

        ExamPlaceCourseVo examPlaceCourseVo = new ExamPlaceCourseVo();

        examPlaceCourseVo.setId( po.getId() );
        examPlaceCourseVo.setName( po.getName() );
        examPlaceCourseVo.setPrice( po.getPrice() );
        if ( po.getType() != null ) {
            examPlaceCourseVo.setType( po.getType().shortValue() );
        }
        examPlaceCourseVo.setPlaceId( po.getPlaceId() );
        examPlaceCourseVo.setIntro( po.getIntro() );
        examPlaceCourseVo.setCreateTime( po.getCreateTime() );
        examPlaceCourseVo.setVideo( po.getVideo() );
        examPlaceCourseVo.setCover( po.getCover() );

        return examPlaceCourseVo;
    }

    @Override
    public PlateRegionVo po2vo(PlateRegion po) {
        if ( po == null ) {
            return null;
        }

        PlateRegionVo plateRegionVo = new PlateRegionVo();

        plateRegionVo.setId( po.getId() );
        plateRegionVo.setName( po.getName() );
        plateRegionVo.setParentId( po.getParentId() );
        plateRegionVo.setPlate( po.getPlate() );

        return plateRegionVo;
    }

    @Override
    public LoginVo po2loginVo(SysUser po) {
        if ( po == null ) {
            return null;
        }

        LoginVo loginVo = new LoginVo();

        loginVo.setId( po.getId() );
        loginVo.setUsername( po.getUsername() );
        loginVo.setNickname( po.getNickname() );

        return loginVo;
    }
}
