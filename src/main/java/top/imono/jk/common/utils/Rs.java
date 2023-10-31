package top.imono.jk.common.utils;

import top.imono.jk.common.exception.CommonException;
import top.imono.jk.pojo.result.CodeMsg;
import top.imono.jk.pojo.result.R;

public class Rs {

    public static R error(String msg) {
        return new R().setSuccess(false).setMsg(msg);
    }

    public static R error() {
        return new R().setSuccess(false);
    }

    public static R error(Throwable t) {
        if (t instanceof CommonException) {
            CommonException e = (CommonException) t;
            R r = new R();
            r.setMsg(e.getMessage());
            r.setCode(e.getCode());
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
