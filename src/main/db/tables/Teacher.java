package main.db.tables;

public class Teacher {
	private int idTeacher;
	private String firstName;
	private String lastName;
	private String emailTeacher;
	private Long pin;
	
	/**
	 * @return the idTeacher
	 */
	public int getIdTeacher() {
		return idTeacher;
	}
	/**
	 * @param idTeacher the idTeacher to set
	 */
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
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
	 * @return the emailTeacher
	 */
	public String getEmailTeacher() {
		return emailTeacher;
	}
	/**
	 * @param emailTeacher the emailTeacher to set
	 */
	public void setEmailTeacher(String emailTeacher) {
		this.emailTeacher = emailTeacher;
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
