package be.brouwerijen.date;

import java.util.Date;

public class DateGetter {
	
	private static Date d; 
	
	public Date getD() {
		return d;
	}



	public DateGetter() {
		d= new Date();
	}
	
	
	
	public String toString() {
		return d.toString();
	}
}
