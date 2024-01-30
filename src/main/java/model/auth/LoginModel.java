package main.java.model.auth;

import java.util.regex.Pattern;

import java.util.Objects;
import java.util.regex.Matcher;


public class LoginModel {
	private String password;
	private String email;
	private static Matcher matchingPattern;
	private static Pattern pattern;
	
	private static LoginModel loginModel;
	
	private LoginModel(){}
	
	public static LoginModel getLoginModelInstance() {
		if(Objects.isNull(loginModel)) loginModel = new LoginModel();
		return loginModel;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean checkEmailInput() {
		boolean validMail = false;
		try{
			validMail = getMatch("^[A-Za-z]+[\\w.-]*@yahoo\\.com$", email);
		}catch(Exception e){
			return validMail;
		}
		return validMail;
	}
	
	public boolean checkPasswordInput() {
		if(password.length() < 8) return false;
		
		boolean validPass = false;
		try{
			validPass = getMatch("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!_.]).*$", password);
		}catch(Exception e) {
			return validPass;
		}
		
		return validPass;
	}
	
	public static boolean getMatch(String pattern, String text) {
		LoginModel.pattern = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
		matchingPattern = LoginModel.pattern.matcher(text);
		return matchingPattern.matches();
	}
	
}
