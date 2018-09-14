package com.bruer.signin;

import java.io.File;

import com.bracketTechnologies.spreadSheetReader.SpreadSheet;

public class Config {
	public int[] autoLogout = {0,0};
	
	public void getConfigsFromFile(File file) {
		SpreadSheet configs = new SpreadSheet(file);
		configs.importSpreadSheet(file);
		autoLogout[0] = Integer.parseInt(configs.getItem(1, 1).trim());
		autoLogout[1] = Integer.parseInt(configs.getItem(2, 1).trim());
	}
}
