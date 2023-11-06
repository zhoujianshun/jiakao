package top.imono.jk.common.exception;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import io.jsonwebtoken.security.SignatureException;
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
        log.error("ExceptionInterceptor handle", t);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        if (t instanceof CommonException e) {
            int code = e.getCode();
            // 如果错误码在400-499，设置
            if(code >= 400 && code < 500){
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
