package com.techelevator.model.dto;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private int userId;
	private String userName;
	
	@Size(min=8, message="Password too short, must be at least 8")
	@Pattern.List({
		@Pattern(regexp=".*[a-z].*", message="Must have a lower case"),
		@Pattern(regexp=".*[A-Z].*", message="Must have a capital")
	})
	private String password;
	private String role;
	private boolean isTeacher;
	private boolean isStudent;
	private String firstName;
	private String lastName;

	private String fullName ;

	private Email email;

	private int age;

	private String confirmPassword;
	

	public static boolean hasError() {
		return false;
	}

	public String getUserName() {
		return userName;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isTeacher() {
		return isTeacher;
	}

	public void setTeacher(boolean teacher) {
		isTeacher = teacher;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean student) {
		isStudent = student;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String firstName, String lastName) {


		this.fullName = lastName+", "+ firstName;
	}

	public void setAttribute(String user, User currentUser) {
	}

	public Object getUserAge() {

		return age;
	}

	public Email getUserMail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
