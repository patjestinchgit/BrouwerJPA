package be.brouwerijen.constraints;

import java.awt.font.NumericShaper.Range;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotBlank.List;
import org.hibernate.validator.constraints.NotEmpty;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = BeginNaamValidatorr.class)
@Constraint(validatedBy = {})
@NotEmpty
public @interface BeginNaamNotEmpty {
	@OverridesAttribute(constraint = NotEmpty.class, name = "message")
	String message() default "{be.brouwerijen.constraints.BeginNaam.IsNotEmpty}";

	/*
	 * @OverridesAttribute(constraint = Null.class, name = "message2") String
	 * message2() default "{be.vdab.constraints.BeginNaam.IsNull}";
	 * 
	 * @OverridesAttribute(constraint = List.class, name = "message3") String
	 * message3() default "{be.vdab.constraints.BeginNaam.NotBlank}";
	 */
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
