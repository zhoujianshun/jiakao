package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统用户")
public class SysUserVo {
    @Schema(description = "id")
    private Integer id;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "账号的状态【0是正常，1是锁定】")
    private Short status;

    @Schema(description = "最后一次登录的时间")
    private Long loginTime;
}
