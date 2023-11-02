package top.imono.jk.pojo.vo.req.save;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import top.imono.jk.common.validator.BoolNumber;

import java.io.Serializable;

/**
 * 数据字典条目
 *
 */
@Schema(description = "字典值")
@Data
public class DictItemReqVo implements Serializable {
    /**
     * id
     */
    @Schema(description = "字典值id")
    private Integer id;

    /**
     * 名称
     */
    @Schema(description = "字典值名称")
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 值
     */
    @Schema(description = "字典值")
    @NotBlank(message = "值不能为空")
    private String value;

    /**
     * 序号，排列顺序，值越大越靠前
     */
    @Schema(description = "字典值序号，排列顺序，值越大越靠前")
    @Min(value = 0, message = "序号不能是负数")
    private Integer sn;

    /**
     * 0启用，1禁用
     */
    @Schema(description = "0启用，1禁用")
    @BoolNumber(message = "disable只能是0或者1") // 自定义校验
    private Integer disabled;

    /**
     * 所属类型id
     */
    @Schema(description = "字典类型id")
    @NotNull
    private Integer typeId;

}
