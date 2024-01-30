package main.db.tables;

public class User {
	String email;
	long pin;
	AccountType accountType;
	String firstName;
	String lastName;
	int id;
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
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pin
	 */
	public long getPin() {
		return pin;
	}
	/**
	 * @param pin the pin to set
	 */
	public void setPin(long pin) {
		this.pin = pin;
	}
	
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public AccountType getAccountType() {
		return this.accountType;
	}
}
