package com.bruer.signin;

import java.util.Calendar;

public class TimeManager {
	public static Calendar getCurrentTime() {
		return Calendar.getInstance();
	}
	
	public static Calendar stringToCalendar(String calendar) {
		Calendar newCalendar = Calendar.getInstance();
		String[] in = calendar.split(":");
		newCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(in[0]));
		newCalendar.set(Calendar.MINUTE, Integer.parseInt(in[1]));
		newCalendar.set(Calendar.SECOND, Integer.parseInt(in[2]));
		newCalendar.set(Calendar.MONTH, Integer.parseInt(in[3]));
		newCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(in[4]));
		newCalendar.set(Calendar.YEAR, Integer.parseInt(in[5]));
		return newCalendar;
	}
	
	public static String calendarToString(Calendar calendar) {
		String output = "";
		output += calendar.get(Calendar.HOUR_OF_DAY) + ":";
		output += calendar.get(Calendar.MINUTE)+ ":";
		output += calendar.get(Calendar.SECOND)+ ":";
		output += calendar.get(Calendar.MONTH)+ ":";
		output += calendar.get(Calendar.DAY_OF_MONTH)+ ":";
		output += calendar.get(Calendar.YEAR);
		return output;
	}
	
	
	public static double[] getAbsoluteDifference(Calendar one, Calendar two) {
		double[] in = getDifference(one, two);
		double years = Math.abs(in[5]);
		double months = Math.abs(in[4]);
		double days = Math.abs(in[3]);
		double hours = Math.abs(in[2]);
		double minutes = Math.abs(in[1]);
		double seconds = Math.abs(in[0]);
		double[] difference = {seconds, minutes, hours, days, months, years};
		return difference;
	}
	
	public static double[] getDifference(Calendar one, Calendar two) {
		double years = one.get(Calendar.YEAR) - two.get(Calendar.YEAR);
		double months = one.get(Calendar.MONTH) - two.get(Calendar.MONTH); 
		double days = one.get(Calendar.DAY_OF_MONTH) - two.get(Calendar.DAY_OF_MONTH);
		double hours = one.get(Calendar.HOUR_OF_DAY) - two.get(Calendar.HOUR_OF_DAY);
		double minutes = one.get(Calendar.MINUTE) - two.get(Calendar.MINUTE);
		double seconds = one.get(Calendar.SECOND) - two.get(Calendar.SECOND);
		double[] difference = {seconds, minutes, hours, days, months, years};
		return difference;
	}
}
