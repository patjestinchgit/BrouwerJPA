package be.brouwerijen.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
class IndexServiceImpl implements IndexService {

	@Override
	public String getGreetings(String timeclient) {
		// TODO Auto-generated method stub
		System.out.println("lijn 33 time "+ timeclient);
		String hHmmSS="";
		String clientgreetings="";
		Pattern pattern = Pattern.compile("\\d\\d:\\d\\d:\\d\\d");
		Matcher matcher = pattern.matcher(timeclient);
		while(matcher.find()) {
			System.out.println(matcher.group().toString());
			hHmmSS= matcher.group().toString();
		}
		int hoursclient= Integer.parseInt(Character.toString(hHmmSS.charAt(0))+Character.toString(hHmmSS.charAt(1)));
		int minutesclient= Integer.parseInt(Character.toString(hHmmSS.charAt(3))+Character.toString(hHmmSS.charAt(4)));
		int secondsclient= Integer.parseInt(Character.toString(hHmmSS.charAt(6))+Character.toString(hHmmSS.charAt(7)));
		System.out.println("lijn 33 time "+ hHmmSS+" "+timeclient+" "+hoursclient);

		if((hoursclient >= 0) && (hoursclient < 6)) clientgreetings= "goodnight";
		else if((hoursclient >= 6) && (hoursclient < 12)) clientgreetings="goodmorning";
		else if((hoursclient >= 12) && (hoursclient < 18)) clientgreetings= "goodafternoon";
		else if((hoursclient >= 18) && ((hoursclient <= 23)&& (minutesclient <= 59) && (secondsclient <=59))) clientgreetings= "goodevening";
		else clientgreetings= "hello";		
		
		return clientgreetings;
	}

	@Override
	public String setTimePictureFirst(String clientgreetings) {
		// TODO Auto-generated method stub
		return null;
	}

}
