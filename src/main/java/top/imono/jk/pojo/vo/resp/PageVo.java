package top.imono.jk.pojo.vo.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "列表返回值")
public class PageVo<T> {

    @Schema(description = "当前页")
    private Long page;

    @Schema(description = "每页数")
    private Long pageSize;

    @Schema(description = "总数")
    private Long totalCount;

    @Schema(description = "总页数")
    private Long pages;

    @Schema(description = "具体数据")
    private List<T> data;
}
