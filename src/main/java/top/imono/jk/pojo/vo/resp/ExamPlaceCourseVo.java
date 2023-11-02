package top.imono.jk.pojo.vo.resp;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Schema(description = "科2科3课程")
@TableName("exam_place_course")
public class ExamPlaceCourseVo {
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "价格")
    private BigDecimal price;

    @Schema(description = "类型【0是课程合集，2是科目2，3是科目3】")
    private Short type;

    @Schema(description = "考场id")
    private Integer placeId;

    @Schema(description = "简介")
    private String intro;

    @Schema(description = "省份id")
    private Long provinceId;

    @Schema(description = "城市id")
    private Long cityId;

    @Schema(description = "创建时间")
    private Date createTime;

    @Schema(description = "视频地址")
    private String video;

    @Schema(description = "封面地址")
    private String cover;

    @Schema(description = "考场名称")
    private String examPlaceName;
    @Schema(description = "考场城市")
    private String city;
    @Schema(description = "考场省")
    private String province;
    @Schema(description = "考场地址")
    private String address;
}
