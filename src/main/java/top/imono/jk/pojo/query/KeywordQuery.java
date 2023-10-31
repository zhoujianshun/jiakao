package top.imono.jk.pojo.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema(description = "关键字查询参数")
@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordQuery extends PageQuery{
    @Schema(name="keyword", description = "关键词")
    private String keyword;
}
