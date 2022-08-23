package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Curricula;
import com.techelevator.model.dto.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.dto.User;
import com.techelevator.model.dao.UserDAO;

@Controller
public class UserController {

	private UserDAO userDAO;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "common/homePage";
	}

	@RequestMapping(path = "/studentHomePage", method = RequestMethod.GET)
	public String getStudentHomePage() {
		return "Student/studentHomePage";
	}


	@RequestMapping("/studentHomePage/profile")
	public String details(HttpSession session, ModelMap map) {

		User user = (User) session.getAttribute("currentUser");
		map.put("user", user);

		return "/Student/studentProfile";
	}

	@RequestMapping(value = "Profile/edit/{userName}")
	public String editProfile(@PathVariable String userName, ModelMap map) {
		User user = userDAO.getUserByUserName(userName);

		map.put("user", user);

		return "/Student/Edit";
	}

	@RequestMapping(value = "Profile/edit/{userName}", method = RequestMethod.POST)
	public String editProfileForm(@PathVariable String userName, String updateUser, String newValue) {
		userDAO.update(updateUser, newValue, userName);

		return "redirect:/studentHomePage/profile";
	}


	@RequestMapping(path = "/teacherHomePage", method = RequestMethod.GET)
	public String getTeacherHomePage() {
		return "Teacher/teacherHomePage";
	}


	@RequestMapping(path = "/Registration/newUserConfirmation", method = RequestMethod.GET)
	public String newUserConfirmation() {
		return "/Registration/newUserConfirmation";
	}


	@RequestMapping(path = "/users/new", method = RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if (!modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "Registration/newUser";
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/users/new";
		}

		userDAO.saveUser(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getRole());
		return "redirect:/Registration/newUserConfirmation";
	}

}





