package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 资源
 * @TableName sys_resource
 */
@TableName(value ="sys_resource")
@Data
public class SysResource implements Serializable {
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
     * 链接地址
     */
    @TableField(value = "uri")
    private String uri;

    /**
     * 权限标识
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 资源类型（0是目录，1是菜单，2是目录）
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 序号
     */
    @TableField(value = "sn")
    private Integer sn;

    /**
     * 父资源id
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}