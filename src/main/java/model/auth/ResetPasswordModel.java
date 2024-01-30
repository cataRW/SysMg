package main.java.model.auth;

import java.util.Objects;

import org.mindrot.jbcrypt.BCrypt;

public class ResetPasswordModel {
	private long pin;
	private String password;
	private String passwordConfirmed;
	
	public static ResetPasswordModel resetPassword;
	
	private ResetPasswordModel() {}
	
	public static ResetPasswordModel getResetPasswordModelInstance() {
		if(Objects.isNull(resetPassword)) resetPassword = new ResetPasswordModel();
		return resetPassword;
	}
	
	public boolean pinValidation() {
		int digitNr = 0;
		long pinClone = pin;
		while(pinClone > 0) {
			digitNr++;
			pinClone /= 10;
		}
		if(digitNr == RegisterModel.DIGIT_NUMBER_OF_PIN) return true;
		return false;
	}
	
	public boolean passwordValidation() {
		if(password.length() < 8) return false;
				
		boolean validPassword = false;
		try {
			validPassword = LoginModel.getMatch("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!_.]).*$", password);
		}catch(Exception e) {
			return validPassword;
		}
		return validPassword;
	
	}

	public boolean passwordConfirmedValidation() {
		return passwordConfirmed.equals(password);
	}

	public void setPin(long pin) {
		this.pin = pin;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setConfirmedPassword(String passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}
	
	public String getHashedPassword() {
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
}
