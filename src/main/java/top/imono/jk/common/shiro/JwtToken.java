package top.imono.jk.common.shiro;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;
import top.imono.jk.common.utils.JwtUtil;

/**
 * 继承AuthenticationToken，跟TokenRealmh中的doGetAuthenticationInfo的参数类型保持一致
 */
@Data
public class JwtToken implements AuthenticationToken {
    private String username;
    private String token;

    public JwtToken(String token){
        this.token = token;
        JwtUtil jwtUtil = new JwtUtil();
        this.username = jwtUtil.getClaimFiled(token, "username");
    }

    /**
     * 类似用户名
     * @return
     */
    @Override
    public Object getPrincipal() {
        return username;
    }

    /**
     * 类似密码
     * @return
     */
    @Override
    public Object getCredentials() {
        return token;
    }
}
