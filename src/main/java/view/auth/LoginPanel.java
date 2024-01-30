package main.java.view.auth;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LoginPanel extends JPanel {
	
	private JLabel appTitle;
	private JLabel mailLabel;
	private JLabel passwordLabel;
	private JLabel copyrightLabel;
	private JTextField mailField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton forgotPasswordButton;
	private JButton closeAppButton;
	
	public LoginPanel() { init(); }
	
	public void init(){
		
		/* 
		 * SETTING PANEL 
		 * */
		setBackground(new Color(255, 255, 255));
		setBounds(303, 0, 606, 499);
		setLayout(null);
		
		/*
		 * SETTING WELCOME BACK MESSAGE
		 * */
		appTitle = new JLabel("Welcome Back!\n");
		appTitle.setForeground(new Color(78, 166, 182));
		appTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		appTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		appTitle.setHorizontalAlignment(SwingConstants.CENTER);
		appTitle.setBounds(179, 62, 255, 51);
		add(appTitle);
		
		/*
		 * SETTING MAIL LABEL
		 * */
		mailLabel = new JLabel("Email");
		mailLabel.setForeground(new Color(52, 52, 52));
		mailLabel.setFont(new Font("Optima", Font.PLAIN, 16));
		mailLabel.setBounds(101, 161, 97, 30);
		add(mailLabel);
		
		/*
		 * SETTING MAIL FIELD
		 * */
		mailField = new JTextField();
		mailField.setBackground(new Color(255, 255, 255));
		mailField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, SystemColor.window, SystemColor.window, SystemColor.window, null));
		mailField.setBounds(101, 191, 414, 26);
		mailField.setColumns(10);
		add(mailField);
		
		/*
		 * SETTING PASSWORD LABEL
		 * */
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(52, 52, 52));
		passwordLabel.setFont(new Font("Optima", Font.PLAIN, 16));
		passwordLabel.setBounds(101, 231, 97, 32);
		add(passwordLabel);
		
		/*
		 * SETTING PASSWORD FIELD
		 * */
		passwordField = new JPasswordField();
		passwordField.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		passwordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		passwordField.setOpaque(true);
		passwordField.setCaretColor(SystemColor.menu);	
		passwordField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(238, 238, 238), new Color(238, 238, 238), SystemColor.window, null));
		passwordField.setBounds(101, 262, 414, 26);
		add(passwordField);
		
		/*
		 * SETTING LOGIN BUTTON
		 * */
		loginButton = new JButton("Login ");
		loginButton.setHideActionText(true);
		loginButton.setForeground(new Color(95, 204, 207));
		loginButton.setBackground(new Color(95, 204, 207));
		loginButton.setBounds(133, 316, 141, 38);
		add(loginButton);
		
		/*
		 * SETTING FORGOT PASSWORD BUTTON
		 * */
		forgotPasswordButton = new JButton("Forgot password?");
		forgotPasswordButton.setBorder(null);
		forgotPasswordButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		forgotPasswordButton.setBounds(330, 315, 155, 39);
		add(forgotPasswordButton);
		
		/*
		 * SETTING COPYRIGHT LABEL
		 * */
		copyrightLabel = new JLabel("Copyright © 2023 SMS");
		copyrightLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		copyrightLabel.setBounds(259, 441, 199, 16);
		add(copyrightLabel);
		
		
		/*
		 * SETTING CLOSE APP BUTTON
		 * */
		closeAppButton = new JButton("X");
		closeAppButton.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		closeAppButton.setBorder(null);
		closeAppButton.setBounds(577, 6, 29, 30);
		add(closeAppButton);
	}
	
	
	
	public void addLoginButtonListener(ActionListener action){
		loginButton.addActionListener(action);
	}
	
	public void addForgotPasswordButtonListener(ActionListener action){
		forgotPasswordButton.addActionListener(action);
	}

	public void addCloseButtonListener(ActionListener action){
		closeAppButton.addActionListener(action);
	}
	
	public String getEmail(){
		return String.valueOf(mailField.getText());
	}
	
	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}
}
