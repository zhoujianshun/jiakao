package top.imono.jk.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import top.imono.jk.common.enhance.MpPage;
import top.imono.jk.pojo.po.ExamPlaceCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.imono.jk.pojo.vo.resp.ExamPlaceCourseVo;
import top.imono.jk.pojo.vo.resp.PageVo;

/**
* @author zhoujianshun
* @description 针对表【exam_place_course(考场课程)】的数据库操作Mapper
* @createDate 2023-11-02 14:31:21
* @Entity top.imono.jk.pojo.po.ExamPlaceCourse
*/
public interface ExamPlaceCourseMapper extends BaseMapper<ExamPlaceCourse> {

    MpPage<ExamPlaceCourseVo> select(MpPage<ExamPlaceCourseVo> mpPage, @Param(Constants.WRAPPER) QueryWrapper<ExamPlaceCourse> wrapper);
}




