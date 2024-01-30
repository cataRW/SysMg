package main.java.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.db.tables.Admin;
import main.db.tables.Class;
import main.db.tables.Course;
import main.db.tables.Student;
import main.db.tables.Teacher;
import main.java.customException.CustomException;
import main.java.mainFrames.AdminFrame;

import main.java.view.admin.AddPinPanel;
import main.java.view.admin.AdminFixedPanel;
import main.java.view.admin.AssignStudentPanel;
import main.java.view.admin.AssignTeacherPanel;
import main.java.view.admin.CreateClassPanel;
import main.java.view.admin.CreateCoursePanel;
import main.java.view.admin.DeleteAdminPanel;
import main.java.view.admin.DeleteStudentPanel;
import main.java.view.admin.DeleteTeacherPanel;

public class AdminController {
	private AdminFixedPanel adminFixedPart;
	private AddPinPanel addPinPanel;
	private AssignStudentPanel assignStudentPanel;
	private AssignTeacherPanel assignTeacherPanel;
	private CreateClassPanel createClassPanel;
	private CreateCoursePanel createCoursePanel;
	private DeleteAdminPanel deleteAdminPanel;
	private DeleteTeacherPanel deleteTeacherPanel;
	private DeleteStudentPanel deleteStudentPanel;
	private JPanel visiblePanel;
	List<Class> allClasses;
	List<Course> allCourses;
	List<Teacher> teacherList;
	List<Student> studentList;
	
	public AdminController() {
		addPinPanel = new AddPinPanel();
		assignStudentPanel = new AssignStudentPanel();
		assignTeacherPanel = new AssignTeacherPanel();
		createClassPanel = new CreateClassPanel();
		createCoursePanel = new CreateCoursePanel();
		deleteAdminPanel = new DeleteAdminPanel();
		deleteTeacherPanel = new DeleteTeacherPanel();
		deleteStudentPanel = new DeleteStudentPanel();
		
		visiblePanel = deleteAdminPanel;
		visiblePanel.setVisible(true);
		
		deleteAdminPanel.addConfirmButtonAction(deleteAdmin());
		createCoursePanel.addConfirmButtonAction(createCourse());
		addPinPanel.addConfirmButtonAction(addPin());
		createClassPanel.addConfirmButtonAction(createClass());
		assignTeacherPanel.addAssignTeacherButtonAction(assingTeacher());
		deleteTeacherPanel.addConfirmButtonAction(deleteTeacher());
		assignStudentPanel.addAssignStudentButtonAction(assignStudent());
		deleteStudentPanel.addConfirmButtonAction(deleteStudent());
		
		deleteAdminPanel.addAdminList(getAdminName());
		
		assignTeacherPanel.setYearOfStudyList(getYearOfClasses());
		assignTeacherPanel.setLetterOfStudYearList(getLetterOfClasses());
		assignTeacherPanel.setCourseList(getCoursesName());
		assignTeacherPanel.setTeacherList(getTeacher());
		
		deleteTeacherPanel.setTeacherList(getTeacher());
		
		assignStudentPanel.setYearList(getYearOfClasses());
		assignStudentPanel.setLetterList(getLetterOfClasses());
		
		deleteStudentPanel.setStudentList(getStudentName());
	}

	/**
	 * @return the adminFixedPart
	 */
	public AdminFixedPanel getAdminFixedPart() {
		return adminFixedPart;
	}
	
	/**
	 * @return the addPinPanel
	 */
	public AddPinPanel getAddPinPanel() {
		return addPinPanel;
	}

	/**
	 * @return the assignStudentPanel
	 */
	public AssignStudentPanel getAssignStudentPanel() {
		return assignStudentPanel;
	}

	/**
	 * @return the assignTeacherPanel
	 */
	public AssignTeacherPanel getAssignTeacherPanel() {
		return assignTeacherPanel;
	}

	/**
	 * @return the createClassPanel
	 */
	public CreateClassPanel getCreateClassPanel() {
		return createClassPanel;
	}

	/**
	 * @return the createCoursePanel
	 */
	public CreateCoursePanel getCreateCoursePanel() {
		return createCoursePanel;
	}

	/**
	 * @return the deleteAdminPanel
	 */
	public DeleteAdminPanel getDeleteAdminPanel() {
		return deleteAdminPanel;
	}

	/**
	 * @return the deleteTeacherPanel
	 */
	public DeleteTeacherPanel getDeleteTeacherPanel() {
		return deleteTeacherPanel;
	}
	
	public DeleteStudentPanel getDeleteStudentPanel() {
		return deleteStudentPanel;
	}
	
	public void changeSecondPanel(int numberOfPanel) {
		visiblePanel.setVisible(false);
		switch (numberOfPanel) {
        case 1:
            visiblePanel = deleteAdminPanel;
            break;
        case 2:
        	visiblePanel = createCoursePanel;
            break;
        case 3:
        	visiblePanel = addPinPanel;
            break;
        case 4:
        	visiblePanel = createClassPanel;
            break;
        case 5:
        	visiblePanel = assignTeacherPanel;
        	break;
        case 6:
        	visiblePanel = deleteTeacherPanel;
        	break;
        case 7:
        	visiblePanel = assignStudentPanel;
        	break;
        case 8:
        	visiblePanel = deleteStudentPanel;
        	break;
		}
		visiblePanel.setVisible(true);
	}
	
	public List<Student> getStudentList() {
		return AdminFrame.getStudentList();
	}
	
	public void updateLists() {
		try {
			allCourses = AdminFrame.getAllCourses();
			allClasses = AdminFrame.getAllClasses();
			teacherList = AdminFrame.getTeacherList();
			
			assignTeacherPanel.removeItems();
			assignTeacherPanel.setYearOfStudyList(getYearOfClasses());
			assignTeacherPanel.setLetterOfStudYearList(getLetterOfClasses());
			assignTeacherPanel.setCourseList(getCoursesName());
			assignTeacherPanel.setTeacherList(getTeacher());
			
			deleteTeacherPanel.removeItems();
			deleteTeacherPanel.setTeacherList(getTeacher());
			
			assignStudentPanel.removeItems();
			assignStudentPanel.setYearList(getYearOfClasses());
			assignStudentPanel.setLetterList(getLetterOfClasses());
			
			deleteStudentPanel.removeItems();
			deleteStudentPanel.setStudentList(getStudentName());
		}catch(Exception e) {
			
		}
	}
	
	public List<String> getStudentName(){
		List<String> nameAndClass =  getStudentList().stream().map(student -> student.getFirstName() + " " + student.getLastName()).collect(Collectors.toList());
		return nameAndClass;
	}
	
	public List<Course> getAllCourses(){
		try {
			if(Objects.isNull(allCourses)) allCourses = AdminFrame.getAllCourses();
			return allCourses;
		} catch (CustomException e) {
			
		}
		return null;
	}
	
 	public List<Class> getAllClasses() throws CustomException{
		try {
			if(Objects.isNull(allClasses)) allClasses = AdminFrame.getAllClasses();
		}catch (CustomException exc){
			throw new CustomException("Could't get classes");
		}
		
		return allClasses;	
	}
 	
 	public List<String> getCoursesName(){
 		return getAllCourses().stream().map(course -> course.getName()).collect(Collectors.toList());
 	}
	
	
 	public List<Admin> getAdminList() throws CustomException{
		return AdminFrame.getAdminList();
	}
	
	
 	public List<String> getLetterOfClasses() {
		List<String> letters = new ArrayList<>();
		try {
			List<Class> classes = getAllClasses();
			List<String> letters2 = classes.stream().map(classs -> classs.getLetter()).collect(Collectors.toList());
			Set<String> distinctLetters = new TreeSet<>();
			distinctLetters.addAll(letters2);
			letters.addAll(distinctLetters);
			
			if(Objects.isNull(letters)) throw new CustomException("No existing class");
			return letters;
		}catch(CustomException exc) {
			JOptionPane.showMessageDialog(assignTeacherPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
 	
	
	
	public List<String> getAdminName(){
		List<String> adminName = new ArrayList<>();
		try {
			List<Admin> adminList = getAdminList();
			for(Admin admin : adminList) {
				adminName.add(admin.getFirstName() + " " + admin.getLastName());
			}
			return adminName;
		}catch(CustomException exc){
			JOptionPane.showMessageDialog(assignTeacherPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
		}
		return adminName;
	}
	
	
	
	public List<Integer> getYearOfClasses() {
		List<Integer> yearList = new ArrayList<>();
		try {
			List<Class> classList = getAllClasses();
			List<Integer> yearList2 = classList.stream().map(classs -> classs.getYear()).collect(Collectors.toList());
			Set<Integer> distinctYears = new TreeSet<>();
			distinctYears.addAll(yearList2);
			yearList.addAll(distinctYears);
			return yearList;
		}catch(CustomException exc){
			
		}
		return yearList;
	}
	
	
	public List<String> getTeacher() {
		if(Objects.isNull(teacherList)) {
			teacherList = AdminFrame.getTeacherList();
		}
		return teacherList.stream().map(teacher -> teacher.getFirstName() + " " + teacher.getLastName()).collect(Collectors.toList());
	}
	

	public ActionListener deleteAdmin() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String choice = deleteAdminPanel.getSelectedItem();
					String[] completeName = choice.split(" ");
					String firstName = completeName[0];
					String lastName = completeName[1];
					List<Admin> adminList = getAdminList();
					
					Admin admin = null;
					long pin = Long.MAX_VALUE;
					
					try {
						pin = Long.valueOf(Long.parseLong(deleteAdminPanel.getPin()));
					}catch(Exception exc) {
						throw new CustomException("Invalid data format");
					}
					
					for(Admin element : adminList) {
						if(element.getFirstName().equals(firstName) && element.getLastName().equals(lastName)) {
							admin = element;
							break;
						}
					}
					
					if(adminList.size() < 2) JOptionPane.showMessageDialog(deleteAdminPanel, "Can't delete admin because there is a single admin", "Invalid data format", JOptionPane.ERROR_MESSAGE);		
					else if(Long.valueOf(admin.getPin()) == pin && !Objects.isNull(admin)) AdminFrame.deleteAdmin(admin);
					else JOptionPane.showMessageDialog(deleteAdminPanel, "Pin is not correct", "Invalid data format", JOptionPane.ERROR_MESSAGE);
				
				}catch(Exception exc){
					JOptionPane.showMessageDialog(deleteAdminPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		};
	}
	
	
	public ActionListener createCourse() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String courseName = createCoursePanel.getCourseNameField();
				Course course = new Course();
				course.setName(courseName);
				if(courseName.isEmpty()) JOptionPane.showMessageDialog(createCoursePanel, "You have to insert a name for course", "Invalid data format", JOptionPane.ERROR_MESSAGE);
				else {
					try {
						AdminFrame.createCourse(course);
					}catch (Exception exc){
						JOptionPane.showMessageDialog(createCoursePanel, "Course already exist", "Invalid data format", JOptionPane.ERROR_MESSAGE);
					}
					updateLists();
				}
			}
			
		};
	}
	
	
	public ActionListener addPin() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				long pin;
				int type_id;
				try {
					if(addPinPanel.getPin().length() != 13) throw new CustomException("Pin format is not valid");
					type_id = addPinPanel.getSelectedItem();
					try {
						pin = Long.valueOf(Long.parseLong(addPinPanel.getPin()));
					}catch(Exception ex) {
						throw new CustomException("Pin format is not valid");
					}
					AdminFrame.addPin(pin, type_id);
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(addPinPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		};
	}
	

	public ActionListener createClass() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class classs = new Class();
					classs.setYear(createClassPanel.getSelectedYear());
					classs.setLetter(createClassPanel.getSelectedLetter());
				
					AdminFrame.createClass(classs);
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(createClassPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
				updateLists();
			}
		};
	}
	

	public ActionListener assingTeacher() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int year = assignTeacherPanel.getSelectedYear();
					String letter = assignTeacherPanel.getSelectedLetter();
					String courseName = assignTeacherPanel.getSelectedCourse();
					String teacher = assignTeacherPanel.getSelectedTeacher();
					String[] teacherTokens = teacher.split(" ");
					String teacherFirstName = teacherTokens[0];
					String teacherLastName = teacherTokens[1];
					
					AdminFrame.enrollTeacherToClass(teacherFirstName, teacherLastName, year, letter, courseName);
				}catch(CustomException exc) {
					JOptionPane.showMessageDialog(assignTeacherPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	
	public ActionListener deleteTeacher() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String teacher = deleteTeacherPanel.getSelectedItem();
					String[] teacherTokens = teacher.split(" ");
					String teacherFirstName = teacherTokens[0];
					String teacherLastName = teacherTokens[1];
					long pin = deleteTeacherPanel.getPin();
							
							
					AdminFrame.deleteTeacher(teacherFirstName, teacherLastName, pin);
				}catch(CustomException exc){
					JOptionPane.showMessageDialog(deleteTeacherPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
				updateLists();
			}
		};
	}
	
	
	public ActionListener assignStudent() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long pin = assignStudentPanel.getPin();
					int year = assignStudentPanel.getSelectedYear();
					String letter = assignStudentPanel.getSelectedLetter();
					AdminFrame.enrollStudentToClass(year, letter, pin);
				}catch(CustomException exc) {
					JOptionPane.showMessageDialog(assignStudentPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		};
	}
	
	
	public ActionListener deleteStudent() {
		return new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					String student = deleteStudentPanel.getSelectedItem();
					String[] studentTokens = student.split(" ");
					String studentFirstName = studentTokens[0];
					String studentLastName = studentTokens[1];
					long pin = deleteStudentPanel.getPin();
							
							
					AdminFrame.deleteStudent(studentFirstName, studentLastName, pin);
				}catch(CustomException exc){
					JOptionPane.showMessageDialog(deleteStudentPanel, exc.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
				}
				updateLists();
			}
		};
	}
}









