package main.java.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.java.customException.CustomException;

public class AssignStudentPanel extends JPanel{
	JComboBox<String> letterList;
	JComboBox<Integer> yearList;
	JTextField studentPin;
	JButton assignStudentButton;
	
	
	public AssignStudentPanel() {
		init();
	}
	
	public void init() {
		setBackground(new Color(255, 255, 255));
	    setBounds(151, 0, 633, 519);
	    setLayout(null);
	    setVisible(false);

		
		JLabel assignTecherLabel = new JLabel("Assign student to a class");
	    assignTecherLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    assignTecherLabel.setFont(new Font("Optima", Font.ITALIC, 20));
	    assignTecherLabel.setBounds(6, 6, 240, 39);
	    add(assignTecherLabel);
	    
	    JLabel yearLabel = new JLabel("Choose Year");
	    yearLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    yearLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    yearLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    yearLabel.setBounds(212, 254, 122, 39);
	    add(yearLabel);
	    
	    JLabel letteLabel = new JLabel("Choose Letter");
	    letteLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    letteLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    letteLabel.setHorizontalAlignment(SwingConstants.LEFT);
	    letteLabel.setBounds(212, 305, 117, 39);
	    add(letteLabel);
	    
	    JLabel lblNewLabel = new JLabel("Pin student");
	    lblNewLabel.setFont(new Font("Optima", Font.ITALIC, 16));
	    lblNewLabel.setBounds(210, 203, 124, 39);
	    add(lblNewLabel);
	    
	    JLabel descriptionLabel = new JLabel("<html>\n<body>\n\t<div style=\"text-align: center; font-size:15px\"> Assign student to a class</body>");
	    descriptionLabel.setFont(new Font("Optima", Font.PLAIN, 15));
	    descriptionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
	    descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    descriptionLabel.setBounds(147, 78, 367, 88);
	    add(descriptionLabel);
	    
	    studentPin = new JTextField();
	    studentPin.setBounds(346, 209, 210, 26);
	    studentPin.setColumns(10);
	    studentPin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(224, 224, 224), new Color(255, 255, 255), new Color(255, 255, 255), null));
	    add(studentPin);
	    
	    letterList = new JComboBox<>();
	    letterList.setToolTipText("Choose letter");
	    letterList.setMaximumRowCount(100);
	    letterList.setBounds(346, 306, 99, 39);
	    add(letterList);
	    
	    yearList = new JComboBox<>();
	    yearList.setAutoscrolls(true);
	    yearList.setBounds(346, 255, 99, 39);
	    add(yearList);   
	    
	    assignStudentButton = new JButton("Assign student");
	    assignStudentButton.setFont(new Font("Optima", Font.PLAIN, 13));
	    assignStudentButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
	    assignStudentButton.setOpaque(true);
	    assignStudentButton.setBackground(new Color(255, 255, 255));
	    assignStudentButton.setBounds(266, 398, 139, 39);
	    add(assignStudentButton);
	}
	
	public void removeItems() {
		yearList.removeAllItems();
		letterList.removeAllItems();
	}
	
	public Long getPin() throws CustomException{
		long pin;
		try {
			pin = Long.parseLong(String.valueOf(studentPin.getText()));
		}catch(Exception e) {
			throw new CustomException("Pin format is incorrect");
		}
		return pin;
	}
	
	public void setLetterList(List<String> letters) {
		for(String letter : letters) {
			letterList.addItem(letter);
		}
	}
	
	public String getSelectedLetter() throws CustomException {
		Object letter = letterList.getSelectedItem();
		
		if(letter instanceof String) {
			return (String) letter;
		}
		throw new CustomException("Select a letter");
	}

	public void setYearList(List<Integer> years) {
		for(Integer year : years) {
			yearList.addItem(year.intValue());
		}
	}
	
	public int getSelectedYear() throws CustomException{
		Object year = yearList.getSelectedItem();
		
		if(year instanceof Integer) {
			return (int) year;
		}
		throw new CustomException("Select a year");
	}

	public void addAssignStudentButtonAction(ActionListener action) {
		assignStudentButton.addActionListener(action);
	}
}
