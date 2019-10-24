/**
 * 
 */
package be.brouwerijen.entities;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.brouwerijen.constraints.brouwer.BrouwerAnnation;
import be.brouwerijen.constraints.brouwer.BrouwerPatternBrouwer;
import be.brouwerijen.valueobjects.Adres;

/**
 * @author patrick
 *
 */
@BrouwerPatternBrouwer
@Entity 
@Table(name = "brouwers")
public class Brouwer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@SafeHtml
	@Length(min = 1, max = 50)
	//@BrouwerAnnation
	private String naam;
	@NumberFormat(style = Style.NUMBER) // opmaak annotation die er al stond
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal omzet;
	@Valid
	@Embedded
	private Adres adres;
	
	private static long serialVersionUID= 1L;
	
	public Brouwer(Long id, String naam, BigDecimal omzet, Adres adres) {
		this.id = id;
		this.naam = naam;
		this.omzet = omzet;
		this.setAdres(adres);
	}
	
	public Brouwer() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public BigDecimal getOmzet() {
		return omzet;
	}

	public void setOmzet(BigDecimal omzet) {
		this.omzet = omzet;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Brouwer.serialVersionUID = serialVersionUID;
	}

	/**
	 * @return the adres
	 */
	public Adres getAdres() {
		return adres;
	}

	/**
	 * @param adres the adres to set
	 */
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	
}
