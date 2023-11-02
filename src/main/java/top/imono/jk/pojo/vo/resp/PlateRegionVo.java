package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 省份、城市
 */
@Schema(description = "省份、城市")
@Data
public class PlateRegionVo implements Serializable {
    /**
     * id
     */
    @Schema(description = "省份、城市")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "省份、城市名称")
    @NotBlank
    private String name;

    /**
     * 父区域
     */
    @Schema(description = "省份、城市父区域")
    private Integer parentId;

    /**
     * 车牌，比如省份是粤、琼、赣，城市是A、B、C、D
     */
    @Schema(description = "省份、城市车牌，比如省份是粤、琼、赣，城市是A、B、C、D")
    private String plate;

}
