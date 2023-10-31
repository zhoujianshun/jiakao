package top.imono.jk.pojo.query;

import lombok.Data;

import java.util.List;

/*
* 基本的分页查询对象
* 可以继承该对象，增加查询功能
* */
@Data
public class PageQuery {
    private long page;
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
