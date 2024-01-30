package main.java;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.util.List;

import javax.swing.JFrame;

import org.mindrot.jbcrypt.BCrypt;

import main.db.DBConnection;
import main.db.UserDaoImpl;
import main.db.tables.AccountType;
import main.java.controller.auth.LoginController;
import main.java.controller.auth.RegisterController;
import main.java.controller.auth.ResetPasswordController;
import main.java.mainFrames.AdminFrame;
import main.java.mainFrames.LoginFrame;



public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainController.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
