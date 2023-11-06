package top.imono.jk.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.imono.jk.filter.ErrorFilter;

// ErrorFilter转发过来的
@Tag(name = "处理拦截器错误")
@RestController
public class ErrorController {

    @SecurityRequirements()
    @RequestMapping(ErrorFilter.ERROR_URI)
    public void handleError(HttpServletRequest request) throws Exception {
        throw  (Exception) request.getAttribute(ErrorFilter.ERROR_URI);
    }
}
