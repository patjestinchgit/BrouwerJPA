package be.brouwerijen.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.brouwerijen.valueobjects.BrouwersOpNaam;

public class BeginNaamSpatieValidator implements ConstraintValidator<BeginNaamSpatie, BrouwersOpNaam> {
	private static final String stringpattern = "^((?!.[\\d\\s]).)*$";
	
	@Override
	public void initialize(BeginNaamSpatie arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(BrouwersOpNaam beginnaam, ConstraintValidatorContext context) {
		boolean returner= true;
		Pattern pattern = Pattern.compile(stringpattern);
		Matcher matcher= pattern.matcher(beginnaam.getBeginnaam());
		
		//if(beginnaam.getBeginnaam().matches(stringpattern)) returner= false; //&& !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		if(beginnaam.getBeginnaam().isBlank() && beginnaam.getBeginnaam().length()>0) returner= false; //&& !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		return returner;
	}


}
