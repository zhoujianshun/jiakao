package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import top.imono.jk.common.foreign.anno.ForeignField;

/**
 * 角色-资源
 * @TableName sys_role_resource
 */
@TableName(value ="sys_role_resource")
@Data
public class SysRoleResource implements Serializable {
    /**
     * 资源id
     */
    @ForeignField(SysResource.class)
    private Integer resourceId;

    /**
     * 角色id
     */
    @ForeignField(SysRole.class)
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
