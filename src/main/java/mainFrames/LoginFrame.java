package main.java.mainFrames;

import java.util.List;
import java.util.Objects;

import javax.swing.JFrame;

import org.mindrot.jbcrypt.BCrypt;

import main.db.TeacherDaoImpl;
import main.db.UserDaoImpl;
import main.db.tables.AccountType;
import main.db.tables.Teacher;
import main.db.tables.User;
import main.java.MainController;
import main.java.controller.auth.LoginController;
import main.java.customException.CustomException;

public class LoginFrame extends JFrame{
	private LoginController loginController;
	static private UserDaoImpl userDaoImpl;
	
	public LoginFrame(LoginController loginController) {
		this.loginController = loginController;
		userDaoImpl = new UserDaoImpl();
		init();
	}
	
	public void init() {
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		getContentPane().setVisible(true);
		setBounds(100, 100, 909, 527);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		getContentPane().add(loginController.getLoginPanel());
		getContentPane().add(loginController.getLoginRegisterPanel());
	}

	public static void login(String email, String password) throws CustomException{
		User user = userDaoImpl.getUser(email);
		if(Objects.isNull(user)) throw new CustomException("Email was not found");
		user.setAccountType(getAccountType(user.getPin()));
		
		String passwordDB = null;
		boolean validPass = false;
		
		if(user.getAccountType().getId_type() == 1) passwordDB = userDaoImpl.getAdminPasswordByPin(user.getPin());
		
		if(user.getAccountType().getId_type() == 2) passwordDB = userDaoImpl.getTeacherPasswordByPin(user.getPin());
		
		if(user.getAccountType().getId_type() == 3) passwordDB = userDaoImpl.getStudentPasswordByPin(user.getPin());
		
		try{
			validPass = BCrypt.checkpw(password, passwordDB);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(!validPass) { throw new CustomException("Password is not correct"); }
		
		if(user.getAccountType().getId_type() == 1) MainController.changeFromLoginToAdmin();
		if(user.getAccountType().getId_type() == 2) {
			MainController.changeFromLoginToTeacher(TeacherDaoImpl.getTeacherByPin(user.getPin()));
		}
		if(user.getAccountType().getId_type() == 3) MainController.changeFromLoginToStudent();
	}
	
	public static AccountType getAccountType(long pin) {
		AccountType account = new AccountType();
		account.setId_type(UserDaoImpl.getAccountTypeByPin(pin));
		
		String nameType = account.getId_type() == 1? "Admin" : account.getId_type() == 2? "Teacher" : "Student";
		account.setName_type(nameType);
		
		return account;
	}
}

