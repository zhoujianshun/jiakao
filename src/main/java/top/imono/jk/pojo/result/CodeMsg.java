package top.imono.jk.pojo.result;

public enum CodeMsg {
    BAD_REQUEST(400, "请求出错"),
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "禁止访问"),
    NOT_FOUND(404, "资源不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    OPERATE_OK(20000, "操作成功"),
    SAVE_OK(20000, "保存成功"),
    ADD_OK(20000, "添加成功"),
    REMOVE_OK(20000, "删除成功"),

    OPERATE_ERROR(40001, "操作失败"),
    SAVE_ERROR(40002, "保存失败"),
    ADD_ERROR(40002, "添加失败"),
    REMOVE_ERROR(40003, "删除失败"),
    UPLOAD_IMG_ERROR(40004, "图片上传失败"),

    WRONG_USERNAME(50001, "用户名不存在"),
    WRONG_PASSWORD(50002, "密码错误"),
    USER_LOCKED(50003, "用户被锁定，无法正常登录"),
    WRONG_CAPTCHA(50004, "验证码错误"),

    NO_TOKEN(401, "没有Token，请登录"),
    TOKEN_EXPIRED(401, "Token过期，请重新登录"),
    NO_PERMISSION(403, "没有相关的操作权限"),
    LOGIN_OTHER_DEVICE(401, "在已其他设备上登录了"),
    TOKEN_INVALID(401, "无效的Token，请重新登录");

    private final int code;
    private final String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
