package top.imono.jk.pojo.vo.req.list;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceCourseListReqVo extends KeywordPageReqVo {
    @Parameter(description = "课程类型")
    private Short type;

    @Parameter(description = "省份id")
    private Integer provinceId;

    @Parameter(description = "城市id")
    private Integer cityId;

    @Parameter(description = "考场id")
    private Integer placeId;
}
