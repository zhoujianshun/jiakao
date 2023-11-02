package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 考场
 */
@Schema(description = "考场")
@Data
public class ExamPlaceVo implements Serializable {
    /**
     * 考场id
     */
    @Schema(description = "考场id")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "考场名称")
    private String name;

    /**
     * 考场是哪个省份的
     */
    @Schema(description = "考场是哪个省份的")
    private Integer provinceId;

    /**
     * 考场是哪个城市的
     */
    @Schema(description = "考场是哪个城市的")
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
