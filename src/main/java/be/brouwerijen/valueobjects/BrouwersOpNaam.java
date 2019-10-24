package be.brouwerijen.valueobjects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.NotBlank.List;
import org.springframework.beans.factory.annotation.Value;

import be.brouwerijen.constraints.BeginNaamLeeg;
import be.brouwerijen.constraints.BeginNaamLeegGetalSpatie;
import be.brouwerijen.constraints.BeginNaamNotBlank;
import be.brouwerijen.constraints.BeginNaamNotEmpty;
import be.brouwerijen.constraints.BeginNaamNotNull;
import be.brouwerijen.constraints.BeginNaamPattern;
import be.brouwerijen.constraints.BeginNaamSpatie;

//@BeginNaamLeegGetalSpatie
@BeginNaamLeeg
@BeginNaamSpatie
public class BrouwersOpNaam {
	/*
	 * @NotNull
	 * 
	 * @List(value = { @NotBlank })
	 */
	//@BeginNaamNotEmpty()
	//@BeginNaamPattern()
	//@BeginNaamNotBlank()
	@SafeHtml
	private String beginnaam;

	/**
	 * @return the beginnaam
	 */
	public String getBeginnaam() {
		return beginnaam;
	}

	/**
	 * @param beginnaam the beginnaam to set
	 */
	public void setBeginnaam(String beginnaam) {
		this.beginnaam = beginnaam;
	}
	
}
