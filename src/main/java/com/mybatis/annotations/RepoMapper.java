package com.mybatis.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2015-5-13.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RepoMapper {
}
