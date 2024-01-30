package main.db;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.db.tables.Student;
import main.db.tables.Teacher;
import main.java.customException.CustomException;


public class TeacherDaoImpl {
	public TeacherDaoImpl() {}
	
	public static Teacher getTeacherByPin(long pin) throws CustomException{
		Teacher teacher = new Teacher();
		String selectQuery = "Select * from teacher_table where cnp_teacher = ?";
		try {
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuery);
			statement.setLong(1, pin);
			ResultSet result = statement.executeQuery();
			if(result.next()) {
				teacher.setEmailTeacher(result.getString("email_teacher"));
				teacher.setFirstName(result.getString("first_name"));
				teacher.setLastName(result.getString("last_name"));
				teacher.setIdTeacher(result.getInt("id_teacher"));
				teacher.setPin(result.getLong("cnp_teacher"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return teacher;
	}
	
	public List<Student> getStudentListByClassId(int classId){
		List<Student> list = new ArrayList<>();
		try {
			String selectQuerry = "SELECT student_table.*\n"
					+ "FROM student_table\n"
					+ "JOIN students_enroll_class ON student_table.id_student = students_enroll_class.id_student\n"
					+ "WHERE students_enroll_class.id_class = ?";
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuerry);
			statement.setInt(1, classId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Student newStudent = new Student();
				newStudent.setIdStudent(resultSet.getInt("id_student"));
				newStudent.setStudentEmail(resultSet.getString("email_student"));
				newStudent.setFirstName(resultSet.getString("first_name"));
				newStudent.setLastName(resultSet.getString("last_name"));
				newStudent.setPin(resultSet.getLong("cnp_student"));
				list.add(newStudent);
			}
		}catch(SQLException e){
			
		}
		
		return list;
	}
	
	public void addStudentGrade(Student student , int grade, Date currentDate) {
		System.out.println(student.getFirstName() + " " + student.getLastName() + " " + grade + " " + currentDate);
	}
}
