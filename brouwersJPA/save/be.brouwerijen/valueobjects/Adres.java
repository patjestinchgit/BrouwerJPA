package be.brouwerijen.valueobjects;

import java.io.Serializable;

public class Adres implements Serializable{
	
	private String straat;
	private String huisNr;
	private int postCode;
	private String gemeente;
	
	private static long serialVersionUID= 1L;
	
	public Adres(String straat, String huisNr, int postCode, String gemeente) {
		
		this.straat = straat;
		this.huisNr = huisNr;
		this.postCode = postCode;
		this.gemeente = gemeente;
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
		return postCode;
	}

	public void setPostcode(int postCode) {
		this.postCode = postCode;
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
