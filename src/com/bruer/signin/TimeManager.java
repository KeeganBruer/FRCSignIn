package com.bruer.signin;

import java.util.Calendar;
import java.util.Date;

public class TimeManager {
	public static Calendar getCurrentTime() {
		return Calendar.getInstance();
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
