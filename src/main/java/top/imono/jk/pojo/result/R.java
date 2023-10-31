package top.imono.jk.pojo.result;

import top.imono.jk.common.enhance.Jsonabel;

import java.util.HashMap;

/*
 * 返回用户的JSON对象
 * */
public class R extends HashMap<String, Object> implements Jsonabel {
    private static final String K_CODE = "code";
    private static final String K_MSG = "msg";
    private static final String K_DATA = "data";
    /*
    * 表示成功code
    * */
    private static final int CODE_SUCCESS = CodeMsg.OPERATE_OK.getCode();
    /*
    * 默认失败code
    * */
    private static final int CODE_ERROR_DEFAULT = CodeMsg.BAD_REQUEST.getCode();

    public R setSuccess(boolean success) {
        if (success) {
            return setCode(CODE_SUCCESS);
        } else {
            return setCode(CODE_ERROR_DEFAULT);
        }
    }

    public R setCode(int code) {
        put(K_CODE, code);
        return this;
    }

    public R setMsg(String msg) {
        put(K_MSG, msg);
        return this;
    }

    public R setData(Object data) {
        put(K_DATA, data);
        return this;
    }
}
