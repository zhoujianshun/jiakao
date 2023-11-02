package top.imono.jk.pojo.vo.req.save;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

/**
 * 省份、城市
 */
@Schema(description = "省份、城市")
@Data
public class PlateRegionReqVo implements Serializable {
    /**
     * id
     */
    @Schema(description = "省份、城市")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "省份、城市名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 父区域
     */
    @Schema(description = "省份、城市父区域")
    @NotNull(message = "父区域不能为空")
    @Min(value = 0, message = "父区域id必须大于等于0")
    private Integer parentId;

    /**
     * 车牌，比如省份是粤、琼、赣，城市是A、B、C、D
     */
    @Schema(description = "省份、城市车牌，比如省份是粤、琼、赣，城市是A、B、C、D")
    @NotBlank(message = "车牌不能为空")
    @Length(min = 1, max = 1, message = "车牌的长度必须是1")
    private String plate;

}
