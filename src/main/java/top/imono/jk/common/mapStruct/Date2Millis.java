package top.imono.jk.common.mapStruct;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

@Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface Date2Millis {
    class Date2MillisFormatter {
        @Date2Millis
        public static Long date2Millis(Date date) {
            if (date == null) return null;
            return date.getTime();
        }
    }
}
