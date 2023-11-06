package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

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
    @TableId(value = "user_id")
    private Integer userId;

    /**
     * 角色id
     */
    @TableId(value = "role_id")
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}