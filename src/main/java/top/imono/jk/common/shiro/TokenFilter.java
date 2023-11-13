package top.imono.jk.common.shiro;


import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.springframework.util.StringUtils;
import top.imono.jk.common.utils.JwtUtil;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.result.CodeMsg;

import java.io.IOException;

@Slf4j
public class TokenFilter extends AccessControlFilter {


    /**
     * true表示允许通过，进入下一个链条调用
     * false表示不允许访问，会调用onAccessDenied方法，不会进入下一个链条调用
     * isAccessAllowed()判断是否携带了有效的JwtToken
     * onAccessDenied()是没有携带JwtToken的时候进行账号密码登录，登录成功允许访问，登录失败拒绝访问
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        /*
         * 做初步判断
         * 1. 返回true，shiro就直接允许访问url
         * 2. 返回false，shiro才会根据onAccessDenied的方法的返回值决定是否允许访问url
         *  这里先让它始终返回false来使用onAccessDenied()方法
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.debug("TokenFilter - isAccessAllowed - " + request.getRequestURI());
        return false;
    }


    /**
     * isAccessAllowed false时调用
     * true表示允许通过，进入下一个链条调用
     * false表示不允许访问，不会进入下一个链条调用
     *
     * @param servletRequest
     * @param servletResponse
     * @return 返回结果为true表明登录通过
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        /**
         *  跟前端约定将jwtToken放在请求的Header的Authorization中，Authorization:token
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.debug("TokenFilter - onAccessDenied - " + request.getRequestURI());
        String token = JwtUtil.getTokenFromRequest(request);
        if (!StringUtils.hasLength(token)) {
            return JsonVos.raise(CodeMsg.NO_TOKEN);
        }

//        log.debug("TokenFilter - onAccessDenied - " + request.getRequestURI());
//        String authHeader = request.getHeader(JwtUtil.HEADER);
//        if (authHeader == null || authHeader.length() <= JwtUtil.PREFIX.length()) {
//            return JsonVos.raise(CodeMsg.NO_TOKEN);
////            return false;
//        }
//        String token = authHeader.substring(JwtUtil.PREFIX.length() + 1);
        //如果token为空的话，返回true，交给控制层@RequiresAuthentication进行判断；也会达到没有权限的作用

        JwtToken jwtToken = new JwtToken(token);
        log.debug("TokenFilter - onAccessDenied - " + token);
        //鉴权,进行登录处理，委托realm进行登录认证，调用AccountRealm进行的认证
        getSubject(servletRequest, servletResponse).login(jwtToken);
//        try {
//            //进行登录处理，委托realm进行登录认证，调用AccountRealm进行的认证
//            getSubject(servletRequest, servletResponse).login(jwtToken);
//        } catch (Exception e) {
//            log.error("Subject login error:", e);
//            return false;
//        }
        //如果走到这里，那么就返回true，代表登录成功
        return true;
    }

    //登录失败要执行的方法
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpServletResponse.getWriter().print("login error");
    }
}
