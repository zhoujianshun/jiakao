package top.imono.jk.common.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SaTokenException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.imono.jk.common.utils.JsonVos;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.resp.json.JsonVo;

import java.util.List;


/*
 * 统一处理异常
 * */
@RestControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(Throwable.class)
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public JsonVo handle(Throwable t, HttpServletResponse response) {
        // 设置返回数据格式
//        log.error("ExceptionInterceptor handle", t);
        t.printStackTrace();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        if (t instanceof CommonException e) {
            int code = e.getCode();
            // 如果错误码在400-499，设置
            if (code >= 400 && code < 500) {
                response.setStatus(code);
            }
            return handleCommonException(e);
        } else if (t instanceof BindException be) {
            List<ObjectError> allErrors = be.getBindingResult().getAllErrors();
            List<String> defaultMsg = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
            return JsonVos.error(msg);
        } else if (t instanceof ConstraintViolationException cve) {
            List<String> defaultMsg = cve.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
            return JsonVos.error(msg);
        }
//        else if (t instanceof NotPermissionException || t instanceof NotRoleException) {
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            return JsonVos.error(CodeMsg.NO_PERMISSION);
//        }
//        else if (t instanceof AuthorizationException) {
//            response.setStatus(HttpStatus.FORBIDDEN.value());
//            return JsonVos.error(CodeMsg.NO_PERMISSION);
//        }

        // 处理其他异常
        Throwable cause = t.getCause();
        if (cause != null) {
            return handle(cause, response);
        }
        // 处理没有cause的异常
        return JsonVos.error(t.getMessage());
    }

    private JsonVo handleCommonException(CommonException e) {
        return JsonVos.error(e.getCode(), e.getMessage());
    }

    // 全局异常拦截（拦截项目中的NotPermissionException\NotRoleException异常）
    @ExceptionHandler({NotPermissionException.class, NotRoleException.class})
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    public JsonVo handlerNotPermissionException(SaTokenException ste)
            throws Exception {
        ste.printStackTrace();
        return JsonVos.error(CodeMsg.NO_PERMISSION);
    }


    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public JsonVo handlerNotLoginException(NotLoginException nle)
            throws Exception {

        // 打印堆栈，以供调试
        nle.printStackTrace();

        // 判断场景值，定制化异常信息
        String message = "";
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未能读取到有效 token";
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token 无效";
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token 已过期";
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token 已被顶下线";
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token 已被踢下线";
        } else if (nle.getType().equals(NotLoginException.TOKEN_FREEZE)) {
            message = "token 已被冻结";
        } else if (nle.getType().equals(NotLoginException.NO_PREFIX)) {
            message = "未按照指定前缀提交 token";
//            message = "token 无效";
        } else {
            message = "当前会话未登录";
        }

        // 返回给前端
        return JsonVos.error(HttpStatus.UNAUTHORIZED.value(), message);
    }


//    @ExceptionHandler(Throwable.class)
//    public void handle(Throwable t, HttpServletRequest request, HttpServletResponse response) throws IOException {
////        System.out.println(t.toString());
//        // 设置返回数据格式
//        response.setContentType("application/json; charset=UTF-8");
//        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
//        response.setStatus(CodeMsg.BAD_REQUEST.getCode());
//        response.getWriter().write(Rs.error(t).jsonString());
//        if(Debugs.DEBUG){
//            t.printStackTrace();
//        }
//
//    }
}
