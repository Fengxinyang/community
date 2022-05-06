package com.nowcoder.community.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要登录
 */
@Target(ElementType.METHOD)//标识该注解用于方法
@Retention(RetentionPolicy.RUNTIME)//标识该注解在运行时有效
public @interface LoginRequired {
}
