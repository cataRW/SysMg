package main.java.mainFrames;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JFrame;

import main.db.UserDaoImpl;
import main.java.controller.auth.ResetPasswordController;
import main.java.customException.CustomException;

public class ResetPasswordFrame extends JFrame{
	private ResetPasswordController resetPasswordController;
	public static UserDaoImpl userDaoImpl;
	
	public ResetPasswordFrame(ResetPasswordController resetPasswordController) {
		this.resetPasswordController = resetPasswordController;
		init();
	}
	
	public void init() {
		getContentPane().setBackground(new Color(143, 138, 137));
		setBounds(100, 100, 600, 555);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		getContentPane().add(resetPasswordController.getResetPasswordPanel());
	}
	
	public static void resetPassword(long pin, String password) throws CustomException{
		
			int idType = UserDaoImpl.getAccountTypeByPin(pin);
			if(idType == 0) throw new CustomException("Personal identification number is incorrect");
			
			try {
				UserDaoImpl.updatePassword(password, pin, idType);
			}catch(SQLException e) {
				throw new CustomException("Password wasn't updated");
			}
		
	}
	
}
