package top.imono.jk.pojo.vo.resp.json;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "响应结果，带数据")
public class DataJsonVo<T> extends JsonVo {

    @Schema(description ="具体数据")
    private T data;

    public DataJsonVo(T data){
        super(true);
        this.data = data;
    }

    public DataJsonVo(){
        super();
    }
}
