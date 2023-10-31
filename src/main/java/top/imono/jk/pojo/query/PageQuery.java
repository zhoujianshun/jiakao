package top.imono.jk.pojo.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/*
* 基本的分页查询对象
* 可以继承该对象，增加查询功能
* */
@Schema(description = "分页查询参数")
@Data
public class PageQuery {
    @Schema(description = "查询页码，1开始")
    private long page;
    @Schema(description = "每页数量，默认10")
    private long size = 10;

    /**
     * 当前这一页的数据
     * */
    private List<?> content;

    /**
     * 总数
     * */
    private long count;

    /*
    * 总页数
    * */
    private  long pages;

    public long getPage() {
        return Math.max(1, page);
    }

    public long getSize() {
        return Math.max(1, size);
    }
}
