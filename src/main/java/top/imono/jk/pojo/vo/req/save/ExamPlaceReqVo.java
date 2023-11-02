package top.imono.jk.pojo.vo.req.save;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 考场
 */
@Schema(description = "考场")
@Data
public class ExamPlaceReqVo implements Serializable {
    /**
     * 考场id
     */
    @Schema(description = "考场id")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "考场名称")
    @NotBlank(message = "考场不能为空")
    private String name;

    /**
     * 考场是哪个省份的
     */
    @Schema(description = "考场是哪个省份的")
    @NotNull(message = "省份不能为空")
    @Min(value = 1, message = "省份id必须大于等于1")
    private Integer provinceId;

    /**
     * 考场是哪个城市的
     */
    @Schema(description = "考场是哪个城市的")
    @NotNull(message = "城市不能为空")
    @Min(value = 1, message = "城市id必须大于等于1")
    private Integer cityId;

    /**
     * 考场的具体地址
     */
    @Schema(description = "考场的具体地址")
    private String address;

    /**
     * 纬度
     */
    @Schema(description = "考场纬度")
    private BigDecimal latitude;

    /**
     * 经度
     */
    @Schema(description = "考场经度")
    private BigDecimal longitude;

}
