package top.imono.jk.pojo.vo.req.list;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.springdoc.core.annotations.ParameterObject;

import java.io.Serializable;

/*
* 基本的分页查询对象
* 可以继承该对象，增加查询功能
* */
@ParameterObject
@Data
public class PageReqVo implements Serializable {
    @Parameter(description = "查询页码，1开始", example = "1")
    private long page;
    @Parameter(description = "每页数量，默认10", example = "10")
    private long size = 10;


    public long getPage() {
        return Math.max(1, page);
    }

    public long getSize() {
        return Math.max(1, size);
    }
}
