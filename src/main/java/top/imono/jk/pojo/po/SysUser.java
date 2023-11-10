package top.imono.jk.pojo.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户（可以登录后台系统的）
 *
 * @TableName sys_user
 */
@Schema(description = "用户信息")
@TableName(value = "sys_user")
@Data
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    @Schema(description = "用户名")
    @TableField(value = "nickname")
    private String nickname;

    /**
     * 登录用的用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 登录用的密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 创建的时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 最后一次登录的时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    /**
     * 账号的状态，0是正常，1是锁定
     */
    @TableField(value = "status")
    private Integer status;

    @Hidden
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Hidden
    @TableLogic(value = "0", delval = "1") // 局部配置逻辑删除
    @TableField(select = false)
    private short isDeleted;
}
