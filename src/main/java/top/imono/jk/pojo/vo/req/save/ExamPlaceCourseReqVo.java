package top.imono.jk.pojo.vo.req.save;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Range;
import top.imono.jk.pojo.vo.req.list.KeywordPageReqVo;

import java.math.BigDecimal;

@Schema
@EqualsAndHashCode(callSuper = true)
@Data
public class ExamPlaceCourseReqVo extends KeywordPageReqVo {

    @Schema(description = "id【大于0代表更新，否则代表添加】")
    private Integer id;

    @Schema(description = "名称【不能为空】")
    @NotBlank(message = "名称不能为空")
    private String name;

    @Schema(description = "价格【必须大于等于0】")
    @Min(value = 0, message = "价格必须大于等于0")
    private BigDecimal price;

    @Schema(description = "类型【0是课程合集，2是科目2，3是科目3】")
    @NotNull
    @Range(min = 0, max = 3, message = "0是课程合集，2是科目2，3是科目3")
    private Short type;

    @Schema(description = "考场id【必须大于等于1】")
    @NotNull
    @Min(value = 1, message = "考场id必须大于等于1")
    private Integer placeId;

    @Schema(description = "封面地址")
    private String cover;

    @Schema(description = "简介")
    private String intro;
}
