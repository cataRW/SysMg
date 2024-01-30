package main.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.db.interfaces.AdminDao;
import main.db.tables.Admin;
import main.db.tables.Class;
import main.db.tables.Course;
import main.db.tables.Student;
import main.db.tables.Teacher;
import main.java.customException.CustomException;

public class AdminDaoImpl implements AdminDao{
	Connection con;
	Admin admin;
	
	public AdminDaoImpl() {
		con = DBConnection.getConnection();
	}
	
	@Override
	public void createCourse(Course course) throws CustomException {
		String insertQuery = "INSERT INTO course (name_course) VALUES (?)";
		try {
			if(checkIfCourseExist(course)) {
				throw new CustomException("Course already exist");
			}
			PreparedStatement statement = con.prepareStatement(insertQuery);
			statement.setString(1, course.getName());
			statement.executeUpdate();
			
		}catch(Exception e) {
			throw new CustomException("Course already exist");
		}
	}

	@Override
	public void createClass(Class classs) throws CustomException{
		String insertQuery = "INSERT INTO class (year_class, letter_class) VALUES (?,?)";
		
		try {
			PreparedStatement statement = con.prepareStatement(insertQuery);
			statement.setInt(1, classs.getYear());
            statement.setString(2, classs.getLetter());
            statement.executeUpdate();
		}catch(SQLException e) {
			throw  new CustomException("Class already exist");
		}
	}

	@Override
	public List<Course> getAllCourses() throws CustomException{
		String selectQuery = "SELECT * FROM course";
		List<Course> courses = new ArrayList<>();
		try{
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Course newCourse = new Course();
				newCourse.setName(resultSet.getString("name_course"));
				courses.add(newCourse);
			}
		}catch(SQLException e) {
			 throw new CustomException("Couldn't get courses");
		}
		
		return courses;
	}

	@Override
	public List<Class> getAllClasses() throws CustomException{
		String selectQuery = "SELECT * FROM class";
		List<Class> classes = new ArrayList<>();
		try{
			PreparedStatement statement = DBConnection.getConnection().prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Class newClass = new Class();
				newClass.setYear(resultSet.getInt("year_class"));
				newClass.setLetter(resultSet.getString("letter_class"));
				classes.add(newClass);
			}
		}catch(SQLException e) {
			 throw new CustomException("There is no class");
		}
		
		return classes;
	}
	
	public List<Student> getAllStudents() {
		List<Student> studentList = new ArrayList<>();
		try {
            String sqlQuery = "SELECT * FROM student_table";
            
            PreparedStatement statement = con.prepareStatement(sqlQuery);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("id_student");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email_student");
                long cnp = resultSet.getLong("cnp_student");
                Student newStudent = new Student();
                newStudent.setFirstName(firstName);
                newStudent.setLastName(lastName);
                newStudent.setStudentEmail(email);
                newStudent.setPin(cnp);
                newStudent.setIdStudent(studentId);
                studentList.add(newStudent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return studentList;
	}

	public List<Admin> getAdminList() throws CustomException{
		String selectQuery = "SELECT * FROM admin_table";
		List<Admin> adminList = new ArrayList<>();
		try{
			PreparedStatement statement = con.prepareStatement(selectQuery);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Admin newAdmin = new Admin();
				newAdmin.setIdAdmin(resultSet.getInt("id_admin"));
				newAdmin.setAdminEmail(resultSet.getString("email_admin"));
				newAdmin.setFirstName(resultSet.getString("first_name"));
				newAdmin.setLastName(resultSet.getString("last_name"));
				newAdmin.setPin(resultSet.getLong("cnp"));
				adminList.add(newAdmin);
			}
		}catch(SQLException e) {
			 throw new CustomException("Couldn't get admin list");
		}
		
		return adminList;
	}
	
	public void deleteAdmin(Admin admin) throws SQLException {
		String deleteQuerry = "DELETE FROM admin_table where cnp = ?";
		PreparedStatement statement = DBConnection.getConnection().prepareStatement(deleteQuerry);
		statement.setLong(1, admin.getPin());
		statement.executeUpdate();
	}
	
	public void deleteTeacherByIdAndPin(int id, long pin) throws CustomException {
        String deleteQuery = "DELETE FROM teacher_table WHERE id_teacher = ? AND cnp_teacher = ?";

        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setLong(2, pin);
            int rowAf = preparedStatement.executeUpdate();
            if(rowAf < 1) throw new CustomException("Pin is incorrect");
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
	
	
	public boolean checkIfCourseExist(Course course) {
		String select = "Select * from course where name_course = ?";
		try {
			PreparedStatement st = DBConnection.getConnection().prepareStatement(select);
			st.setString(1, course.getName());
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getString("name_course").equals(course.getName())) return true;
			}
		}catch(SQLException exc){
			return false;
		}
		return false;
	}

	public void addPin(long pin, int type) throws CustomException{
		try {
			if (checkPinIfExist(pin)) {
	            throw new CustomException("PIN already exists.");
	        } else {
	            insertPin(pin, type);
	        }
		}catch(SQLException ex){
			throw new CustomException("Couldn't add the pin.");
		}
	}
	

	public boolean checkPinIfExist(long pin) throws SQLException {
	
		PreparedStatement checkStatement = null;
	    String checkQuery = "SELECT pin FROM pin_accounts WHERE pin = ?";
	    checkStatement = DBConnection.getConnection().prepareStatement(checkQuery);
	    checkStatement.setLong(1, pin);
	    ResultSet resultSet = checkStatement.executeQuery();
	
	    return resultSet.next();
	
	}
	
	public void insertPin(long pin, int type) throws SQLException {
	    Connection connection = null;
	    PreparedStatement insertStatement = null;
	
	    try {
	        connection = DBConnection.getConnection();
	
	        String insertQuery = "INSERT INTO pin_accounts (pin, type) VALUES (?, ?)";
	        insertStatement = connection.prepareStatement(insertQuery);
	        insertStatement.setLong(1, pin);
	        insertStatement.setInt(2, type);
	        insertStatement.executeUpdate();
	    } finally {
	        if (insertStatement != null) {
	            insertStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }
	}
	
	public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teacher_table";

        try {
            PreparedStatement statement = DBConnection.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_teacher");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email_teacher");
                long pin = resultSet.getLong("cnp_teacher");

                Teacher teacher = new Teacher();
                teacher.setEmailTeacher(email);
                teacher.setFirstName(firstName);
                teacher.setLastName(lastName);
                teacher.setPin(pin);
                teacher.setIdTeacher(id);
                teachers.add(teacher);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return teachers;
    }
	
   public int getIdClassIfExist(int yearOfClass, String letterOfClass) {
        String selectQuery = "SELECT * FROM class WHERE year_class = ? AND letter_class = ?";
        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, yearOfClass);
            preparedStatement.setString(2, letterOfClass);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) { return resultSet.getInt("id_class"); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
   
   public int getIdCourseIfExist(String courseName) {
        String selectQuery = "SELECT * FROM course WHERE name_course = ?";
	        try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(selectQuery)) {
	            preparedStatement.setString(1, courseName);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            if (resultSet.next()) {
	                return resultSet.getInt("id_course");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	  return 0;
   }
   
   public int getTeacherIdByFullName(String firstName, String lastName) {
       int teacherId = -1; 

       String selectQuery = "SELECT id_teacher FROM teacher_table WHERE first_name = ? AND last_name = ?";

       try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(selectQuery)) {
           preparedStatement.setString(1, firstName);
           preparedStatement.setString(2, lastName);

           ResultSet resultSet = preparedStatement.executeQuery();

           if (resultSet.next()) {
               teacherId = resultSet.getInt("id_teacher");
           }
       }catch(SQLException exc) {
    	   
       }

       return teacherId;
   }
   
   public void enrollCourseToClass(int idCourse, int idClass) throws SQLException{
       String insertQuery = "INSERT INTO course_enroll_to_class (id_course, id_class) VALUES (?, ?)";
       PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(insertQuery);
           preparedStatement.setInt(1, idCourse);
           preparedStatement.setInt(2, idClass);
           preparedStatement.executeUpdate();
      
   }
   
   public int getEnrollmentIdByCourseAndClass(int idCourse, int idClass) {
       String selectQuery = "SELECT id_enroll FROM course_enroll_to_class WHERE id_course = ? AND id_class = ?";
       int enrollmentId = -1; // 
       
       try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(selectQuery)) {
           preparedStatement.setInt(1, idCourse);
           preparedStatement.setInt(2, idClass);

           ResultSet resultSet = preparedStatement.executeQuery();
           if (resultSet.next()) {
               enrollmentId = resultSet.getInt("id_enroll");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

       return enrollmentId;
   }
   
   public void addEnrollment(int idEnrollTeacherClassCourse, int idTeacher) throws CustomException{
       String query = "INSERT INTO teacher_enroll_to_class (id_enroll_teacher_class_course, id_teacher) VALUES (?, ?)";

       try {
       PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
       preparedStatement.setInt(1, idEnrollTeacherClassCourse);
       preparedStatement.setInt(2, idTeacher);
       preparedStatement.executeUpdate();
       }catch(SQLException exc) {
    	   throw new CustomException("Cann't insert second teacher or same teacher");
       }
   }
   
   public void enrollStudentToClass(int year, String letter, long pin) throws CustomException{
	   int idClass = getIdClassIfExist(year, letter);
	   int idStudent = getStudentIdByPin(pin);
	   
	   if(idClass == -1)  throw new CustomException("The class doesn't exist");
	   if(idStudent == - 1) throw new CustomException("Pin is incorrect");
	   
	   System.out.println(idClass +  " " + idStudent +  " " + pin);
	   try {
		   if(checkPinIfExist(pin)) {
			   String insertQuerry = "INSERT INTO students_enroll_class(id_student, id_class) VALUES (?, ?)";
			   PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(insertQuerry);
		       preparedStatement.setInt(1, idStudent);
		       preparedStatement.setInt(2, idClass);
		       preparedStatement.executeUpdate();
		   }
	   }catch(Exception e){
		   throw new CustomException("Cann't assign same student twice");
	   }
   }
   
   public int getStudentIdByPin(long pin) throws CustomException{
       String query = "SELECT id_student FROM student_table WHERE cnp_student = ?";
       try (Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           preparedStatement.setLong(1, pin);
           
           ResultSet resultSet = preparedStatement.executeQuery();
           
           if (resultSet.next()) {
               return resultSet.getInt("id_student");
           }
       } catch (SQLException e) {
    	   e.printStackTrace();
           throw new CustomException("Pin is incorrect");
       }
       
       return -1; 
   }
   
   public void deleteStudent(String firstName, String lastName, long pin) throws CustomException{
	   try {
           String sqlQuery = "DELETE FROM student_table WHERE first_name = ? AND last_name = ? AND cnp_student = ?";
           PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(sqlQuery);
           preparedStatement.setString(1, firstName);
           preparedStatement.setString(2, lastName);
           preparedStatement.setLong(3, pin);

           int rowAf = preparedStatement.executeUpdate();
           if(rowAf == 0) throw new CustomException("Student doesn't exist anymore or pin is incorrect!");
       } catch (Exception e) {
           throw new CustomException("Student doesn't exist anymore or pin is incorrect!");
       }
   }
}
