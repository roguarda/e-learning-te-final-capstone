package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.model.dto.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getHomePage() {
		return "common/homePage";
	}
	@RequestMapping(path="/studentHomePage", method=RequestMethod.GET)
	public String getStudentHomePage() {
		return "Student/studentHomePage";
	}

	@RequestMapping(path="/teacherHomePage", method=RequestMethod.GET)
	public String getTeacherHomePage() {
		return "Teacher/teacherHomePage";
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

	@RequestMapping(path = "/Registration/newUserConfirmation", method = RequestMethod.GET)
	public String newUserConfirmation() {
		return "/Registration/newUserConfirmation";
	}



//	@RequestMapping(path="users/login", method=RequestMethod.GET)
//	public String getLoginForm(ModelMap modelMap) {
//		modelMap.put("login", new Login());
//		return "Login/login";
//	}
//
//	@RequestMapping(path="users/login", method=RequestMethod.POST)
//	public String login(@Valid Login login
//			, BindingResult result) {
//
//		if (result.hasErrors()) {
//			return "/login/login";
//		}
//
//		return "redirect:/login/loginConfirmation";
//
//	}





}
