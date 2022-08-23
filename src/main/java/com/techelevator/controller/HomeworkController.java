package com.techelevator.controller;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeworkController {

    private HomeworkDAO homeworkDAO;

    @RequestMapping(path="/MyHomework", method=RequestMethod.GET)
    public String showCreateHomeworkForm(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("homework")) {
            modelHolder.addAttribute("homework", new Homework());
        }
        return "Student/MyHomework";

    }

    @RequestMapping(path = "/MyHomework", method = RequestMethod.POST)
    public String submitHomeworkForm(
            @Valid @ModelAttribute("createHomework") Homework homework,
            BindingResult result,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createHomework", result);

            return "redirect:/MyHomework";
        }

        flash.addFlashAttribute("message", "You have successfully created the homework.");
        homeworkDAO.add(homework.getHomeworkName(), homework.getHomeworkIntroduction(), homework.getHomeworkDescription());
        return "redirect:/studentHomePage/" + homework.getHomeworkName();
    }
}
