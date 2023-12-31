package top.imono.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/*
 * 对Mybatis Plus的LambdaQueryWrapper功能进行增强
 * */
public class MpQueryWrapper<T> extends QueryWrapper<T> {

    @SafeVarargs
    public final MpQueryWrapper<T> like(Object val, String ...columns) {
        if (val == null) {
            return this;
        }
        String str = val.toString();
        if (str.length() == 0) {
            return this;
        }

        // nested方法作用时将查询条件使用括号包裹，防止最后一个or，起作用
        return (MpQueryWrapper<T>) nested(w -> {
            for (String column : columns) {
                w.like(column, str).or();
            }
        });
    }
}
