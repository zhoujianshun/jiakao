package top.imono.jk.service;

import top.imono.jk.pojo.po.ExamPlaceCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.req.list.ExamPlaceCourseListReqVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceCourseVo;
import top.imono.jk.pojo.vo.resp.PageVo;

/**
* @author zhoujianshun
* @description 针对表【exam_place_course(考场课程)】的数据库操作Service
* @createDate 2023-11-02 14:31:21
*/
public interface ExamPlaceCourseService extends IService<ExamPlaceCourse> {

    PageVo<ExamPlaceCourseVo> list(ExamPlaceCourseListReqVo reqVo);
}
