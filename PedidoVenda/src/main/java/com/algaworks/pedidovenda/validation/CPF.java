package com.algaworks.pedidovenda.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")
public @interface CPF {
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{com.algaworks.constraints.CPF.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
