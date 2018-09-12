package com.bruer.signin;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Display {
	private JFrame frame;
	private JTextField inputBox;
	private UserInput userInput;
	public Display() {
		frame = new JFrame();
		frame.setSize(200, 200);
		inputBox = new JTextField();
		inputBox.setSize(200, 50);
		frame.add(inputBox);
		frame.setVisible(true);
	}
	public void addUserInputListener(UserInput userInput) {
		this.userInput = userInput;
		inputBox.addKeyListener(new KeyListener() {
			@Override public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					userInput.onInput(inputBox.getText());
					inputBox.setText("");
				}
			}
			@Override public void keyReleased(KeyEvent e) {}
			@Override public void keyTyped(KeyEvent e) {}
		});
	}
}
