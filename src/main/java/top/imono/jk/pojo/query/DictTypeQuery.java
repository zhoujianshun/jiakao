package top.imono.jk.pojo.query;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
* 自定义的字典类型查询对象
* */
@Schema(description = "字典类型查询参数")
@EqualsAndHashCode(callSuper = true)
@Data
public class DictTypeQuery extends KeywordQuery{
}
