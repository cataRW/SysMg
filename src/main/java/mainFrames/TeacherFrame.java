package main.java.mainFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import main.db.AdminDaoImpl;
import main.db.TeacherDaoImpl;
import main.db.tables.Student;
import main.db.tables.Teacher;
import main.db.tables.Class;
import main.java.customException.CustomException;


public class TeacherFrame extends JFrame{
	private JComboBox<String> studentList;
    private JComboBox<String> classList;
    private JComboBox<Integer> studentsGrade;
    private JButton addGrade;
    private JButton addAbsence;
    private JTextField textField;
    private JPanel panel;
    List<Class> classes = null;
    List<Student> students;
    Teacher teacher;
    AdminDaoImpl adminDaoImpl = new AdminDaoImpl();
    TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
    

    public TeacherFrame(Teacher teacher ) {
    	this.teacher = teacher;
        initialize();
        setClassList();
        
        classList.addItemListener(classListAction());
        addGrade.addActionListener(getConfirmButtonAction());
        setGradeList();
    }

    private void initialize() {
        setBounds(100, 100, 822, 512);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setVisible(true);

        panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 822, 484);
        panel.setLayout(null);
        panel.setVisible(true);
        getContentPane().add(panel);

        JLabel assignTeacherLabel = new JLabel("Wellcome back");
        assignTeacherLabel.setForeground(new Color(25, 86, 223));
        assignTeacherLabel.setHorizontalAlignment(SwingConstants.CENTER);
        assignTeacherLabel.setFont(new Font("Optima", Font.ITALIC, 26));
        assignTeacherLabel.setBounds(298, 53, 240, 39);
        panel.add(assignTeacherLabel);

        studentList = new JComboBox<>();
        studentList.setAutoscrolls(true);
        studentList.setToolTipText("Choose letter");
        studentList.setMaximumRowCount(100);
        studentList.setBounds(310, 216, 339, 39);
        panel.add(studentList);

        classList = new JComboBox<>();
        classList.setAutoscrolls(true);
        classList.setToolTipText("Choose year");
        classList.setMaximumRowCount(100);
        classList.setBounds(310, 153, 399, 39);
        panel.add(classList);

        addGrade = new JButton("Add absence");
        addGrade.setFont(new Font("Optima", Font.PLAIN, 13));
        addGrade.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        addGrade.setOpaque(true);
        addGrade.setBackground(new Color(255, 255, 255));
        addGrade.setBounds(453, 402, 139, 39);
        panel.add(addGrade);
        
        JLabel lblNewLabel = new JLabel("Choose a class");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel.setFont(new Font("Optima", Font.ITALIC, 18));
        lblNewLabel.setBounds(103, 151, 154, 39);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Choose a student");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Optima", Font.ITALIC, 18));
        lblNewLabel_1.setBounds(103, 214, 154, 39);
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Mark details");
        lblNewLabel_2.setFont(new Font("Optima", Font.ITALIC, 18));
        lblNewLabel_2.setBounds(103, 337, 154, 39);
        panel.add(lblNewLabel_2);
        
        textField = new JTextField();
        textField.setBounds(310, 344, 399, 26);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_3 = new JLabel("Select student's grade");
        lblNewLabel_3.setFont(new Font("Optima", Font.ITALIC, 18));
        lblNewLabel_3.setBounds(103, 275, 196, 39);
        panel.add(lblNewLabel_3);
        
        studentsGrade = new JComboBox<>();
        studentsGrade.setBounds(310, 283, 121, 27);
        panel.add(studentsGrade);
        
        addAbsence = new JButton("Add grade\n");
        addAbsence.setFont(new Font("Optima", Font.PLAIN, 13));
        addAbsence.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        addAbsence.setOpaque(true);
        addAbsence.setBackground(new Color(255, 255, 255));
        addAbsence.setBounds(222, 402, 139, 39);
        panel.add(addAbsence);
    }
    
    public List<Class> getAllClasses() {
    	try {
    		if(Objects.isNull(classes)) classes = adminDaoImpl.getAllClasses();
    	}catch(CustomException e) {
    		JOptionPane.showMessageDialog(panel, e.getMessage(), "Invalid data format", JOptionPane.ERROR_MESSAGE);
    	}
    	return classes;
    }
    
    public void setClassList() {
    	List<Class> classList = getAllClasses();
    	if(!Objects.isNull(classList)) {
    		for(Class classs : classList) {
    			this.classList.addItem(classs.getYear() + " " + classs.getLetter());
    		}
    	}
    }
    
    public ItemListener classListAction() {
    	return new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
                	String className = (String) classList.getSelectedItem();
                	String[] tokens = className.split(" ");
    				int year = Integer.valueOf(Integer.parseInt(tokens[0]));
    				String letter = tokens[1];
    				int classId = adminDaoImpl.getIdClassIfExist(year, letter);
    				students = teacherDaoImpl.getStudentListByClassId(classId);
    				
    				if(students.isEmpty()) {
    					JOptionPane.showMessageDialog(panel, "Class is empty", "Invalid data format", JOptionPane.ERROR_MESSAGE);
    					studentList.removeAllItems();
    				}else {
    					if(studentList.getItemCount() > 0) studentList.removeAllItems();
    					for(Student student : students) {
    						studentList.addItem(student.getFirstName() + " " + student.getLastName());
    					}
    				}
                }	
			}
    	};
    }
    
    public void setGradeList() {
		List<Integer> grades = generateNumberList(1, 10);
		for(Integer grade : grades) {
			studentsGrade.addItem(grade.intValue());
		}
	}
    
    private List<Integer> generateNumberList(int start, int end) {
        List<Integer> numberList = new ArrayList<>();
        
        for (int num = start; num <= end; num++) {
            numberList.add(num);
        }
        
        return numberList;
    }
    
    public String getDescriptionGrade() {
    	return String.valueOf(textField.getText());
    }
    
    public int getSelectedGrade() {
    	return (int) studentsGrade.getSelectedItem();
    }
    
    public Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }

    public ActionListener getConfirmButtonAction() {
    	return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String description = getDescriptionGrade();
				Date currentDate = getCurrentDate();
				String completeName = (String) studentList.getSelectedItem();
				String[] tokens = completeName.split(" ");
				List<Student> selectedStudent = students.stream().filter(student -> student.getFirstName().equals(tokens[0]) && student.getLastName().equals(tokens[1])).collect(Collectors.toList());
				int grade = (int) studentsGrade.getSelectedItem();
				teacherDaoImpl.addStudentGrade(selectedStudent.get(1), grade, currentDate);
				studentList.removeAllItems();
				textField.setText("");
			}
    		
    	};
    }
}
