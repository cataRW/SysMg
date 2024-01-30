package main.db.tables;

public class Admin {
	private int idAdmin;
	private String firstName;
	private String lastName;
	private String adminEmail;
	private Long pin;
	/**
	 * @return the idAdmin
	 */
	public int getIdAdmin() {
		return idAdmin;
	}
	/**
	 * @param idAdmin the idAdmin to set
	 */
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the adminEmail
	 */
	public String getAdminEmail() {
		return adminEmail;
	}
	/**
	 * @param adminEmail the adminEmail to set
	 */
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	/**
	 * @return the pin
	 */
	public Long getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(Long pin) {
		this.pin = pin;
	}
	
}
