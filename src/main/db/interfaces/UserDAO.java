package main.db.interfaces;

import java.util.List;

import main.db.tables.AccountType;
import main.db.tables.User;
import main.java.customException.CustomException;

public interface UserDAO {
	public User getUser(String email) throws CustomException;
	public List<AccountType> getAccountTypesList();
}
