package top.imono.jk.common.utils;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import top.imono.jk.common.exception.CommonException;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.result.R;

import java.util.List;

public class Rs {

    public static R error(String msg) {
        return new R().setSuccess(false).setMsg(msg);
    }

    public static R error() {
        return new R().setSuccess(false);
    }

    public static R error(Throwable t) {
        if (t instanceof CommonException e) {
            R r = new R();
            r.setMsg(e.getMessage());
            r.setCode(e.getCode());
            return r;
        }else if (t instanceof BindException be) {
            R r = new R();
            List<ObjectError> allErrors = be.getBindingResult().getAllErrors();
            List<String> defaultMsg = allErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
            r.setMsg(msg).setSuccess(false);
            return r;
        } else if (t instanceof ConstraintViolationException cve) {
            R r = new R();
            List<String> defaultMsg =  cve.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
            String msg = StringUtils.collectionToDelimitedString(defaultMsg, ",");
            r.setMsg(msg).setSuccess(false);
            return r;
        } else {
//            return error();
            return error(t.getMessage());
        }
    }

    public static R success(Object data) {
        return new R().setSuccess(true).setData(data);
    }

    public static R success(Object data, String msg) {
        return new R().setSuccess(true).setData(data).setMsg(msg);
    }

    public static R success() {
        return new R().setSuccess(true);
    }

    public static R raise(String msg) throws CommonException {
        throw new CommonException(msg);
    }

    public static R raise(CodeMsg codeMsg) throws CommonException {
        throw new CommonException(codeMsg);
    }
}
