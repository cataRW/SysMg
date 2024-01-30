package main.java.controller.auth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.java.MainController;
import main.java.customException.CustomException;
import main.java.mainFrames.ResetPasswordFrame;
import main.java.model.auth.ResetPasswordModel;
import main.java.view.auth.ResetPasswordPanel;

public class ResetPasswordController {
	ResetPasswordModel resetPasswordModel = ResetPasswordModel.getResetPasswordModelInstance();
	ResetPasswordPanel resetPasswordPanel;
	
	public ResetPasswordController() {
		resetPasswordPanel = new ResetPasswordPanel();
		resetPasswordPanel.addResetPasswordButtonAction(getResetButtonAction());
		resetPasswordPanel.addCloseButtonAction(getCloseButtonAction());
	}
	
	
	public ActionListener getResetButtonAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFields();
				
				if(fieldsValidation()) {
					try{
						ResetPasswordFrame.resetPassword(resetPasswordPanel.getPin(), resetPasswordModel.getHashedPassword());
					}catch(CustomException exc) {
						JOptionPane.showMessageDialog(resetPasswordPanel, exc.getMessage(), "Invalid data" ,JOptionPane.ERROR_MESSAGE);
					}
				}
			}	
		};
	}
	
	public ActionListener getCloseButtonAction() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.changeBackToLoginFromResetPassword();
			}
		};
	}
	
	public void setFields() {
		resetPasswordModel.setPin(resetPasswordPanel.getPin());
		resetPasswordModel.setPassword(resetPasswordPanel.getPassword());
		resetPasswordModel.setConfirmedPassword(resetPasswordPanel.getConfirmedPassword());

	}
	
	public boolean fieldsValidation() {
		if(!resetPasswordModel.pinValidation()) {
			JOptionPane.showMessageDialog(new JFrame(), "Pin format is not valid!",
		               "Invalid data format", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!resetPasswordModel.passwordValidation()) {
			if(resetPasswordPanel.getPassword().length() < 8) {
				JOptionPane.showMessageDialog(new JFrame(), "At least 8 characters!",
						"Invalid data format", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			JOptionPane.showMessageDialog(new JFrame(), "At least 1 number, 1 letter and 1 from @#$%^&+=!_!.",
					"Invalid data format", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if(!resetPasswordModel.passwordConfirmedValidation()) {
			JOptionPane.showMessageDialog(new JFrame(), "Password doesn't match!",
					"Invalid data format", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	public ResetPasswordPanel getResetPasswordPanel() {
		return resetPasswordPanel;
	}
}
