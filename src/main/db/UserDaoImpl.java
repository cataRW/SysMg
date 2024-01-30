package main.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import main.db.interfaces.UserDAO;
import main.db.tables.AccountType;
import main.db.tables.NewUser;
import main.db.tables.User;
import main.java.customException.CustomException;

public class UserDaoImpl implements UserDAO{

	@Override
	public User getUser(String email) throws CustomException{
		String selectQueryAdmin = "SELECT * FROM admin_table where email_admin = ?";
		String selectQueryTeacher = "SELECT * FROM teacher_table where email_teacher = ?";
		String selectQueryStudent = "SELECT * FROM student_table where email_student = ?";
		
		User user = null;
		try {
			
			ResultSet result = executeCustomQuerry(selectQueryStudent, email);
			if(!Objects.isNull(result) && result.next()) {
				user = new User();
				user.setEmail(result.getString("email_student"));
				user.setPin(result.getLong("cnp_student"));
				return user;
			}
			
			result = executeCustomQuerry(selectQueryTeacher, email);
			if(!Objects.isNull(result) && result.next()) {
				user = new User();
				user.setEmail(result.getString("email_teacher"));
				user.setPin(result.getLong("cnp_teacher"));
				return user;
			}
			
			result = executeCustomQuerry(selectQueryAdmin, email);
			if(!Objects.isNull(result) && result.next()) {
				user = new User();
				user.setEmail(result.getString("email_admin"));
				user.setPin(result.getLong("cnp"));
				return user;
			}
		}catch(SQLException e) {
			throw new CustomException("User couldn't be found");
		}
		return user;
	}

	@Override
	public List<AccountType> getAccountTypesList() {
		String selectQuerry = "SELECT * FROM account_type";
		List<AccountType> accountTypeList = new ArrayList<>();
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				AccountType accountType = new AccountType();
				accountType.setId_type(resultSet.getInt("id_type"));
				accountType.setName_type(resultSet.getString("name_type"));
				accountTypeList.add(accountType);
			}
		}catch(SQLException e) {
			System.out.println("Couldn't get account types from account_type table");
		}finally {
			DBConnection.close();
		}
		
		return accountTypeList;
	}
	
	private ResultSet executeCustomQuerry(String querry, String email) {
		ResultSet result = null;
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(querry);
			statement.setString(1, email);
			result = statement.executeQuery();
		}catch(SQLException e) {
			System.out.println("CustomQuerry exception");
		}
		
		return result;
	}
	
	public static int getAccountTypeByPin(long pin) {
		String selectQuerry = "SELECT type FROM pin_accounts where pin =?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			statement.setLong(1, pin);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) { return result.getInt("type"); }
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String getAdminPasswordByPin(long pin) {
		String selectQuerry = "SELECT password FROM admin_passwords where cnp_user =?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			statement.setLong(1, pin);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				String password = result.getString("password");
				return password; 
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getStudentPasswordByPin(long pin) throws CustomException{
		String selectQuerry = "SELECT password FROM student_passwords where cnp_user =?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			statement.setLong(1, pin);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				String password = result.getString("password");
				return password; 
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw new CustomException("Password is not correct");
		}
		return null;
	}
	
	public String getTeacherPasswordByPin(long pin) {
		String selectQuerry = "SELECT password FROM teacher_passwords where cnp_user =?";
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			statement.setLong(1, pin);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) { 
				String password = result.getString("password");
				return password;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void createNewUser(NewUser newUser, String querry, int typeAcount) throws CustomException{
		if(!Objects.isNull(getUser(newUser.getEmail()))) throw new CustomException("The user with this email already exist");
		
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(querry);
			statement.setString(1, newUser.getFirstName());
			statement.setString(2, newUser.getLastName());
			statement.setString(3, newUser.getEmail());
			statement.setLong(4, newUser.getPin());
			statement.executeUpdate();
		} catch (Exception e) {
			throw new CustomException("This pin is already used");
		}
		
		try{
			setPassword(newUser.getHashedPassword(), newUser.getPin(), typeAcount);
		}catch(SQLException e) {
			throw new CustomException("Something wrong with password");
		}
	}
	
	public static void setPassword(String password, long pin, int accountType) throws SQLException{
		String querry = null;
		if(accountType == 1) querry = "INSERT INTO admin_passwords(cnp_user, password) VALUES (?, ?)";
		if(accountType == 2) querry = "INSERT INTO teacher_passwords(cnp_user, password) VALUES (?, ?)";
		if(accountType == 3) querry = "INSERT INTO student_passwords(cnp_user, password) VALUES (?, ?)";
		
		try{
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(querry);
			statement.setLong(1, pin);
			statement.setString(2, password);
			statement.executeUpdate();
		}catch(SQLException e) {
			System.out.println("setPassword method thrown exception");
		}
	}
	
	public static void updatePassword(String password, long pin, int accountType) throws CustomException, SQLException{
		String tableName;
		if (accountType == 1) {
		    tableName = "admin_passwords";
		} else if (accountType == 2) {
		    tableName = "teacher_passwords";
		} else if (accountType == 3) {
		    tableName = "student_passwords";
		} else {
		    throw new CustomException("Invalid account type"); 
		}

		String query = "UPDATE " + tableName + " SET password = ? WHERE cnp_user = ?";
		
		PreparedStatement statement = DBConnection.getConnection().prepareStatement(query);
		statement.setString(1, password);
		statement.setLong(2, pin);
		statement.executeUpdate();
	}
}
