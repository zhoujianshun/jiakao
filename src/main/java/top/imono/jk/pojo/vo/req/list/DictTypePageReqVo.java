package top.imono.jk.pojo.vo.req.list;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springdoc.core.annotations.ParameterObject;

/*
* 自定义的字典类型查询对象
* */
@ParameterObject
@EqualsAndHashCode(callSuper = true)
@Data
public class DictTypePageReqVo extends KeywordPageReqVo {
}
