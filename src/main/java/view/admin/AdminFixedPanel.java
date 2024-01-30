package main.java.view.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JList;

public class AdminFixedPanel extends JPanel{
	private JButton deleteAdminButton;
    private JButton createCourseButton;
    private JButton createClassButton;
    private JButton addPinButton;
    private JButton assignTeacherButton;
    private JButton deleteTeacherButton;
    private JButton assignStudentButton;
    private JButton deleteStudentButton;
    private JButton modifyClassButton;
	
	/**
	 * Create the application.
	 */
	public AdminFixedPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(217, 252, 229), new Color(217, 252, 229), new Color(217, 252, 229), null));
        setBackground(new Color(255, 255, 255));
        setBounds(0, 0, 151, 519);
        setLayout(null);

        deleteAdminButton = new JButton("Delete admin");
        deleteAdminButton.setFont(new Font("Optima", Font.PLAIN, 13));
        deleteAdminButton.setBackground(new Color(255, 255, 255));
        deleteAdminButton.setOpaque(true);
        deleteAdminButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        deleteAdminButton.setBounds(16, 6, 117, 39);
        add(deleteAdminButton);

        createCourseButton = new JButton("Create course");
        createCourseButton.setFont(new Font("Optima", Font.PLAIN, 13));
        createCourseButton.setBackground(new Color(255, 255, 255));
        createCourseButton.setOpaque(true);
        createCourseButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        createCourseButton.setBounds(16, 117, 117, 39);
        add(createCourseButton);

        createClassButton = new JButton("Create class");
        createClassButton.setFont(new Font("Optima", Font.PLAIN, 13));
        createClassButton.setBackground(new Color(255, 255, 255));
        createClassButton.setOpaque(true);
        createClassButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        createClassButton.setBounds(16, 219, 117, 39);
        add(createClassButton);

        addPinButton = new JButton("Add pin");
        addPinButton.setFont(new Font("Optima", Font.PLAIN, 13));
        addPinButton.setBackground(new Color(255, 255, 255));
        addPinButton.setOpaque(true);
        addPinButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        addPinButton.setBounds(16, 168, 117, 39);
        add(addPinButton);

        assignTeacherButton = new JButton("Assign teacher");
        assignTeacherButton.setFont(new Font("Optima", Font.PLAIN, 13));
        assignTeacherButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        assignTeacherButton.setOpaque(true);
        assignTeacherButton.setBackground(new Color(255, 255, 255));
        assignTeacherButton.setBounds(16, 270, 117, 39);
        add(assignTeacherButton);

        deleteTeacherButton = new JButton("Delete teacher");
        deleteTeacherButton.setFont(new Font("Optima", Font.PLAIN, 13));
        deleteTeacherButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        deleteTeacherButton.setOpaque(true);
        deleteTeacherButton.setBackground(new Color(255, 255, 255));
        deleteTeacherButton.setBounds(16, 321, 117, 39);
        add(deleteTeacherButton);

        assignStudentButton = new JButton("Assign student");
        assignStudentButton.setFont(new Font("Optima", Font.PLAIN, 13));
        assignStudentButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        assignStudentButton.setOpaque(true);
        assignStudentButton.setBackground(new Color(255, 255, 255));
        assignStudentButton.setBounds(16, 372, 117, 39);
        add(assignStudentButton);

        deleteStudentButton = new JButton("Delete student");
        deleteStudentButton.setFont(new Font("Optima", Font.PLAIN, 13));
        deleteStudentButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        deleteStudentButton.setOpaque(true);
        deleteStudentButton.setBackground(new Color(255, 255, 255));
        deleteStudentButton.setBounds(16, 423, 117, 39);
        add(deleteStudentButton);

    }
	
	public void addDeleteAdminButtonAction(ActionListener action) {
	    deleteAdminButton.addActionListener(action);
	}

	public void addCreateCourseButtonAction(ActionListener action) {
	    createCourseButton.addActionListener(action);
	}

	public void addCreateClassButtonAction(ActionListener action) {
	    createClassButton.addActionListener(action);
	}

	public void addAddPinButtonAction(ActionListener action) {
	    addPinButton.addActionListener(action);
	}

	public void addAssignTeacherButtonAction(ActionListener action) {
	    assignTeacherButton.addActionListener(action);
	}

	public void addDeleteTeacherButtonAction(ActionListener action) {
	    deleteTeacherButton.addActionListener(action);
	}

	public void addAssignStudentButtonAction(ActionListener action) {
	    assignStudentButton.addActionListener(action);
	}

	public void addDeleteStudentButtonAction(ActionListener action) {
	    deleteStudentButton.addActionListener(action);
	}

	public void addModifyClassButtonAction(ActionListener action) {
	    modifyClassButton.addActionListener(action);
	}
}
