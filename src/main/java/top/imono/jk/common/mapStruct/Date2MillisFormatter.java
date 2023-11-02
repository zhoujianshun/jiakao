package top.imono.jk.common.mapStruct;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
/*
* 自定义类型转换 Date to Long
**/
class Date2MillisFormatter {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface Date2Millis {}
    @Date2Millis
    public static Long date2Millis(Date date) {
        if (date == null) return null;
        return date.getTime();
    }
}

