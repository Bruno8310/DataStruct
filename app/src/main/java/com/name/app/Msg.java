package com.name.app;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义一个注解
 * 1.用来标记哪个元素---@Target()
 * 2.存货周期---@Retention()
 * @author Bruno
 *
 */
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.CLASS)
public @interface Msg {

	
}
