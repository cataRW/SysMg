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


public class DeleteAdminPanel extends JPanel{
	JComboBox<String> adminList;
	JTextField textField;
	JButton confirmButton;
	
	
	public DeleteAdminPanel() { init(); }
	
	public void init() {
	    setBackground(new Color(255, 255, 255));
	    setBounds(151, 0, 633, 519);
	    setLayout(null);
	    setVisible(false);

	    JLabel deleteAdminLabel = new JLabel("Delete admin");
	    deleteAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    deleteAdminLabel.setFont(new Font("Optima", Font.ITALIC, 20));
	    deleteAdminLabel.setBounds(0, 0, 188, 39);
	    add(deleteAdminLabel);
	    
	    adminList = new JComboBox<>();
	    adminList.setMaximumRowCount(100);
	    adminList.setBounds(142, 200, 298, 32);
	    add(adminList);
	    
	    JLabel lblNewLabel_1 = new JLabel("Select the admin that you want to remove");
	    lblNewLabel_1.setFont(new Font("Optima", Font.PLAIN, 15));
	    lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setBounds(142, 156, 292, 32);
	    add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Confirm with the pin of admin");
	    lblNewLabel_2.setFont(new Font("Optima", Font.PLAIN, 15));
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_2.setBounds(142, 269, 292, 27);
	    add(lblNewLabel_2);
	    
	    textField = new JTextField();
	    textField.setBounds(142, 308, 292, 32);
	    textField.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(224, 224, 224), new Color(255, 255, 255), new Color(255, 255, 255), null));
	    textField.setColumns(50);
	    add(textField);
	    
	    confirmButton = new JButton("Confirm deletion");
	    confirmButton.setFont(new Font("Optima", Font.PLAIN, 13));
	    confirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
	    confirmButton.setOpaque(true);
	    confirmButton.setBackground(new Color(255, 255, 255));
	    confirmButton.setBounds(215, 367, 139, 32);
	    add(confirmButton);
	}
	
	public void addAdminList(List<String> adminList) {
		if(!adminList.isEmpty()) {
			for(String adminName : adminList) {
				this.adminList.addItem(adminName);
			}
		}
	}
	
	public String getSelectedItem() throws CustomException{
	    Object selectedItem = adminList.getSelectedItem();
	    
	    if (selectedItem instanceof String) {
	        return (String) selectedItem;
	    } 
	    throw new CustomException("Select an admin"); 		    
	}

	public String getPin() throws CustomException{
		return String.valueOf(textField.getText());		
	}

	public void addConfirmButtonAction(ActionListener action) {
		confirmButton.addActionListener(action);
	}
	
}
