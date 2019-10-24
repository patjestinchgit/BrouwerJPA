package be.brouwerijen.constraints.brouwer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

// enkele imports uit java.lang.annotation en uit javax.validation
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BrouwerPatterBrouwerValidator.class)
public @interface BrouwerPatternBrouwer {
	String message() default "{be.brouwerijen.constraints.brouwer.BrouwerPatternBrouwer}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}