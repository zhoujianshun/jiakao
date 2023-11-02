package top.imono.jk.pojo.vo.resp.json;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.imono.jk.pojo.result.CodeMsg;

@Data
@Schema(description = "响应结果")
public class JsonVo {

    @Schema(description = "代码【20000代表成功，非20000代表错误】")
    private Integer code;

    @Schema(description = "描述信息")
    private String msg;


    /*
     * 表示成功code
     * */
    private static final int CODE_SUCCESS = CodeMsg.OPERATE_OK.getCode();
    /*
     * 默认失败code
     * */
    private static final int CODE_ERROR = CodeMsg.BAD_REQUEST.getCode();

    public JsonVo() {
        this(true);
    }

    public JsonVo(boolean success) {
        this(success, null);
    }

    public JsonVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonVo(boolean success, String msg) {
        this(success ? CODE_SUCCESS : CODE_ERROR, msg);
    }

    public JsonVo(CodeMsg codeMsg) {
        this(codeMsg.getCode(), codeMsg.getMsg());
    }
}
