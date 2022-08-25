package com.techelevator.controller;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Homework;
import com.techelevator.model.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeworkController {

    private HomeworkDAO homeworkDAO;

    @RequestMapping(path = "/gradeHomework/{homeworkId}", method = RequestMethod.GET)
    public String gradeHomework(@PathVariable Integer homeworkId, ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("feedbackHomework")) {
            modelHolder.addAttribute("feedbackHomework", new Homework());
        }
        return "Teacher/Homework/gradeHomework";

    }

    @RequestMapping(path = "/gradeHomework/{homeworkId}", method = RequestMethod.POST)
    public String gradeHomework(@PathVariable Integer homeworkId, @Valid @ModelAttribute("homeworkFeedback") Homework homework,
                                BindingResult result,
                                RedirectAttributes flash) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createHomeworkFeedback", result);

            return "redirect:/viewHomework";
        }

        flash.addFlashAttribute("message", "You have successfully created the homework.");
        //cambiar metodo x el de jdbc dao que corrige el profe
        homeworkDAO.gradeHomework(homework.getHomeworkGrade(), homework.getTeacherFeedback(), homework.getStatus(), homeworkId);
        return "redirect:/teacherHomePage/";
    }


    //Crear en JDBC un metodo para ver todas las tareas que envian los alumnos
    @RequestMapping(path = "/viewHomework", method = RequestMethod.GET)
    public String showAllHomeworksToReview(ModelMap modelHolder, HttpSession session) {

        User currentUser = (User) session.getAttribute("currentUser");
        List<Homework> homeworks = homeworkDAO.getHomeworkListByStatusAndTeacherId(currentUser.getUserId());
        modelHolder.addAttribute("homeworks", homeworks);
        return "Teacher/Homework/viewHomework";

    }

    @RequestMapping(path = "/MyHomework/{id}", method = RequestMethod.GET)
    public String submitHomeworkForm(@PathVariable Integer id, ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("homework")) {
            modelHolder.addAttribute("homework", new Homework());
        }
        return "Student/MyHomework";
    }

    @RequestMapping(path = "/MyHomework/{id}", method = RequestMethod.POST)
    public String submitHomeworkForm(@PathVariable Integer id, @Valid @ModelAttribute("createHomework") Homework homework,
                                     BindingResult result,
                                     RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createHomework", result);

            return "redirect:/MyHomework/{id}";
        }

        flash.addFlashAttribute("message", "You have successfully created the homework.");
        homeworkDAO.submitHomework( homework.getHomeworkIntroduction(), homework.getHomeworkDescription(), id);
        return "redirect:/viewHomeworks";

        //+ homework.getHomeworkName();
    }

    //Falta agregar metodo en JDBC
    @RequestMapping(path = "/viewHomeworks", method = RequestMethod.GET)
    public String showAllHomeworks(ModelMap modelHolder, HttpSession session) {
        List<Homework> homeworks = homeworkDAO.getAllHomework();
        modelHolder.addAttribute("homeworks", homeworks);

        User currentUser = (User) session.getAttribute("currentUser");
        return "Teacher/Course/allCourses";

    }

}
