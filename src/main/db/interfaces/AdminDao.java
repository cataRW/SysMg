package main.db.interfaces;

import java.util.List;

import main.db.tables.Course;
import main.java.customException.CustomException;
import main.db.tables.Class;


public interface AdminDao {
	public void createCourse(Course courseName) throws CustomException;
	public void createClass(Class classs) throws CustomException;
	public List<Course> getAllCourses() throws CustomException;
	public List<Class> getAllClasses() throws CustomException;
}
