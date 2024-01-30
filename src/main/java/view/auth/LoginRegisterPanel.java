package main.java.view.auth;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class LoginRegisterPanel extends JPanel {
	private JLabel rightSideLogo;
	private JLabel leftSideLogo;
	private JLabel titleDescription;
	private JLabel appDescription;
	private JButton registerButton;

	public LoginRegisterPanel() { init(); }
	
	private void init() {
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(88, 187, 199));
		this.setBounds(0, 0, 303, 499);
		this.setLayout(null);
		
		leftSideLogo = new JLabel("SMS-");
		leftSideLogo.setForeground(new Color(224, 224, 224));
		leftSideLogo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		leftSideLogo.setHorizontalAlignment(SwingConstants.CENTER);
		leftSideLogo.setHorizontalTextPosition(SwingConstants.CENTER);
		leftSideLogo.setBounds(0, 0, 59, 51);
		this.add(leftSideLogo);
		
		rightSideLogo = new JLabel("School Managment System ");
		rightSideLogo.setForeground(new Color(224, 224, 224));
		rightSideLogo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		rightSideLogo.setBounds(44, 6, 138, 16);
		this.add(rightSideLogo);
		
		titleDescription = new JLabel("School Managment System");
		titleDescription.setBounds(36, 159, 234, 38);
		titleDescription.setBackground(new Color(255, 255, 255));
		titleDescription.setForeground(new Color(255, 255, 255));
		titleDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		this.add(titleDescription);
		
		appDescription = new JLabel("<html>\n<div style= \"text-align: center;  margin-bottom: 2px;\" =>Welcome to our School Management System! </div>\n<div style=\"text-align: center; line-height: 2px;\">As you log in, a warm 'Welcome Back' greets you, signifying our commitment to your educational journey. Together, we're shaping a brighter tomorrow for students, teachers, and administrators.</div>\n\n");
		appDescription.setForeground(new Color(255, 255, 255));
		appDescription.setFont(new Font("Lucida Grande", Font.ITALIC, 10));
		appDescription.setDisplayedMnemonic(KeyEvent.VK_ENTER);
		appDescription.setHorizontalTextPosition(SwingConstants.CENTER);
		appDescription.setHorizontalAlignment(SwingConstants.CENTER);
		appDescription.setBounds(17, 209, 280, 102);
		this.add(appDescription);
		
		registerButton = new JButton("Register Now!\n");
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		registerButton.setAutoscrolls(true);
		registerButton.setBackground(new Color(255, 255, 255));
		registerButton.setForeground(new Color(255, 255, 255));
		registerButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255), new Color(255, 255, 255), null));
		registerButton.setSize(new Dimension(3123123, 0));
		registerButton.setBounds(88, 314, 131, 38);
		this.add(registerButton);
	}
	
	public void addLoginRegisterListener(ActionListener action) {
		registerButton.addActionListener(action);
	}
	
}
