package top.imono.jk.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.imono.jk.pojo.result.CodeMsg;

@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {
    private int code;

    public CommonException() {
        this(CodeMsg.BAD_REQUEST.getCode(), null);
    }

    public CommonException(String msg) {
        this(msg, null);
    }

    public CommonException(int code, String msg) {
        this(code, msg, null);
    }

    public CommonException(String msg, Throwable cause) {
        this(CodeMsg.BAD_REQUEST.getCode(), msg, cause);
    }

    public CommonException(int code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }

    public CommonException(CodeMsg codeMsg) {
        this(codeMsg, null);
    }

    public CommonException(CodeMsg codeMsg, Throwable cause) {
        this(codeMsg.getCode(), codeMsg.getMsg(), cause);
    }

    public int getCode() {
        return code;
    }
}
