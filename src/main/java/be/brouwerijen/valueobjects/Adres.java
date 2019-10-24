package be.brouwerijen.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;

import be.brouwerijen.constraints.postcode.Postcode;
@Embeddable
public class Adres implements Serializable{
	
	@NotBlank
	@SafeHtml
	@Length(min = 5, max = 50)
	private String straat;
	@NotBlank
	@SafeHtml
	@Length(min = 1, max = 7)
	@Pattern(regexp= "^([0-9]+.*?)$")
	private String huisNr;
	@NotNull
	@Range(min = 1000, max = 9999)
	@NumberFormat
	private int postcode;
	@NotBlank
	@SafeHtml
	@Length(min = 3, max = 50)
	private String gemeente;
	
	private static long serialVersionUID= 1L;
	
	public Adres(String straat, String huisNr, int postcode, String gemeente) {
		
		this.straat = straat;
		this.huisNr = huisNr;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	
	public Adres() {
		
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String gethuisNr() {
		return huisNr;
	}

	public void sethuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostCode(int postcode) {
		this.postcode = postcode;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	
	

}
