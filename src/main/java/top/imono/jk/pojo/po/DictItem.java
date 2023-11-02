package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import top.imono.jk.common.foreign.anno.ForeignField;

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
    private String name;

    /**
     * 值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 序号，排列顺序，值越大越靠前
     */
    @TableField(value = "sn")
    private Integer sn;

    /**
     * 0启用，1禁用
     */
    @TableField(value = "disabled")
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
