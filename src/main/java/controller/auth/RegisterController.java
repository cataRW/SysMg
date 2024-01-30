package main.java.controller.auth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.db.tables.NewUser;
import main.java.MainController;
import main.java.customException.CustomException;
import main.java.mainFrames.RegisterFrame;
import main.java.model.auth.RegisterModel;
import main.java.view.auth.RegisterPanel;

public class RegisterController {
	private RegisterModel registerModel = RegisterModel.getRegisterModelInstance();
	private RegisterPanel registerPanel;
	private boolean VALID_REGISTER = true;
	
	public RegisterController() {
		registerPanel = new RegisterPanel();
		registerPanel.addCreateAccountButtonAction(getCreateAccountButtonAction());
		registerPanel.addCloseButtonAction(getCloseButtonAction());
	}
	
	public RegisterPanel getRegisterPanel() {
		return this.registerPanel;
	}
	
	public ActionListener getCreateAccountButtonAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setRegisterModelFields();
				
				if(!VALID_REGISTER) resetRegisterPanelError();
				
				if(!registerValidation()) {
					VALID_REGISTER = false;	
				}else {
					NewUser newUser = new NewUser();
					newUser.setHashedPassword(registerModel.getSecurePassword());
					newUser.setEmail(registerModel.getEmail());
					newUser.setFirstName(registerModel.getFirstName());
					newUser.setLastName(registerModel.getLastName());
					newUser.setPin(registerModel.getPin());
					try{
						RegisterFrame.createUser(newUser);
					}catch(CustomException exc) {
						JOptionPane.showMessageDialog(registerPanel, exc.getMessage(), "Invalid data" ,JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
		};
	}
	
	public ActionListener getCloseButtonAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.changeBackToLoginFromRegister();
			}
		};
	}
	
	public void setRegisterModelFields() {
		registerModel.setEmail(registerPanel.getEmail());
		registerModel.setPassword(registerPanel.getPassword());
		registerModel.setPasswordConfirmed(registerPanel.getConfirmPassword());
		registerModel.setFirstName(registerPanel.getFirstName());
		registerModel.setLastName(registerPanel.getLastName());
		registerModel.setPersonalIdentificationNumber(registerPanel.getPersonalIdentificationNumber());
	}
	
	public boolean registerValidation() {
		if(!registerModel.emailValidation()) {
			registerPanel.setEmailError("Format is not valid!");
			return false;
		}
		if(!registerModel.passwordValidation() ) {
			if(registerPanel.getPassword().length() < 8) {
				registerPanel.setPasswordError("At least 8 characters!");
				return false;
			}
			registerPanel.setPasswordError("At least 1 letter,number,special character!");
			return false;
		}
		if(!registerModel.passwordConfirmedValidation()) {
			registerPanel.setConfirmPasswordError("Password doesn't match!");
			return false;
		}
		if(!registerModel.firstNameValidation()) {
			registerPanel.setFirstNameError("Empty field!");
			return false;
		}
		if(!registerModel.lastNameValidation()) {
			registerPanel.setLastNameError("Empty field!");
			return false;
		}
		if(!registerModel.personalIdentificationNumberValidation()) {
			registerPanel.setPersonalIdentificationNumberError("Format is not valid!");
			return false;
		}
		return true;
	}
	
	public void resetRegisterPanelError() {
		registerPanel.setEmailError("");
		registerPanel.setPasswordError("");
		registerPanel.setConfirmPasswordError("");
		registerPanel.setFirstNameError("");
		registerPanel.setLastNameError("");
		registerPanel.setPersonalIdentificationNumberError("");

	}

}
