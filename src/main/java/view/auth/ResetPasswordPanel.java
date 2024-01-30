package main.java.view.auth;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ResetPasswordPanel extends JPanel{

	private JTextField pinField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirmedField;
	private JButton resetPasswordButton;
	private JButton closeButton;

	public ResetPasswordPanel() {
		initialize();
	}

	private void initialize() {
		setForeground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 63, 600, 407);
		setBorder(null);
		
		JLabel pinLabel = new JLabel("Personal identification number");
		pinLabel.setFont(new Font("Optima", Font.ITALIC, 15));
		pinLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pinLabel.setBounds(137, 18, 284, 41);
		add(pinLabel);
		
		pinField = new JTextField();
		pinField.setBounds(137, 58, 284, 33);
		pinField.setColumns(10);
		add(pinField);
		
		JLabel passwordLabel = new JLabel("New password");
		passwordLabel.setFont(new Font("Optima", Font.ITALIC, 15));
		passwordLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(137, 103, 284, 33);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 136, 284, 33);
		add(passwordField);
		
		JLabel passwordConfirmedLabel = new JLabel("Confirm password");
		passwordConfirmedLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		passwordConfirmedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordConfirmedLabel.setFont(new Font("Optima", Font.ITALIC, 15));
		passwordConfirmedLabel.setBounds(137, 181, 284, 33);
		add(passwordConfirmedLabel);
		
		passwordConfirmedField = new JPasswordField();
		passwordConfirmedField.setBounds(137, 218, 284, 33);
		add(passwordConfirmedField);
		
		resetPasswordButton = new JButton("Reset password");
		resetPasswordButton.setFocusPainted(false);
		resetPasswordButton.setHorizontalTextPosition(SwingConstants.CENTER);
		resetPasswordButton.setDoubleBuffered(true);
		resetPasswordButton.setBorder(null);
		resetPasswordButton.setOpaque(true);
		resetPasswordButton.setFont(new Font("Optima", Font.ITALIC, 15));
		resetPasswordButton.setIgnoreRepaint(true);
		resetPasswordButton.setForeground(new Color(255, 255, 255));
		resetPasswordButton.setBackground(new Color(158, 158, 158));
		resetPasswordButton.setBounds(216, 300, 139, 48);
		add(resetPasswordButton);
		
		closeButton = new JButton("X");
		closeButton.setBounds(546, 6, 48, 29);
		add(closeButton);
	}

	public long getPin() {
		long pin;
		try{
			pin = Long.parseLong(pinField.getText());
		}catch(NumberFormatException e) {
			return 0;
		}
		
		return pin; 
	}
	
	public String getPassword() {
		return String.valueOf(passwordField.getPassword());
	}
	
	public String getConfirmedPassword() {
		return String.valueOf(passwordConfirmedField.getPassword());
	}
	
	public void addResetPasswordButtonAction(ActionListener action) {
		resetPasswordButton.addActionListener(action);
	}
	
	public void addCloseButtonAction(ActionListener action) {
		closeButton.addActionListener(action);
	}
}
