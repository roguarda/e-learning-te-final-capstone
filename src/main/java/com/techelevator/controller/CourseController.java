package com.techelevator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.model.dto.Course;
import com.techelevator.model.dao.CourseDAO;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
        return "Teacher/Course/CreateCourse";

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
        courseDAO.add(course.getName(), course.getTeacherId(), course.getDescription(), course.getDifficultyLevel(), course.getCost());
//        return "redirect:/CourseConfirmation";
        return "redirect:/teacherHomePage/courseName=" + course.getName();
    }

    @RequestMapping(path = "/allCourses", method = RequestMethod.GET)
    public String showAllCourses(ModelMap modelHolder) {


        List<Course> courses = courseDAO.getAllCourse();
        modelHolder.addAttribute("courses", courses);
        return "Teacher/Course/allCourses";

    }

    @RequestMapping(path = "/courses/detail/{courseId}", method = RequestMethod.GET)
    public String showCourseDetail( ModelMap modelMap, @PathVariable int courseId) {
        Course course = courseDAO.getById(courseId);
        modelMap.addAttribute("course", course);

        return "/common/course";
    }
}
 /*   @RequestMapping(path = "/courses/student", method = RequestMethod.GET)
    public List<Course> getEnrolledCourses() {
        long studentId = userDao.findIdByUsername(principal.getName());
        return courseDao.findAllEnrolled(studentId);
    }*/


