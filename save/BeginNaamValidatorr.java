package be.brouwerijen.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.brouwerijen.valueobjects.BrouwersOpNaam;

public class BeginNaamValidatorr implements ConstraintValidator< BeginNaam, String> {
	private static final String stringpattern = "^[^0-9]+$";

	@Override
	public void initialize(BeginNaam beginnaam) {
	}

	@Override
	public boolean isValid(String beginnaam, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(stringpattern);
		Matcher matcher= pattern.matcher(beginnaam);
		boolean returner= false;
		if(beginnaam.matches(stringpattern) || (beginnaam.isBlank()) || (beginnaam.isEmpty() )) returner= true; //&& !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		return returner;
	}
}
