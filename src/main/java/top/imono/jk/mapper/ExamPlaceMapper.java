package top.imono.jk.mapper;

import top.imono.jk.pojo.vo.resp.ProvinceVo;
import top.imono.jk.pojo.po.ExamPlace;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author zhoujianshun
* @description 针对表【exam_place(考场)】的数据库操作Mapper
* @createDate 2023-10-31 19:45:49
* @Entity top.imono.jk.pojo.po.ExamPlace
*/
public interface ExamPlaceMapper extends BaseMapper<ExamPlace> {

    List<ProvinceVo> selectRegionExamplePlaces();

}




