package main.java.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class AddPinPanel extends JPanel {
	JComboBox<String> accountTypeList;
	JTextField newPin;
	JButton confirmButton;
	
	public AddPinPanel() {
		accountTypeList = new JComboBox<>();
		setAccountTypeList();
		init();
	}
	
	private class AccountType {
		int pin_id;
		String typeName;
		
		public AccountType(int pin_id, String typeName) {
			this.pin_id = pin_id;
			this.typeName = typeName;
		}
		
		public int getPinId() { return pin_id; }
		public String getTypeName() { return typeName; }
	}
	
	public void init() {
		setBackground(new Color(255, 255, 255));
	    setBounds(151, 0, 633, 519);
	    setLayout(null);
	    setVisible(false);
		
		JLabel deleteAdminLabel = new JLabel("Add new pin");
	    deleteAdminLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    deleteAdminLabel.setFont(new Font("Optima", Font.ITALIC, 20));
	    deleteAdminLabel.setBounds(0, 0, 188, 39);
	    add(deleteAdminLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("<html>\n<body>\n\t<div style=\"text-align: center\"> Insert the pin for a future account and also select the type of it!\n</body></html>");
	    lblNewLabel_1.setFont(new Font("Optima", Font.PLAIN, 15));
	    lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setBounds(125, 117, 333, 39);
	    add(lblNewLabel_1);
	    
	    accountTypeList.setMaximumRowCount(100);
	    accountTypeList.setBounds(192, 251, 220, 33);
	    add(accountTypeList);
	    
	    newPin = new JTextField();
	    newPin.setBounds(192, 194, 220, 32);
	    newPin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(224, 224, 224), new Color(255, 255, 255), new Color(255, 255, 255), null));
	    newPin.setColumns(50);
	    add(newPin);
	    
	    confirmButton = new JButton("Add pin");
	    confirmButton.setFont(new Font("Optima", Font.PLAIN, 13));
	    confirmButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242), new Color(183, 254, 242)));
	    confirmButton.setOpaque(true);
	    confirmButton.setBackground(new Color(255, 255, 255));
	    confirmButton.setBounds(239, 330, 139, 32);
	    add(confirmButton);
	}
	
	private void setAccountTypeList() {
		accountTypeList.addItem(new AccountType(1, "Admin").getTypeName());
		accountTypeList.addItem(new AccountType(2, "Teacher").getTypeName());
		accountTypeList.addItem(new AccountType(3, "Student").getTypeName());
	}
	
	public int getSelectedItem() {
	    Object selectedItem = accountTypeList.getSelectedItem();
	    if (selectedItem == null || !(selectedItem instanceof String)) {
	    	throw new Error("No selection has been made");
	    } 
	    if(selectedItem.equals("Admin")) {
	    	return 1;
	    }
	    if(selectedItem.equals("Teacher")) {
	    	return 2;
	    }
	    return 3;
	}

	public String getPin() {
		return String.valueOf(newPin.getText());
	}
	
	public void addConfirmButtonAction(ActionListener action) {
		confirmButton.addActionListener(action);
	}

}
