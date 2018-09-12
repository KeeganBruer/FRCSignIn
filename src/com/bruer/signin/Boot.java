package com.bruer.signin;

import java.util.Calendar;

public class Boot {
	private static Display display = new Display();
	public static void main(String[] args) {
		Calendar standpoint = TimeManager.getCurrentTime();
		display.addUserInputListener(new UserInput() {
			@Override
			public void onInput(String input) {
				System.out.println("Input: " + input + "");
			}
		});
	}
}
