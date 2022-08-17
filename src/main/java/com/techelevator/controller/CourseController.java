package com.techelevator.controller;

import com.techelevator.model.dao.CourseDAO;
import com.techelevator.model.dao.jdbc.JDBCCourseDAO;
import com.techelevator.model.dto.Course;
import com.techelevator.model.teacher.RegistrationCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller

public class CourseController {
    @Autowired
    private CourseDAO courseDAO ;

    @RequestMapping(path="/CreateCourse", method=RequestMethod.GET)
    public String showCreateCourseForm (ModelMap modelHolder){
        if( ! modelHolder.containsAttribute("registrationCourse")) {
            modelHolder.addAttribute("registrationCourse", new RegistrationCourse());
        }
        return "Teacher/CreateCourse";

    }


    @RequestMapping(path="/CreateCourse", method= RequestMethod.POST)
    public String submitRegistrationForm(
            @Valid @ModelAttribute("Registration Course") RegistrationCourse registrationValues,
            BindingResult result,
            RedirectAttributes flash
    ){
        if(result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);

            return "redirect:/CreateCourse";
        }

        flash.addFlashAttribute("message", "You have successfully registered the Course.");

        return "redirect:/CourseConfirmation";
    }

    @RequestMapping(path = "/allCourses", method = RequestMethod.GET)
    public String showAllCourses(ModelMap modelHolder) {


        List<Course> courses = courseDAO.getAllCourse();
        modelHolder.addAttribute("courses", courses);
        return "Teacher/allCourses";

    }
}

