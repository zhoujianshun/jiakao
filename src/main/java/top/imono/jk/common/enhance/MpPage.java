package top.imono.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.imono.jk.pojo.query.PageQuery;

/*
* 对Mybatis Plus的Page功能进行增强
* */
public class MpPage<T> extends Page<T> {

    public MpPage(PageQuery pageQuery){
        super(pageQuery.getPage(),pageQuery.getSize());
    }

    public void updateQuery(PageQuery pageQuery){
        pageQuery.setContent(getRecords());
        pageQuery.setCount(getTotal());
        pageQuery.setPages(getPages());
        pageQuery.setPage(getCurrent());
        pageQuery.setSize(getSize());
    }

}
