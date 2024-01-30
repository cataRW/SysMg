package main.java.view.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.db.tables.Admin;
import main.db.tables.Class;
import main.db.tables.Course;
import main.java.customException.CustomException;
import main.java.mainFrames.AdminFrame;

public class AssignTeacherPanel extends JPanel{
	private JComboBox<Integer> yearOfStudyList;
	private JComboBox<String> letterOfStudYearList;
	private JComboBox<String> teacherList;
	private JComboBox<String> courseList;
	private JButton assignTeacherButton;
	
	public AssignTeacherPanel() {
		init();
	}
	
	public void init() {
		setBackground(new Color(255, 255, 255));
        setBounds(151, 0, 633, 519);
        setLayout(null);
	    setVisible(false);

        JLabel assignTecherLabel = new JLabel("Assign teacher to a class");
	    assignTecherLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    assignTecherLabel.setFont(new Font("Optima", Font.ITALIC, 20));
	    assignTecherLabel.setBounds(6, 6, 240, 39);
	    add(assignTecherLabel);
	    
	    JLabel descriptionLabel = new JLabel("<html>\n<body>\n\t<div style=\"text-align: center; font-size:15px\"> Assign teacher to a class</body></html>");
	    descriptionLabel.setFont(new Font("Optima", Font.PLAIN, 15));
	    descriptionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    descriptionLabel.setBounds(147, 78, 367, 88);
	    add(descriptionLabel);
	    
	    JLabel yearLabel = new JLabel("Choose Year");
	    yearLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    yearLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    yearLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    yearLabel.setBounds(176, 170, 122, 39);
	    add(yearLabel);
	    
	    JLabel letteLabel = new JLabel("Choose Letter");
	    letteLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    letteLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    letteLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    letteLabel.setBounds(176, 227, 117, 39);
	    add(letteLabel);
	    
	    JLabel lblNewLabel = new JLabel("Choose Teacher");
	    lblNewLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    lblNewLabel.setBounds(176, 329, 117, 39);
	    add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Choose Course");
	    lblNewLabel_1.setFont(new Font("Optima", Font.ITALIC, 16));
	    lblNewLabel_1.setBounds(176, 278, 122, 39);
	    add(lblNewLabel_1);
	    
	    
	    letterOfStudYearList = new JComboBox<>();
	    letterOfStudYearList.setAutoscrolls(true);
	    letterOfStudYearList.setToolTipText("Choose letter");
	    letterOfStudYearList.setMaximumRowCount(100);
	    letterOfStudYearList.setBounds(310, 228, 99, 39);
	    add(letterOfStudYearList);
	    
	    yearOfStudyList = new JComboBox<>();
	    yearOfStudyList.setAutoscrolls(true);
	    yearOfStudyList.setToolTipText("Choose year");
	    yearOfStudyList.setMaximumRowCount(100);
	    yearOfStudyList.setBounds(310, 178, 99, 39);
	    add(yearOfStudyList);
	    
	    teacherList = new JComboBox<>();
	    teacherList.setAutoscrolls(true);
	    teacherList.setToolTipText("Choose teacher");
	    teacherList.setMaximumRowCount(100);
	    teacherList.setBounds(310, 336, 259, 39);
	    add(teacherList);
	    
	    
	    courseList = new JComboBox<>();
	    courseList.setAutoscrolls(true);
	    courseList.setToolTipText("Choose letter");
	    courseList.setMaximumRowCount(100);
	    courseList.setBounds(310, 279, 259, 39);
	    add(courseList);
	   
	    
	    assignTeacherButton = new JButton("Assign Teacher");
	    assignTeacherButton.setFont(new Font("Optima", Font.PLAIN, 13));
	    assignTeacherButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
	    assignTeacherButton.setOpaque(true);
	    assignTeacherButton.setBackground(new Color(255, 255, 255));
	    assignTeacherButton.setBounds(266, 398, 139, 39);
	    add(assignTeacherButton);   
	}
	
	public void removeItems() {
		yearOfStudyList.removeAllItems();
		letterOfStudYearList.removeAllItems();
		teacherList.removeAllItems();
		courseList.removeAllItems();
	}
	
	public void setYearOfStudyList(List<Integer> years) {
		for(Integer year : years) {
			yearOfStudyList.addItem(year.intValue());
		}
	}
	
	public int getSelectedYear() throws CustomException {
	    Object selectedYear = yearOfStudyList.getSelectedItem();
	    
	    if (selectedYear instanceof Integer) {
	        return (int) selectedYear;
	    } 
	    throw new CustomException("Select an year");
	}
	
	public void setLetterOfStudYearList(List<String> letters) {
		for(String letter : letters) {
			letterOfStudYearList.addItem(letter);
		}
	}
	
	public String getSelectedLetter() throws CustomException{
		Object selectedLetter = letterOfStudYearList.getSelectedItem();
	    
	    if (selectedLetter instanceof String) {
	        return (String) selectedLetter;
	    } 
	    
	    throw new CustomException("Select a letter"); 		   
	}
	
	public void setCourseList(List<String> courses) {
		for(String course : courses) {
			courseList.addItem(course);
		}
	}

	public String getSelectedCourse() throws CustomException{
		Object selectedCourse = courseList.getSelectedItem();
		
		if(selectedCourse instanceof String) {
			return (String) selectedCourse;
		}
		
		throw new CustomException("Select a course");
	}
	
	public void setTeacherList(List<String> teachers) {
		for(String teacher : teachers) {
			teacherList.addItem(teacher);
		}
	}

	public String getSelectedTeacher() throws CustomException{
		Object selectedTeacher = teacherList.getSelectedItem();
		
		if(selectedTeacher instanceof String) {
			return (String) selectedTeacher;
		}
		
		throw new CustomException("Select a course");
	}

	public int getListCount() {
		return yearOfStudyList.getItemCount();
	}
	
	public void addAssignTeacherButtonAction(ActionListener action) {
		assignTeacherButton.addActionListener(action);
	}
}
