package com.techelevator.model.dao;

import org.hibernate.validator.constraints.Email;

public interface UserDAO {

	public void saveUser(String userName, Email email, String password, String firstName, String lastName, String role);

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	public Object getUserByUserName(String userName);

	Object getAttribute(String currentUser);

	void updateName(String userName, String name);

	void updateAge(Object userAge, int age);

	void updateMail(Email userMail, Email mail);
}
