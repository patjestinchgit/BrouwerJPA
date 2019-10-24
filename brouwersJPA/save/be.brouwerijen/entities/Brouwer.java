/**
 * 
 */
package be.brouwerijen.entities;

import be.brouwerijen.valueobjects.Adres;

/**
 * @author patrick
 *
 */
public class Brouwer {
	
	private Long brouwerNr;
	private String naam;
	private Integer omzet;
	private Adres adres;
	
	private static long serialVersionUID= 1L;
	
	public Brouwer(Long brouwerNr, String naam, Integer omzet, Adres adres) {
		this.brouwerNr = brouwerNr;
		this.naam = naam;
		this.omzet = omzet;
		this.setAdres(adres);
	}

	public Long getBrouwerNr() {
		return brouwerNr;
	}

	public void setBrouwerNr(Long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
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
