package main.java.model.auth;

import java.util.Objects;

import org.mindrot.jbcrypt.BCrypt;

public class RegisterModel {
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String passwordConfirmed;
	private long personalIdentificationNumber;
	public static final int DIGIT_NUMBER_OF_PIN = 13;
	
	private static RegisterModel registerModel;
	
	private RegisterModel() {}
	
	public static RegisterModel getRegisterModelInstance() {
		if(Objects.isNull(registerModel)) registerModel = new RegisterModel();
		return registerModel;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param passwordConfirmed the passwordConfirmed to set
	 */
	public void setPasswordConfirmed(String passwordConfirmed) {
		this.passwordConfirmed = passwordConfirmed;
	}

	/**
	 * @param personalIdentificationNumber the personalIdentificationNumber to set
	 */
	public void setPersonalIdentificationNumber(long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}	

	public boolean emailValidation() {
		boolean validEmail = false;
		try {
			validEmail = LoginModel.getMatch("^[A-Za-z]+[\\w.-]*@yahoo\\.com$", email);
		}catch(Exception e) {
			return validEmail;
		}
		return validEmail;
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
	
	public boolean personalIdentificationNumberValidation() {
		int digitNr = 0;
		long pinClone = personalIdentificationNumber;
		while(pinClone > 0) {
			digitNr++;
			pinClone /= 10;
		}
		if(digitNr == RegisterModel.DIGIT_NUMBER_OF_PIN) return true;
		return false;
	}

	public boolean firstNameValidation() {
		return !firstName.isEmpty();
	}
	
	public boolean lastNameValidation() {
		return !lastName.isEmpty();
	}

	public String getSecurePassword(){
		return BCrypt.hashpw(password, BCrypt.gensalt(12));
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() { 
		return lastName;
	}
	
	public Long getPin() {
		return personalIdentificationNumber;
	}
}

