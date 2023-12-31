package top.imono.jk.common.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.imono.jk.common.mapStruct.MapStructs;
import top.imono.jk.pojo.vo.req.list.PageReqVo;
import top.imono.jk.pojo.vo.resp.PageVo;
import top.imono.jk.pojo.vo.resp.json.ListJsonVo;

import java.util.List;
import java.util.function.Function;

/*
 * 对Mybatis Plus的Page功能进行增强
 * */
public class MpPage<T> extends Page<T> {

    private final PageReqVo pageReqVo;

    public MpPage(PageReqVo pageReqVo) {
        super(pageReqVo.getPage(), pageReqVo.getSize());
        this.pageReqVo = pageReqVo;
    }


    public PageVo<T> buildPageVo() {
        pageReqVo.setPage(getCurrent());
        pageReqVo.setSize(getSize());

        PageVo<T> vo = new PageVo<>();
        List<T> records = getRecords();
        vo.setData(records);
        vo.setTotalCount(getTotal());
        vo.setPages(getPages());
        vo.setPage(getCurrent());
        vo.setPageSize(getSize());
        return vo;
    }

    public <V> PageVo<V> buildPageVo(Function<T, V> function) {
        pageReqVo.setPage(getCurrent());
        pageReqVo.setSize(getSize());

        PageVo<V> vo = new PageVo<>();
        List<T> records = getRecords();
        // T 转为 V
        List<V> list = records.stream().map(function).toList();
        vo.setData(list);
        vo.setTotalCount(getTotal());
        vo.setPages(getPages());
        vo.setPage(getCurrent());
        vo.setPageSize(getSize());
        return vo;
    }

}
