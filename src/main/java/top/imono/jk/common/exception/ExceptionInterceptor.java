package top.imono.jk.common.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.imono.jk.pojo.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import top.imono.jk.common.utils.Rs;


/*
 * 统一处理异常
 * */
@RestControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public R handle(Throwable t) {
//        System.out.println(t.toString());
        // 设置返回数据格式
        log.error("ExceptionInterceptor handle", t);
        return Rs.error(t);
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
