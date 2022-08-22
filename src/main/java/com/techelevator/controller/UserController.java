package com.techelevator.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

	@RequestMapping(value = "/edit/{userName}", method = RequestMethod.GET)
	public String edit(@PathVariable int userId, ModelMap map) {
		User user = userDAO.getUserById(userId);

		map.put("user", user);

		return "profile/edit";
	}

	@RequestMapping(value = "/edit/{userName}", method = RequestMethod.POST)
	public String edit(@PathVariable String userName, @ModelAttribute User user) {
		userDAO.update(userName, user);

		return "/profile";
	}




	@RequestMapping(path = "/teacherHomePage", method = RequestMethod.GET)
	public String getTeacherHomePage() {
		return "Teacher/teacherHomePage";
	}


	@RequestMapping(path = "/Registration/newUserConfirmation", method = RequestMethod.GET)
	public String newUserConfirmation() {
		return "/Registration/newUserConfirmation";
	}


	@RequestMapping(path="/users/new", method=RequestMethod.GET)
	public String displayNewUserForm(ModelMap modelHolder) {
		if( ! modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "Registration/newUser";
	}
	
	@RequestMapping(path="/users", method=RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute User user, BindingResult result, RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("user", user);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/users/new";
		}
		
		userDAO.saveUser(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getRole());
		return "redirect:/Registration/newUserConfirmation" ;
	}


}
