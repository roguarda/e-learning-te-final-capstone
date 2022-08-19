package com.techelevator.controller;

import javax.validation.Valid;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

/*//	@RequestMapping(path="/studentHomePage/Profile", method=RequestMethod.GET)
//	public String getStudentProfileAndEdit(@Valid @ModelAttribute User user, @RequestParam String name, @RequestParam int age, @RequestParam Email mail ) {
//		if (User.hasError()) {
//			return "redirect:/studentHomePage/Profile";
//		}


//		User currentUser = (User) userDAO.getAttribute("currentUser");
//		user.setAttribute("user", currentUser);
//
//		userDAO.updateName(currentUser.getUserName(), name);
//		userDAO.updateAge(currentUser.getUserAge(), age);
//		userDAO.updateMail(currentUser.getUserMail(), mail);
//
//		return "redirect:/studentHomePage";}*/

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





}
