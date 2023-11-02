package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * 数据字典条目
 *
 */
@Schema(description = "字典值")
@Data
public class DictItemVo implements Serializable {
    /**
     * id
     */
    @Schema(description = "字典值id")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "字典值名称")
    private String name;

    /**
     * 值
     */
    @Schema(description = "字典值")
    private String value;

    /**
     * 序号，排列顺序，值越大越靠前
     */
    private Integer sn;

    /**
     * 0启用，1禁用
     */
    @Schema(description = "0启用，1禁用")
    private Integer disabled;

    /**
     * 所属类型id
     */
    @Schema(description = "字典类型id，0启用，1禁用")
    @Min(value = 1, message = "字典类型id必须大于等于1")
    private Integer typeId;

}
