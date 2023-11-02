package top.imono.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.po.ExamPlaceCourse;
import top.imono.jk.pojo.vo.req.list.ExamPlaceCourseListReqVo;
import top.imono.jk.pojo.vo.req.save.ExamPlaceCourseReqVo;
import top.imono.jk.pojo.vo.resp.ExamPlaceCourseVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;
import top.imono.jk.service.ExamPlaceCourseService;

@RestController
@RequestMapping("/examPlaceCourses")
@Tag(name = "科2科3课程", description = "查询科2科3课程")
public class ExamplePlaceCourseController extends BaseController<ExamPlaceCourse, ExamPlaceCourseReqVo> {
    @Autowired
    private ExamPlaceCourseService service;

    @GetMapping
    @Operation(summary = "分页查询科2科3课程")
    public ListJsonVo<ExamPlaceCourseVo> list(@Valid ExamPlaceCourseListReqVo reqVo) {
        return JsonVos.success(service.list(reqVo));
    }

    @Override
    protected IService<ExamPlaceCourse> getService() {
        return service;
    }

    @Override
    protected ExamPlaceCourse getPo(ExamPlaceCourseReqVo reqV) {
        return MapStructs.INSTANCE.reqVo2po(reqV);
    }

}
