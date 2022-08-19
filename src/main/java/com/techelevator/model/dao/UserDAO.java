package com.techelevator.model.dao;

import com.techelevator.model.dto.User;
import org.hibernate.validator.constraints.Email;
import org.springframework.context.annotation.Profile;

public interface UserDAO {
	User getUserById (int userId);

	public void saveUser(String userName, String password, String firstName, String lastName, String role);
<<<<<<< HEAD

	public void saveUser(String userName, String password, String firstName, String lastName, String role);

<<<<<<< HEAD
=======
	public void saveUser(String userName, String password, String firstName, String lastName, String role);
>>>>>>> main
=======
>>>>>>> main

	public boolean searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	User getUserByUserName(String userName);

	Object getUserById(int userId);

	Object getUserById(int userId);

	Object getUserById(int userId);

	Object getAttribute(String currentUser);

	void updateName(String userName, String name);

	void updateAge(Object userAge, int age);

	void updateMail(Email userMail, Email mail);

	Profile getProfile();

	void update(String userName, User user);
}
