package top.imono.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class KeywordQuery extends PageQuery{
    private String keyword;
}
