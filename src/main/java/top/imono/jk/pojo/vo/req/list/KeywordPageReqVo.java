package top.imono.jk.pojo.vo.req.list;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordPageReqVo extends PageReqVo {
    @Parameter(name="keyword", description = "关键词", example = "南京")
    private String keyword;
}
