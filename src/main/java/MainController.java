package main.java;

import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.db.tables.Teacher;
import main.java.controller.auth.LoginController;
import main.java.controller.auth.RegisterController;
import main.java.controller.auth.ResetPasswordController;
import main.java.mainFrames.AdminFrame;
import main.java.mainFrames.LoginFrame;
import main.java.mainFrames.RegisterFrame;
import main.java.mainFrames.ResetPasswordFrame;
import main.java.mainFrames.TeacherFrame;

public class MainController {
	private static LoginFrame login;
	private static RegisterFrame register;
	private static ResetPasswordFrame resetPassword;
	private static AdminFrame admin;
	private static TeacherFrame teacherFrame;
	
	
	private MainController() {}
	
	public static LoginFrame getLogin() {
		if(Objects.isNull(login)) login = new LoginFrame(new LoginController());
		return login;
	}
	
	public static RegisterFrame getRegister() {
		return new RegisterFrame(new RegisterController());
	}
	
	public static ResetPasswordFrame getResetPassword() {
		return new ResetPasswordFrame(new ResetPasswordController());
	}
	
	public static AdminFrame getAdmin() {
		if(Objects.isNull(admin)) admin = new AdminFrame();
		return admin;
	}
	
	public static void changeLoginFrameAvailability(boolean available) {
		login.setEnabled(available);
	}
	
	public static void start() {
		login = getLogin();
	}
	
	public static void changeToRegisterFrame() {
		changeLoginFrameAvailability(false);
		register = getRegister();
		register.setVisible(true);
	}
	
	public static void changeBackToLoginFromRegister() {
		register.dispose();
		changeLoginFrameAvailability(true);
	}
	
	public static void changeToResetPasswordFrame() {
		changeLoginFrameAvailability(false);
		resetPassword = getResetPassword();
		resetPassword.setVisible(true);
	}
	
	public static void changeBackToLoginFromResetPassword() {
		resetPassword.dispose();
		changeLoginFrameAvailability(true);
	}
	
	public static void changeFromLoginToAdmin() {
		login.dispose();
		admin = getAdmin();
	}
	
	public static void changeFromLoginToTeacher(Teacher teacher) {
		login.dispose();
		teacherFrame = new TeacherFrame(teacher);
	}
	
	public static void changeFromLoginToStudent() {
		//login.dispose();
		System.out.println("change from login to Student");
	}
	
	public static void changeAdminSecondPanel(int nrOfPanel) {
		admin.changeSecondPanel(nrOfPanel);
	}
}
