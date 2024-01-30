package main.java.mainFrames;

import javax.swing.JFrame;

import main.db.UserDaoImpl;
import main.db.tables.NewUser;
import main.java.controller.auth.RegisterController;
import main.java.customException.CustomException;

public class RegisterFrame extends JFrame{
	RegisterController registerController;
	public static UserDaoImpl userDaoImpl;
	
	public RegisterFrame(RegisterController registerController) {
		this.registerController = registerController;
		userDaoImpl = new UserDaoImpl();
		init();
	}
	
	private void init() {
		setBounds(50, 100, 775, 467);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setVisible(true);
		setVisible(true);
		setResizable(false);
		
		getContentPane().add(registerController.getRegisterPanel());
	}
	
	public static void createUser(NewUser newUser) throws CustomException{
		String insertAdminQuery = "INSERT INTO admin_table (first_name, last_name, email_admin, cnp) VALUES (?, ?, ?, ?)";
		String insertStudentQuery = "INSERT INTO student_table (first_name, last_name, email_student, cnp_student) VALUES (?, ?, ?, ?)";
		String insertTeacherQuery = "INSERT INTO teacher_table (first_name, last_name, email_teacher, cnp_teacher) VALUES (?, ?, ?, ?)";
		
		int typeAccount = UserDaoImpl.getAccountTypeByPin(newUser.getPin());
		if(typeAccount == 0) throw new CustomException("You cann't create a count with this pin because is not recognize as part of school!");
		
		if(typeAccount == 1) userDaoImpl.createNewUser(newUser, insertAdminQuery, typeAccount); 
		if(typeAccount == 2) userDaoImpl.createNewUser(newUser, insertTeacherQuery, typeAccount);
		if(typeAccount == 3) userDaoImpl.createNewUser(newUser, insertStudentQuery, typeAccount);
	}
}
