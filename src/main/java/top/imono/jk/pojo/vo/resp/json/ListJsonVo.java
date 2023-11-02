package top.imono.jk.pojo.vo.resp.json;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "列表返回值")
public class ListJsonVo<T> extends DataJsonVo<List<T>>{

    @Schema(description = "当前页")
    private Long page;

    @Schema(description = "每页数")
    private Long pageSize;

    @Schema(description = "总数")
    private Long totalCount;

    @Schema(description = "总页数")
    private Long pages;

    public ListJsonVo(){
        super();
    }

    public ListJsonVo(List<T> data){
        super(data);
    }
}
