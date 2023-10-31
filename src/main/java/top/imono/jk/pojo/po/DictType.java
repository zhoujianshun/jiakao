package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 数据字典类型
 * @TableName dict_type
 */
@TableName(value ="dict_type")
@Data
public class DictType implements Serializable {
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
     * 简介
     */
    @TableField(value = "intro")
    private String intro;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
