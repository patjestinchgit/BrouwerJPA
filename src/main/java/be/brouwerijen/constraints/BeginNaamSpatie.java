package be.brouwerijen.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=BeginNaamSpatieValidator.class)
public @interface BeginNaamSpatie {
	String message() default "{be.brouwerijen.constraints.BeginNaam.IsOnlySpaces}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
