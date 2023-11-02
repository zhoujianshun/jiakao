package top.imono.jk.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/*
 * 对Mybatis Plus的LambdaQueryWrapper功能进行增强
 * */
public class MpLambdaQueryWrapper<T> extends LambdaQueryWrapper<T> {

    @SafeVarargs
    public final MpLambdaQueryWrapper<T> like(Object val, SFunction<T, ?>... funcs) {
        if (val == null) {
            return this;
        }
        String str = val.toString();
        if (str.length() == 0) {
            return this;
        }

        // nested方法作用时将查询条件使用括号包裹，防止最后一个or，起作用
        return (MpLambdaQueryWrapper<T>) nested(w -> {
            for (SFunction<T, ?> func : funcs) {
                w.like(func, str).or();
            }
        });
    }
}
