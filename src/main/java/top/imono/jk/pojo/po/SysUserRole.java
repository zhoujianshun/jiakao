package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;
import top.imono.jk.common.foreign.anno.ForeignField;

/**
 * 用户-角色
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class SysUserRole implements Serializable {
    /**
     * 用户id
     */
    @ForeignField(SysUser.class)
    private Integer userId;

    /**
     * 角色id
     */
    @ForeignField(SysRole.class)
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
