package com.techelevator.controller;

import com.techelevator.model.teacher.RegistrationCurricula;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller

public class CurriculaController {

    @RequestMapping(path="/CreateCurricula", method= RequestMethod.GET)
    public String showCreateCourseForm (ModelMap modelHolder){
        if( ! modelHolder.containsAttribute("registrationCurricula")) {
            modelHolder.addAttribute("registrationCurricula", new RegistrationCurricula());
        }
        return "Teacher/CreateCurricula";

    }


    @RequestMapping(path="/CreateCurricula", method= RequestMethod.POST)
    public String submitRegistrationForm(
            @Valid @ModelAttribute("Registration Curricula") RegistrationCurricula registrationValues,
            BindingResult result,
            RedirectAttributes flash
    ){
        if(result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Registration", result);

            return "redirect:/CreateCurricula";
        }

        flash.addFlashAttribute("message", "You have successfully registered the Course.");

        return "redirect:/CourseConfirmation";
    }

    @RequestMapping(path = "/CreateCurricula/CurriculaConfirmation", method = RequestMethod.GET)
    public String createCurriculaConfirmation() {
        return "/Teacher/CurriculaConfirmation";
    }
}

