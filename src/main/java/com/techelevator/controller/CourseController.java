package com.techelevator.controller;

import com.techelevator.model.dao.CurriculaDAO;
import com.techelevator.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.model.dto.Course;
import com.techelevator.model.dao.CourseDAO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    private CourseDAO courseDAO;

    private CurriculaDAO curriculaDAO;

    @Autowired
    public CourseController(CourseDAO courseDAO, CurriculaDAO curriculaDAO) {
        this.courseDAO = courseDAO;
        this.curriculaDAO = curriculaDAO;

    }

    @RequestMapping(path = "/CreateCourse", method = RequestMethod.GET)
    public String showCreateCourseForm(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("course")) {
            modelHolder.addAttribute("course", new Course());
            modelHolder.addAttribute("curricula", curriculaDAO.getAllCurricula());
        }
        return "Teacher/Course/CreateCourse";

    }

    @RequestMapping(path = "/CreateCourse", method = RequestMethod.POST)
    public String submitCourseForm(
            @Valid @ModelAttribute("createCourse") Course course,
            BindingResult result,
            RedirectAttributes flash,
            HttpSession session,
            int curriculaId
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createCourse", result);

            return "redirect:/CreateCourse";
        }
        User currentUser = (User) session.getAttribute("currentUser");
        flash.addFlashAttribute("message", "You have successfully registered the Course.");

        Course currentCourse = courseDAO.add(course.getName(), currentUser.getUserId(), course.getDescription(), course.getDifficultyLevel(), course.getCost());
        courseDAO.asignCurriculaToCourse(currentCourse.getId(), curriculaId );

        return "redirect:/teacherHomePage?courseName=" + course.getName();
    }

    @RequestMapping(path = "/allCourses", method = RequestMethod.GET)
    public String showAllCourses(ModelMap modelHolder, HttpSession session) {
        List<Course> courses = courseDAO.getAllCourse();
        modelHolder.addAttribute("courses", courses);

        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser.isTeacher()) {
            return "Teacher/Course/allCourses";
        } else
            return "Student/studentAllCourses";
    }


    @RequestMapping(path = "/courses/details/{courseId}", method = RequestMethod.GET)
    public String showCourseDetail(ModelMap modelMap, @PathVariable int courseId) {
        Course course = courseDAO.getById(courseId);
        modelMap.addAttribute("course", course);
        return "/common/course";
    }


    //edit GET
    @RequestMapping("course/edit/{courseId}")
    public String editCourseForm(@PathVariable Integer courseId, ModelMap map) {
        Course course = courseDAO.getById(courseId);
        map.put("course", course);
        return "Teacher/Course/editCourse";
    }

    //edit POST
    @RequestMapping(value = "course/edit/{courseId}", method = RequestMethod.POST)
    public String editCourseForm(@PathVariable Integer courseId, String updateCriteria, String newValue) {
        courseDAO.update(updateCriteria, newValue, courseId);
        return "redirect:/allCourses";
    }

    //edit GET
    @RequestMapping("/course/delete/{courseId}")
    public String deleteCourseForm(@PathVariable Integer courseId, ModelMap map) {
        Course course = courseDAO.getById(courseId);
        map.put("course", course);
        return "Teacher/Course/deleteCourse";
    }

    //edit POST
    @RequestMapping(value = "/course/delete/{courseId}", method = RequestMethod.POST)
    public String deleteCoursesForm(@PathVariable Integer courseId) {
        courseDAO.delete(courseId);
        return "redirect:/allCourses";
    }
    //dejo esto en comment para arreglarlo mañana
    @RequestMapping(path = "/courses/student/{studentId}", method = RequestMethod.GET)
    public String getEnrolledCourses(@PathVariable Integer studentId, HttpSession session, ModelMap map) {
        User currentUser = (User) session.getAttribute("currentUser");
        List<Course> allEnrolledCourse = courseDAO.findAllEnrolled(studentId);
        map.put("courses", allEnrolledCourse);
        return "/Student/enrolledCourses";
    }

    @RequestMapping(path = "/courses/teacher/{teacherId}", method = RequestMethod.GET)
    public String getAllMyCourses(@PathVariable Integer teacherId, HttpSession session, ModelMap map) {
        User currentUser = (User) session.getAttribute("currentUser");
        List<Course> findAllMyCourses = courseDAO.findAllMyCourses(teacherId);
        map.put("courses", findAllMyCourses);
        return "/Teacher/Course/myCourses";

    }

    //enroll GET
    @RequestMapping("/course/enroll/{courseId}")
    public String enroll(@PathVariable Integer courseId, ModelMap map, HttpSession session) {
        Course course = courseDAO.getById(courseId);
        User currentUser = (User) session.getAttribute("currentUser");
        map.put("course", course);
        return "Student/enrollToCourse";
    }

    //enroll POST
    @RequestMapping(value = "/course/enroll/{courseId}", method = RequestMethod.POST)
    public String enroll(@PathVariable Integer courseId, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        int studentId = currentUser.getUserId();

        courseDAO.enroll(courseId, studentId);
        return "redirect:/allCourses";
    }


}



