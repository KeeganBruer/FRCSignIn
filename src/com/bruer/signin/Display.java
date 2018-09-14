package com.bruer.signin;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Display {
	private JFrame frame;
	private JTextField inputBox;
	private JTextArea outputBox;
	private JTextField clockBox;
	public Display() {
		frame = new JFrame();
		double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		frame.setSize((int)width, (int)height);
		frame.setLayout(null);
		frame.setUndecorated(true);
		inputBox = new JTextField();
		inputBox.setSize(frame.getWidth()*3/4, frame.getHeight()/10);
		inputBox.setLocation(frame.getWidth()/8, frame.getHeight()/10);
		inputBox.setFont(new Font(inputBox.getFont().getFontName(), Font.PLAIN, inputBox.getHeight()));
		frame.add(inputBox);
		clockBox = new JTextField();
		clockBox.setSize(frame.getWidth()/3, frame.getHeight()/20);
		clockBox.setLocation(frame.getWidth()*2/6, frame.getHeight()/5 + clockBox.getHeight()/2);
		clockBox.setFont(new Font(clockBox.getFont().getFontName(), Font.PLAIN, clockBox.getHeight()));
		clockBox.setHorizontalAlignment(JTextField.CENTER);
		clockBox.setEditable(false);
		frame.add(clockBox);
		outputBox = new JTextArea();
		outputBox.setSize(frame.getWidth()*3/4, frame.getHeight() * 6/10);
		outputBox.setLocation(frame.getWidth()/8, frame.getHeight()* 3/10);
		outputBox.setFont(new Font(outputBox.getFont().getFontName(), Font.PLAIN, frame.getHeight()/32));
		outputBox.setEditable(false);
		frame.add(outputBox);
		frame.setVisible(true);
	}
	public void addUserInputListener(UserInput userInput) {
		inputBox.addKeyListener(new KeyListener() {
			@Override public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (inputBox.getText().equals("exit")) {
						System.exit(0);
					}
					userInput.onInput(inputBox.getText());
					inputBox.setText("");
				}
			}
			@Override public void keyReleased(KeyEvent e) {}
			@Override public void keyTyped(KeyEvent e) {}
		});
	}
	
	public void addOutputLine(String text) {
		String content = outputBox.getText();
		if (content.equals("")) {
			System.out.println("Output");
			for (int i = 0; i < (outputBox.getFont().getSize()/2.2)-1; i++) {
				content += "\n";
			}
			outputBox.setText(content + text);
		} else {
			String[] allContent = content.split("\n");
			for (int i = 0; i < allContent.length-1; i++) {
				allContent[i] = allContent[i+1]; 
			}
			allContent[allContent.length-1] = text;
			content = allContent[0];
			for (int i = 1; i < allContent.length; i++) {
				content += "\n" + allContent[i];
			}
			outputBox.setText(content);
		}
	}
	
	public void updateTimeBox() {
		String time = TimeManager.calendarToString(TimeManager.getCurrentTime());
		String[] timeArray = time.split(":");
		for (int i = 0; i < timeArray.length; i++) {
			timeArray[i] = String.format("%02.0f", Double.parseDouble(timeArray[i]));
		}
		clockBox.setText(timeArray[0] + ":" + timeArray[1] + ":" + timeArray[2] + " " + timeArray[3] + "/"+ timeArray[4] + "/" + timeArray[5]);
	}
	
	public void clearOutput() {
		outputBox.setText("");
	}
}
