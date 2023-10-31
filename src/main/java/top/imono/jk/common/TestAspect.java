package top.imono.jk.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import top.imono.jk.common.foreign.anno.ForeignCascade;
import top.imono.jk.common.foreign.anno.ForeignField;
import top.imono.jk.common.foreign.info.ForeignFieldInfo;
import top.imono.jk.common.foreign.info.ForeignTableInfo;
import top.imono.jk.common.utils.Classes;
import top.imono.jk.common.utils.Rs;
import top.imono.jk.common.utils.Strings;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Aspect
@Component
@Slf4j
public class TestAspect  {

    @Around("execution(* top.imono.jk.controller..*.*(..))")
    public Object handleRemove(ProceedingJoinPoint point) throws Throwable {
        log.debug(point.toString());
        return point.proceed();
    }

}
