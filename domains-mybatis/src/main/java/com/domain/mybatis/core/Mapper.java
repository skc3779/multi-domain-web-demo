package com.domain.mybatis.core;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * MyBatis Mapper Marker Annotation
 *
 * {@link org.mybatis.spring.mapper.MapperScannerConfigurer}에 의해서 Mapper Bean으로 등록 되어야하는 대상으로 사용.
 * Mapper 인터페이스에 대한 marker Annotation(Single-value)으로 MyBatis 적용 방식 중 annotation을 사용한 방식에 대한 기준을 위해 사용된다.
 * Service에 injection을 위해 Component annotation을 사용하였다.
 * @author arawn.kr@gmail.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
