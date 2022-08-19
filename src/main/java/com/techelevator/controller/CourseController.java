package com.techelevator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.model.dto.Course;
import com.techelevator.model.dao.CourseDAO;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Controller
public class CourseController {
    private CourseDAO courseDAO;
    @Autowired
    public CourseController(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @RequestMapping(path = "/CreateCourse", method = RequestMethod.GET)
    public String showCreateCourseForm(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("course")) {
            modelHolder.addAttribute("course", new Course());
        }
        return "Teacher/CreateCourse";

    }

    @RequestMapping(path = "/CreateCourse", method = RequestMethod.POST)
    public String submitCourseForm(
            @Valid @ModelAttribute("createCourse") Course course,
            BindingResult result,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createCourse", result);

            return "redirect:/CreateCourse";
        }

        flash.addFlashAttribute("message", "You have successfully registered the Course.");
        courseDAO.add(course.getName(), course.getTeacherId(),course.getDescription(), course.getDifficultyLevel(), course.getCost());
//        return "redirect:/CourseConfirmation";
        return "redirect:/teacherHomePage/courseName="+course.getName();
    }

    @RequestMapping(path = "/allCourses", method = RequestMethod.GET)
    public String showAllCourses(ModelMap modelHolder) {


        List<Course> courses = courseDAO.getAllCourse();
        modelHolder.addAttribute("courses", courses);
        return "Teacher/allCourses";

    }
    @RequestMapping(path = "/eachCourse", method = RequestMethod.GET)
    public String showEachCourse(ModelMap modelHolder) {
        return "/Course";
    }
    }


