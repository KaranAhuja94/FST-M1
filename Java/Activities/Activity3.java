package activities;

import java.text.DecimalFormat;

public class Activity3 {
	
	public static void main(String[] args) {
		
		double ageInSeconds = 1000000000;
		
		double earthSeconds = 31557600;
		double mercurySeconds = 0.2408467;
		double venusSeconds = 0.61519726;
		double marsSeconds = 1.8808158;
		double jupiterSeconds = 11.862615;
		double saturnSeconds = 29.447498;
		double uranusSeconds = 84.016846;
		double neptuneSeconds = 164.79132;
		
		DecimalFormat decimalFormatObj = new DecimalFormat("0.00");
		
		
		System.out.println("Age on Mercury: " + decimalFormatObj.format (ageInSeconds / earthSeconds / mercurySeconds));
		System.out.println("Age on Venus: " + decimalFormatObj.format (ageInSeconds / earthSeconds / venusSeconds));
		System.out.println("Age on Mars: " + decimalFormatObj.format (ageInSeconds / earthSeconds / marsSeconds));
		System.out.println("Age on Jupiter: " + decimalFormatObj.format (ageInSeconds / earthSeconds / jupiterSeconds));
		System.out.println("Age on Saturn: " + decimalFormatObj.format (ageInSeconds / earthSeconds / saturnSeconds));
		System.out.println("Age on Uranus: " + decimalFormatObj.format (ageInSeconds / earthSeconds / uranusSeconds));
		System.out.println("Age on Neptune: " + decimalFormatObj.format (ageInSeconds / earthSeconds / neptuneSeconds));
		
	}
	
	
}
