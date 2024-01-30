package main.java.view.auth;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Font;

public class RegisterPanel extends JPanel{
	
	private JTextField emailField;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField personalIdentificationNumberField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JLabel emailErrorLabel;
	private JLabel passwordErrorLabel;
	private JLabel confirmPasswordErrorLabel;
	private JLabel firstNameErrorLabel;
	private JLabel lastNameErrorLabel;
	private JLabel personalIdentificationNumberErrorLabel;
	private JButton createAccountButton;
	private JButton closeButton;

	public RegisterPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		setBounds(0, 0, 775, 433);
		setLayout(null);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setForeground(new Color(71, 71, 71));
		emailLabel.setBounds(116, 52, 224, 26);
		add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(71, 71, 71));
		passwordLabel.setBounds(116, 155, 224, 26);
		add(passwordLabel);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setForeground(new Color(71, 71, 71));
		firstNameLabel.setBounds(451, 50, 224, 31);
		add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setForeground(new Color(71, 71, 71));
		lastNameLabel.setBounds(451, 153, 224, 31);
		add(lastNameLabel);
		
		JLabel personalIdentificationNumberLabel = new JLabel("Personal Identification Number");
		personalIdentificationNumberLabel.setForeground(new Color(71, 71, 71));
		personalIdentificationNumberLabel.setBounds(451, 249, 224, 31);
		add(personalIdentificationNumberLabel);
		
		JLabel confirmPassword = new JLabel("Confirm Password");
		confirmPassword.setForeground(new Color(71, 71, 71));
		confirmPassword.setBounds(116, 251, 224, 26);
		add(confirmPassword);
		
		emailField = new JTextField();
		emailField.setBounds(116, 79, 224, 36);
		add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 178, 224, 36);
		add(passwordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(116, 276, 224, 36);
		add(confirmPasswordField);
		
		createAccountButton = new JButton("Create Account");
		createAccountButton.setFocusCycleRoot(true);
		createAccountButton.setDoubleBuffered(true);
		createAccountButton.setAutoscrolls(true);
		createAccountButton.setBounds(311, 372, 165, 44);
		add(createAccountButton);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(451, 79, 224, 36);
		add(firstNameField);
		firstNameField.setColumns(10);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(451, 178, 224, 36);
		add(lastNameField);
		lastNameField.setColumns(10);
		
		personalIdentificationNumberField = new JTextField();
		personalIdentificationNumberField.setBounds(451, 276, 224, 36);
		add(personalIdentificationNumberField);
		personalIdentificationNumberField.setColumns(10);
		
		emailErrorLabel = new JLabel("");
		emailErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		emailErrorLabel.setForeground(new Color(249, 10, 61));
		emailErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		emailErrorLabel.setBounds(116, 116, 224, 18);
		add(emailErrorLabel);
		
		passwordErrorLabel = new JLabel("");
		passwordErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		passwordErrorLabel.setForeground(new Color(249, 10, 61));
		passwordErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordErrorLabel.setBounds(116, 210, 224, 18);
		add(passwordErrorLabel);
		
		confirmPasswordErrorLabel = new JLabel("");
		confirmPasswordErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		confirmPasswordErrorLabel.setForeground(new Color(249, 10, 61));
		confirmPasswordErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		confirmPasswordErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPasswordErrorLabel.setBounds(116, 309, 229, 18);
		add(confirmPasswordErrorLabel);
		
		firstNameErrorLabel = new JLabel("");
		firstNameErrorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		firstNameErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameErrorLabel.setForeground(new Color(249, 10, 61));
		firstNameErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		firstNameErrorLabel.setBounds(451, 116, 224, 18);
		add(firstNameErrorLabel);
		
		lastNameErrorLabel = new JLabel("");
		lastNameErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameErrorLabel.setForeground(new Color(249, 10, 61));
		lastNameErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lastNameErrorLabel.setBounds(451, 211, 224, 16);
		add(lastNameErrorLabel);
		
		personalIdentificationNumberErrorLabel = new JLabel("");
		personalIdentificationNumberErrorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		personalIdentificationNumberErrorLabel.setForeground(new Color(249, 10, 61));
		personalIdentificationNumberErrorLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		personalIdentificationNumberErrorLabel.setBounds(451, 310, 224, 16);
		add(personalIdentificationNumberErrorLabel);
		
		closeButton = new JButton("X");
		closeButton.setForeground(new Color(0, 0, 0));
		closeButton.setOpaque(true);
		closeButton.setBounds(725, 6, 44, 29);
		add(closeButton);
	}
	
	public void setEmailError(String emailErrorMessage) {
		emailErrorLabel.setText(emailErrorMessage);
	}
	
	public void setPasswordError(String passwordErrorMessage) {
		passwordErrorLabel.setText(passwordErrorMessage);
	}
	
	public void setConfirmPasswordError(String confirmPasswordErrorMessage) {
		confirmPasswordErrorLabel.setText(confirmPasswordErrorMessage);
	}
	
	public void setFirstNameError(String firstNameErrorMessage) {
		firstNameErrorLabel.setText(firstNameErrorMessage);
	}
	
	public void setLastNameError(String lastNameErrorMessage) {
		lastNameErrorLabel.setText(lastNameErrorMessage);
	}
	
	public void setPersonalIdentificationNumberError(String personalIdentificationNumberErrorMessage) {
		personalIdentificationNumberErrorLabel.setText(personalIdentificationNumberErrorMessage);
	}
	
	public String getEmail() {
		return String.valueOf(emailField.getText());
	}
	
	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}
	
	public String getConfirmPassword() {
		return String.valueOf(confirmPasswordField.getPassword());
	}
	
	public String getFirstName() {
		return String.valueOf(firstNameField.getText());
	}
	
	public String getLastName() {
		return String.valueOf(lastNameField.getText());

	}
	
	public long getPersonalIdentificationNumber() {
		long pin;
		try{
			pin = Long.parseLong(personalIdentificationNumberField.getText());
		}catch(NumberFormatException e) {
			return 0;
		}
		return pin; 
	}
	
	public void addCreateAccountButtonAction(ActionListener action) {
		createAccountButton.addActionListener(action);
	}
	
	public void addCloseButtonAction(ActionListener action) {
		closeButton.addActionListener(action);
	}
}
