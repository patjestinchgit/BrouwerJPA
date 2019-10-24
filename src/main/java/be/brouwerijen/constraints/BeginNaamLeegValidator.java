package be.brouwerijen.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.brouwerijen.valueobjects.BrouwersOpNaam;

public class BeginNaamLeegValidator implements ConstraintValidator<BeginNaamLeeg, BrouwersOpNaam> {
	@Override
	public void initialize(BeginNaamLeeg arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(BrouwersOpNaam beginnaam, ConstraintValidatorContext context) {
		boolean returner= true;
		if(beginnaam.getBeginnaam().length()==0) returner= false; //&& !(beginnaam.isBlank()) && !(beginnaam.isEmpty())
		return returner;
	}


}
