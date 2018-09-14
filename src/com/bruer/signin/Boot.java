package com.bruer.signin;

import java.io.File;

public class Boot {
	private static boolean isDebug = true;
	public static Display display = new Display();
	private static AutoLogout autoLogout;
	private static Config config = new Config();
	public static void main(String[] args) {
		if (args.length != 0 && args[0].equals("windows")) {
			config.getConfigsFromFile(new File("D:\\git\\FRC Signin System\\configs.csv"));
		} else {
			config.getConfigsFromFile(new File("D:\\git\\FRC Signin System\\configs.csv"));
		}
		autoLogout = new AutoLogout(config.autoLogout[0],config.autoLogout[1]);
		display.addUserInputListener(new UserInput() {
			@Override
			public void onInput(String input) {
				try {
					loginUser(Integer.parseInt(input.trim()));
				} catch (Exception e) {
					switch (input.toLowerCase().replaceFirst("\\*", "")) {
						case "0000":
							System.exit(0);
						case "0":
							display.clearOutput();
							break;
						case "1":
							String time = TimeManager.calendarToString(TimeManager.getCurrentTime());
							String[] timeArray = time.split(":");
							for (int i = 0; i < timeArray.length; i++) {
								timeArray[i] = String.format("%02.0f", Double.parseDouble(timeArray[i]));
							}
							display.addOutputLine(timeArray[0] + ":" + timeArray[1] + ":" + timeArray[2] + " " + timeArray[3] + "/"+ timeArray[4] + "/" + timeArray[5]);
							break;
						case "":
							display.addOutputLine(":::::::::::::MENU:::::::::::::");
							display.addOutputLine("-    (*0) clear input");
							display.addOutputLine("-    (*1) Save the current time in the outputbox");
							display.addOutputLine("-    (**) Look up user based on partial ID. **1234");
							display.addOutputLine("-    (*0000) exit");
							break;
						default:
							if (input.contains("**")) {
								String id = input.replaceFirst("\\*\\*", "");
								display.addOutputLine("Finding All Users Containing: " + id);
							} else {
								debugPrint("NO COMMAND FOUND");
							}
					}
				}
			}
		});
		while (true) {
			display.updateTimeBox();
			autoLogout.update();
		}
	}
	
	public static void loginUser(int id) {
		display.addOutputLine("Logging in User");
	}
	
	public static void debugPrint(String print) {
		if (isDebug) {
			display.addOutputLine("[DEBUG]: " + print);
		} 
	}
}
