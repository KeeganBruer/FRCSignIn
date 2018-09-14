package com.bruer.signin;

import java.util.Calendar;

public class AutoLogout {
	private int autoHour = 0;
	private int autoMinute = 0;
	private boolean isActivated = false;
	public AutoLogout(int hour, int minute) {
		this.autoHour = hour;
		this.autoMinute = minute;
	}
	public void update() {
		Calendar currentTime = TimeManager.getCurrentTime();
		if (currentTime.get(Calendar.HOUR_OF_DAY)== this.autoHour && currentTime.get(Calendar.MINUTE)== this.autoMinute && !isActivated) {
			Boot.display.addOutputLine(TimeManager.calendarToString(currentTime));
			try {Thread.sleep(1000);} catch (Exception e) {}
			isActivated = true;
		} else if (currentTime.get(Calendar.HOUR_OF_DAY)== this.autoHour && 
			currentTime.get(Calendar.MINUTE)== this.autoMinute) {	
		} else {
			isActivated = false;
		}
	}

}
