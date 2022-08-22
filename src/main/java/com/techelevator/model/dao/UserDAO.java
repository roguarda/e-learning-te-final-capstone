package com.techelevator.model.dao;

import com.techelevator.model.dto.User;
import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Profile;

public interface UserDAO {

	public void saveUser(String userName, String password, String firstName, String lastName, String role);


	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	User getUserByUserName(String userName);


	User getUserById(int userId);

	void saveUser(String userName, Email email, String password, String firstName, String lastName, String role);


	Object getAttribute(String currentUser);

	void updateName(String userName, String name);

	void updateAge(Object userAge, int age);

	void updateMail(Email userMail, Email mail);

	Profile getProfile();


	void update(String updateUser, String newValue, String userName);
}
