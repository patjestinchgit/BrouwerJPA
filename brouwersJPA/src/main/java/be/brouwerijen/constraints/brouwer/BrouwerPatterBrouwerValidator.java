package be.brouwerijen.constraints.brouwer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.brouwerijen.entities.Brouwer;

public class BrouwerPatterBrouwerValidator implements ConstraintValidator<BrouwerPatternBrouwer, Brouwer> {
	private static final String stringpattern = "^^Brouwer+$";

	@Override
	public void initialize(BrouwerPatternBrouwer arg0) {
	}

	@Override
	public boolean isValid(Brouwer brouwer, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(stringpattern);
		boolean returner = true;
		if (brouwer.getNaam().matches(stringpattern)) returner = false; // && !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		return returner;
	}
}
