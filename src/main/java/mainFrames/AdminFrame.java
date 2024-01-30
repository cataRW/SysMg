package main.java.mainFrames;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;

import main.db.tables.Class;
import main.db.AdminDaoImpl;
import main.db.tables.Admin;
import main.db.tables.Course;
import main.db.tables.Student;
import main.db.tables.Teacher;
import main.java.controller.admin.AdminController;
import main.java.controller.admin.AdminFixedSideController;
import main.java.customException.CustomException;


public class AdminFrame extends JFrame{
	private AdminFixedSideController controllerFixedSide;
	private AdminController adminController;
	public static AdminDaoImpl adminDaoImpl = new AdminDaoImpl();;
	
	public AdminFrame() {
		controllerFixedSide = new AdminFixedSideController();
		adminController = new AdminController();
		init();
	}
	
	public void init() {
		setBounds(100, 100, 784, 547);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(controllerFixedSide.getAdminFixedPanel());
		getContentPane().add(adminController.getAddPinPanel());
		getContentPane().add(adminController.getAssignStudentPanel());
		getContentPane().add(adminController.getAssignTeacherPanel());
		getContentPane().add(adminController.getCreateClassPanel());
		getContentPane().add(adminController.getCreateCoursePanel());
		getContentPane().add(adminController.getDeleteAdminPanel());
		getContentPane().add(adminController.getDeleteTeacherPanel());
		getContentPane().add(adminController.getDeleteStudentPanel());
		
		setVisible(true);
		setResizable(false);
		adminController.changeSecondPanel(1);
	}
	

	public static void deleteAdmin(Admin admin) throws CustomException, SQLException{
		try {
			adminDaoImpl.deleteAdmin(admin);
		}catch(SQLException ex) {
			throw new CustomException("Admin don't exist");
		}

	}
	
	public static void deleteStudent(String firstName, String lastName, long pin) throws CustomException{
		adminDaoImpl.deleteStudent(firstName, lastName, pin);
	}
	
	public static void deleteTeacher(String teacherFirstName, String teacherLastName, long pin) throws CustomException{
			int id_admin = adminDaoImpl.getTeacherIdByFullName(teacherFirstName, teacherLastName);
			adminDaoImpl.deleteTeacherByIdAndPin(id_admin, pin);
	}
	
	public static void createCourse(Course course) throws CustomException, SQLException{
		adminDaoImpl.createCourse(course);
	}
	
	public static void addPin(long pin, int type_account) throws CustomException, SQLException{
		adminDaoImpl.addPin(pin, type_account);
	}
	
	public static void createClass(Class classs) throws CustomException{
		adminDaoImpl.createClass(classs);
	}
	
	public static void enrollTeacherToClass(String teacherFirstName, String teacherLastName, int year, String letter, String courseName) throws CustomException {
		int id_course = adminDaoImpl.getIdCourseIfExist(courseName);
		int id_class = adminDaoImpl.getIdClassIfExist(year, letter);
		
		if(id_class == 0) throw new CustomException("Class doesn't exist, try another option");

		
		try{
			adminDaoImpl.enrollCourseToClass(id_course, id_class);
		}catch(Exception e) {
			
		}finally {
			int classCourseEnrollmentId = adminDaoImpl.getEnrollmentIdByCourseAndClass(id_course, id_class);
			int id_teacher = adminDaoImpl.getTeacherIdByFullName(teacherFirstName, teacherLastName);
			
			adminDaoImpl.addEnrollment(classCourseEnrollmentId, id_teacher);
		}
		
	}
	
	public static void enrollStudentToClass(int year, String letter, long pin) throws CustomException{
		adminDaoImpl.enrollStudentToClass(year, letter, pin);
	}
	
	public static List<Admin> getAdminList() throws CustomException{
		return adminDaoImpl.getAdminList();
	}
	
	public static List<Class> getAllClasses() throws CustomException{
		return adminDaoImpl.getAllClasses();
	}
	
	public static List<Course> getAllCourses() throws CustomException{
		return adminDaoImpl.getAllCourses();
	}
	
	public static List<Teacher> getTeacherList(){
		return adminDaoImpl.getAllTeachers();
	}
	
	public static List<Student> getStudentList(){
		return adminDaoImpl.getAllStudents();
	}
	
	public void changeSecondPanel(int nrOfPanel) {
		adminController.changeSecondPanel(nrOfPanel);
	}
}
