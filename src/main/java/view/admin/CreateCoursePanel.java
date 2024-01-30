package main.java.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class CreateCoursePanel extends JPanel{
	
	private JTextField courseNameField;
    private JButton confirmCourseButton;

    public CreateCoursePanel() {
        init();
    }

    public void init() {
    	setBackground(new Color(255, 255, 255));
    	setBounds(151, 0, 633, 519);
        setLayout(null);
	    setVisible(false);

        JLabel lblNewLabel = new JLabel("Create course");
        lblNewLabel.setFont(new Font("Optima", Font.ITALIC, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(6, 6, 168, 45);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Type name of course, the name shouldn't contain space!");
        lblNewLabel_1.setFont(new Font("Optima", Font.ITALIC, 15));
        lblNewLabel_1.setBounds(126, 120, 379, 56);
        add(lblNewLabel_1);

        courseNameField = new JTextField();
        courseNameField.setHorizontalAlignment(SwingConstants.CENTER);
        courseNameField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(224, 224, 224), new Color(255, 255, 255), new Color(255, 255, 255), null));
        courseNameField.setBounds(142, 188, 347, 31);
        add(courseNameField);
        courseNameField.setColumns(10);

        confirmCourseButton = new JButton("Create course");
        confirmCourseButton.setFont(new Font("Optima", Font.PLAIN, 13));
        confirmCourseButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
        confirmCourseButton.setOpaque(true);
        confirmCourseButton.setBackground(new Color(255, 255, 255));
        confirmCourseButton.setBounds(237, 282, 139, 32);
        add(confirmCourseButton);
    }

    public String getCourseNameField() {
        return String.valueOf(courseNameField.getText());
    }

    public void addConfirmButtonAction(ActionListener action) {
        confirmCourseButton.addActionListener(action);
    }
}
