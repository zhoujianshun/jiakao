package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import top.imono.jk.common.foreign.anno.ForeignField;
import top.imono.jk.common.validator.BoolNumber;

/**
 * 数据字典条目
 *
 * @TableName dict_item
 */
@TableName(value = "dict_item")
@Data
public class DictItem implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    @NotBlank(message = "名称不能为空")
    private String name;

    /**
     * 值
     */
    @TableField(value = "value")
    @NotBlank(message = "值不能为空")
    private String value;

    /**
     * 序号，排列顺序，值越大越靠前
     */
    @TableField(value = "sn")
    @Min(value = 0, message = "序号不能是负数")
    private Integer sn;

    /**
     * 0启用，1禁用
     */
    @TableField(value = "disabled")
    @BoolNumber(message = "disable只能是0或者1") // 自定义校验
    private Integer disabled;


    /**
     * 所属类型id
     */
    @ForeignField(DictType.class)
    @TableField(value = "type_id")
    private Integer typeId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
