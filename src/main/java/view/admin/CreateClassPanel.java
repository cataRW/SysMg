package main.java.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.java.customException.CustomException;

public class CreateClassPanel extends JPanel {
    JComboBox<String> letterOfYear;
    JComboBox<Integer> yearOfStudy;
    JButton createClassButton;
    
    public CreateClassPanel() {
        init();
    }
    
    public void init() {
        setBackground(new Color(255, 255, 255));
        setBounds(151, 0, 633, 519);
        setLayout(null);
	    setVisible(false);

        JLabel createClassLabel = new JLabel("Create new class");
        createClassLabel.setHorizontalAlignment(SwingConstants.CENTER);
        createClassLabel.setFont(new Font("Optima", Font.ITALIC, 20));
        createClassLabel.setBounds(6, 6, 156, 39);
        add(createClassLabel);
        
        letterOfYear = new JComboBox<>();
        letterOfYear.setToolTipText("Choose letter");
        letterOfYear.setMaximumRowCount(100);
        letterOfYear.setBounds(310, 314, 99, 33);
        letterOfYear.setAutoscrolls(true);
        add(letterOfYear);
        setLetterOfStudYearList();
        
        yearOfStudy = new JComboBox<>();
        yearOfStudy.setAutoscrolls(true);
        yearOfStudy.setBounds(310, 249, 99, 27);
        add(yearOfStudy);
        setYearOfStudyList();
        
        JLabel descriptionLabel = new JLabel("<html>\n<body>\n\t<div style=\"text-align: center\"> Create a new class by choosing the year of the class and also you have to choose the letter of the class for a better distinction between the class with the same year of study</body>");
        descriptionLabel.setFont(new Font("Optima", Font.PLAIN, 15));
        descriptionLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descriptionLabel.setBounds(131, 110, 367, 88);
        add(descriptionLabel);
        
        JLabel yearLabel = new JLabel("Choose Year");
        yearLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.setBounds(187, 248, 111, 27);
        add(yearLabel);
        
        JLabel letterLabel = new JLabel("Choose Letter");
        letterLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        letterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        letterLabel.setBounds(199, 316, 99, 26);
        add(letterLabel);
        
        createClassButton = new JButton("Create class");
        createClassButton.setFont(new Font("Optima", Font.PLAIN, 13));
        createClassButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        createClassButton.setOpaque(true);
        createClassButton.setBackground(new Color(255, 255, 255));
        createClassButton.setBounds(234, 386, 139, 32);
        add(createClassButton);
    }
    
    private List<String> generateAlphabetList() {
        List<String> alphabetList = new ArrayList<>();
        
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphabetList.add(String.valueOf(ch));
        }
        
        return alphabetList;
    }
    
    private List<Integer> generateNumberList(int start, int end) {
        List<Integer> numberList = new ArrayList<>();
        
        for (int num = start; num <= end; num++) {
            numberList.add(num);
        }
        
        return numberList;
    }

    public int getSelectedYear() throws CustomException{
	    Object selectedItem = yearOfStudy.getSelectedItem();
	    
	    if (selectedItem instanceof Integer) {
	        return Integer.valueOf((Integer) selectedItem);
	    } 
	    throw new CustomException("Select year of study"); 		    
	}

    public String getSelectedLetter() throws CustomException{
	    Object selectedItem = letterOfYear.getSelectedItem();
	    
	    if (selectedItem instanceof String) {
	        return (String) selectedItem; 
	    } 
	    throw new CustomException("Select a letter"); 		    
	}

    public void setYearOfStudyList() {
    	List<Integer> yearsOfStudyList = generateNumberList(5,12);
    	for(Integer year : yearsOfStudyList) {
    		yearOfStudy.addItem(year.intValue());
    	}
    }
    
    public void setLetterOfStudYearList() {
    	List<String> letterOfStudYear = generateAlphabetList();
    	for(String letter : letterOfStudYear) {
    		letterOfYear.addItem(letter);
    	}
    }
    
	public void addConfirmButtonAction(ActionListener action) {
		createClassButton.addActionListener(action);
	}
}

