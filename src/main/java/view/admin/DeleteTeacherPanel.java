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

public class DeleteTeacherPanel extends JPanel{
	JComboBox<String> teacherList;
	JTextField teacherPin;
	JButton confirmButton;
	
	
	public DeleteTeacherPanel() { init(); }
	
	public void init() {
	    setBackground(new Color(255, 255, 255));
	    setBounds(151, 0, 633, 519);
	    setLayout(null);
	    setVisible(false);

	    JLabel deleteAdminLabel = new JLabel("Delete teacher");
	    deleteAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    deleteAdminLabel.setFont(new Font("Optima", Font.ITALIC, 20));
	    deleteAdminLabel.setBounds(0, 0, 188, 39);
	    add(deleteAdminLabel);
	    
	    teacherList = new JComboBox<>();
	    teacherList.setMaximumRowCount(100);
	    teacherList.setBounds(142, 200, 298, 32);
	    add(teacherList);
	    
	    JLabel lblNewLabel_1 = new JLabel("Select the teacher that you want to remove");
	    lblNewLabel_1.setFont(new Font("Optima", Font.PLAIN, 15));
	    lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setBounds(142, 156, 292, 32);
	    add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Confirm with the pin of teacher");
	    lblNewLabel_2.setFont(new Font("Optima", Font.PLAIN, 15));
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_2.setBounds(142, 269, 292, 27);
	    add(lblNewLabel_2);
	    
	    teacherPin = new JTextField();
	    teacherPin.setBounds(142, 308, 292, 32);
	    teacherPin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(224, 224, 224), new Color(255, 255, 255), new Color(255, 255, 255), null));
	    teacherPin.setColumns(50);
	    add(teacherPin);
	    
	    confirmButton = new JButton("Confirm deletion");
	    confirmButton.setFont(new Font("Optima", Font.PLAIN, 13));
	    confirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
	    confirmButton.setOpaque(true);
	    confirmButton.setBackground(new Color(255, 255, 255));
	    confirmButton.setBounds(215, 367, 139, 32);
	    add(confirmButton);
	}
	
	public void removeItems() {
		teacherList.removeAllItems();
	}
	
	public void setTeacherList(List<String> teacherList) {
		for(String teacherName : teacherList) {
			this.teacherList.addItem(teacherName);
		}
	}
	
	public String getSelectedItem() throws CustomException{
	    Object selectedItem = teacherList.getSelectedItem();
	    
	    if (selectedItem instanceof String) {
	        return (String) selectedItem;
	    } 
	    throw new CustomException("Select a teacher"); 		    
	}

	public Long getPin() throws CustomException{
		long pin;
		try {
			pin = Long.parseLong(String.valueOf(teacherPin.getText()));
		}catch(Exception e) {
			throw new CustomException("Pin format is incorrect");
		}
		return pin;
	}

	public void addConfirmButtonAction(ActionListener action) {
		confirmButton.addActionListener(action);
	}
	
}
