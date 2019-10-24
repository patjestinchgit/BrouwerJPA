package be.brouwerijen.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.brouwerijen.valueobjects.BrouwersOpNaam;

public class BeginNaamLeegGetalSpatieValidator implements ConstraintValidator<BeginNaamLeegGetalSpatie, BrouwersOpNaam> {
	private static final String stringpattern = "^[^0-9]+$";
	@Override
	public void initialize(BeginNaamLeegGetalSpatie arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(BrouwersOpNaam beginnaam, ConstraintValidatorContext context) {
		Pattern pattern = Pattern.compile(stringpattern);
		Matcher matcher= pattern.matcher(beginnaam.getBeginnaam());
		boolean returner= false;
		if(beginnaam.getBeginnaam().matches(stringpattern) || (beginnaam.getBeginnaam().isEmpty()) || (beginnaam.getBeginnaam().isEmpty() )) returner= true; //&& !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		return returner;
	}


}
