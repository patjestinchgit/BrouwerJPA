package be.brouwerijen.constraints.brouwer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;

import org.hibernate.validator.constraints.Range;

//enkele imports uit java.lang.annotation en uit javax.validation
/*@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)

@Constraint(validatedBy = PostcodeValidator.class)
*/

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})

public @interface BrouwerAnnation {

	@OverridesAttribute(constraint = Range.class, name = "message")
	String message() default "{be.vdab.constraints.brouwer}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};

}
