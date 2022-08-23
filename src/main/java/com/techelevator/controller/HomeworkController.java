package com.techelevator.controller;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Course;
import com.techelevator.model.dto.Homework;
import com.techelevator.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeworkController {

    private HomeworkDAO homeworkDAO;

    @RequestMapping(path="/FeedbackHomework", method=RequestMethod.GET)
    public String showCreateHomeworkFeedback(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("feedbackHomework")) {
            modelHolder.addAttribute("feedbackHomework", new Homework());
        }
        return "Teacher/Homework/ViewHomework";

    }

    @RequestMapping(path = "/FeedbackHomework", method = RequestMethod.POST)
    public String submitHomeworkFeedbackForm(
            @Valid @ModelAttribute("homeworkFeedback") Homework homework,
            BindingResult result,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createHomeworkFeedback", result);

            return "redirect:/FeedbackHomework";
        }

        flash.addFlashAttribute("message", "You have successfully created the homework.");
        //cambiar metodo x el de jdbc dao que corrige el profe
        homeworkDAO.add(homework.getTeacherFeedback() , homework.getHomeworkGrade(), homework.getStatus());
        return "redirect:/teacherHomePage/" + homework.getTeacherFeedback();
    }

    @RequestMapping(path = "/viewHomewors", method = RequestMethod.GET)
    public String showAllHomeworksToReview(ModelMap modelHolder, HttpSession session) {
        List<Homework> homeworks = homeworkDAO.getAllHomework();
        modelHolder.addAttribute("homeworks", homeworks);

        User currentUser = (User) session.getAttribute("currentUser");
        return "Teacher/Course/allCourses";

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

    @RequestMapping(path = "/viewHomeworks", method = RequestMethod.GET)
    public String showAllHomeworks(ModelMap modelHolder, HttpSession session) {
        List<Homework> homeworks = homeworkDAO.getAllHomework();
        modelHolder.addAttribute("homeworks", homeworks);

        User currentUser = (User) session.getAttribute("currentUser");
            return "Teacher/Course/allCourses";

    }


}
