package com.lfj.blog.common.validator.annotation;

import com.lfj.blog.common.validator.IsPhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 是否手机号注解
 * <p>
 * 2019-10-04 09:57
 */
@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsPhoneValidator.class)
public @interface IsPhone {
	boolean required() default true;

	String message() default "手机号格式不正确";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
