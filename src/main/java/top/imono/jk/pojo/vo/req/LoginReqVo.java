package top.imono.jk.pojo.vo.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Schema(description = "用户登录信息")
@Data
public class LoginReqVo {
    @Schema(description = "用户名【不能为空】")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @Schema(description = "密码【不能为空】")
    @NotBlank(message = "密码不能为空")
    private String password;

//    @Schema(description = "验证码【不能为空】")
//    @NotBlank(message = "验证码不能为空")
//    private String captcha;

    @Schema(description="记住密码")
    private boolean rememberMe;
}
