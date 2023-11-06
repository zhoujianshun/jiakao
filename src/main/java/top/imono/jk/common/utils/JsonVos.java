package top.imono.jk.common.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import top.imono.jk.common.exception.CommonException;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.json.DataJsonVo;
import top.imono.jk.pojo.vo.resp.json.JsonVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;

import java.util.List;

public class JsonVos {

    public static JsonVo success(CodeMsg codeMsg) {
        return new JsonVo(codeMsg);
    }

    public static JsonVo error(String msg) {
        return new JsonVo(false, msg);
    }

    public static JsonVo error(CodeMsg codeMsg) {
        return new JsonVo(codeMsg);
    }

    public static JsonVo error() {
        return new JsonVo(false);
    }

    public static JsonVo error(Integer code,String msg) {
        return new JsonVo(code, msg);
    }

//    public static JsonVo error(Throwable t) {
//        if (t instanceof CommonException e) {
//            JsonVo r = new JsonVo(false);
//            r.setMsg(e.getMessage());
//            r.setCode(e.getCode());
//            return r;
//        }else if (t instanceof BindException be) {
//            JsonVo r = new JsonVo(false);
//            List<ObjectError> allErrors = be.getBindingResult().getAllErrors();
//            List<String> defaultMsg = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
//            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
//            r.setMsg(msg);
//            return r;
//        } else if (t instanceof ConstraintViolationException cve) {
//            JsonVo r = new JsonVo(false);
//            List<String> defaultMsg =  cve.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
//            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
//            r.setMsg(msg);
//            return r;
//        } else {
////            return error();
//            return error(t.getMessage());
//        }
//    }

    public static <T> DataJsonVo<T> success(T data) {
        return new DataJsonVo<>(data);
    }

    public static <T> ListJsonVo<T> success(PageVo<T> pageVo) {
        ListJsonVo<T> r = new ListJsonVo<>(pageVo.getData());
        r.setPage(pageVo.getPage());
        r.setPageSize(pageVo.getPageSize());
        r.setPages(pageVo.getPages());
        r.setTotalCount(pageVo.getTotalCount());
        return r;
    }

    public static JsonVo success() {
        return new JsonVo(true);
    }

    public static <T> T raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static <T> T raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }
}
