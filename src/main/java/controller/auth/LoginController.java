package main.java.controller.auth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.java.MainController;
import main.java.customException.CustomException;
import main.java.mainFrames.LoginFrame;
import main.java.model.auth.LoginModel;
import main.java.view.auth.LoginPanel;
import main.java.view.auth.LoginRegisterPanel;

public class LoginController {
	private LoginModel loginModel = LoginModel.getLoginModelInstance();
	private LoginPanel loginPanel;
	private LoginRegisterPanel loginRegisterPanel;
	
	public LoginController() {
		loginPanel = new LoginPanel();
		loginRegisterPanel = new LoginRegisterPanel();
		loginPanel.addCloseButtonListener(getCloseButtonAction());
		loginPanel.addLoginButtonListener(getLoginButtonAction());
		loginPanel.addForgotPasswordButtonListener(getForgotPasswordButtonAction());
		loginRegisterPanel.addLoginRegisterListener(getLoginRegisterAction());
	}

	public ActionListener getCloseButtonAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
	}
	
	public ActionListener getLoginButtonAction() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 setLoginModel();
				 if(loginModel.checkEmailInput() && loginModel.checkPasswordInput()) { 
					 try {
						 LoginFrame.login(loginModel.getEmail(), loginModel.getPassword());
					 }catch(CustomException exc) {
						 JOptionPane.showMessageDialog(loginPanel, exc.getMessage(), "Invalid data" ,JOptionPane.ERROR_MESSAGE);
					 }
				}else {
					JOptionPane.showMessageDialog(loginPanel, "Format of email or password is not valid", "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
			}
		
		};
	}
	
	public ActionListener getForgotPasswordButtonAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.changeToResetPasswordFrame();	
			}	
		};
	}
	
	public ActionListener getLoginRegisterAction() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/* apelare functiie din MainControler care va deschide frame-ul de inregistrare cont nou*/
				MainController.changeToRegisterFrame();
			}	
		};
	}
	
	public void setLoginModel() {
		loginModel.setEmail(loginPanel.getEmail());
		loginModel.setPassword(loginPanel.getPassword());
	}
	
	public LoginPanel getLoginPanel() {
		return loginPanel;
	}
	
	public LoginRegisterPanel getLoginRegisterPanel() {
		return loginRegisterPanel;
	}
}
