package com.techelevator.controller;

import com.techelevator.model.dao.HomeworkDAO;
import com.techelevator.model.dto.Course;
import com.techelevator.model.dto.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.model.dto.Curricula;
import com.techelevator.model.dao.CurriculaDAO;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CurriculaController {


    private CurriculaDAO curriculaDAO;
    private HomeworkDAO homeworkDAO;

    @Autowired
    public CurriculaController(CurriculaDAO curriculaDAO, HomeworkDAO homeworkDAO) {
        this.curriculaDAO = curriculaDAO;
        this.homeworkDAO = homeworkDAO;
    }

    @RequestMapping(path = "/Curricula", method = RequestMethod.GET)
    public String displayAllCurricula(ModelMap modelMap) {
        List<Curricula> curricula = curriculaDAO.getAllCurricula();
        modelMap.put("curricula", curricula);
        return "Teacher/Curricula/allCurricula";

    }

    @RequestMapping(path = "/CreateCurricula", method = RequestMethod.GET)
    public String showCreateCurriculaForm(ModelMap modelHolder) {
        if (!modelHolder.containsAttribute("curricula")) {
            modelHolder.addAttribute("curricula", new Curricula());
        }
        return "Teacher/Curricula/CreateCurricula";

    }


    @RequestMapping(path = "/CreateCurricula", method = RequestMethod.POST)
    public String submitCurriculaForm(
            @Valid @ModelAttribute("createCurricula") Curricula curricula,
            BindingResult result,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createCurricula", result);

            return "redirect:/CreateCurricula";
        }

        flash.addFlashAttribute("message", "You have successfully created the curricula.");
        curriculaDAO.add(curricula.getCurriculaName(), curricula.getDailyInstruction(), curricula.getDailyHomework());
        homeworkDAO.createHomework(curricula.getCurriculaName(), curricula.getDailyHomework());
        return "redirect:/teacherHomePage?curriculaName=" + curricula.getCurriculaName();
    }

        //edit GET
    @RequestMapping("curricula/edit/{curriculaId}")
    public String editCurriculaForm(@PathVariable Integer curriculaId, ModelMap map)
    {  Curricula curricula = curriculaDAO.getById(curriculaId);
        map.put("curricula", curricula);
        return "Teacher/Curricula/editCurricula";
    }

    //edit POST
    @RequestMapping(value = "curricula/edit/{curriculaId}", method = RequestMethod.POST)
    public String editCurriculaForm(@PathVariable Integer curriculaId, String updateCriteria, String newValue)
    {
        curriculaDAO.update(updateCriteria, newValue, curriculaId);

        return "redirect:/Curricula";
    }

    //edit GET
    @RequestMapping("/deleteCurricula/{curriculaId}")
    public String deleteCurriculaForm(@PathVariable Integer curriculaId, ModelMap map) {
        Curricula curricula = curriculaDAO.getById(curriculaId);
        map.put("curricula", curricula);
        return "Teacher/Curricula/deleteCurricula";
    }

    //edit POST
    @RequestMapping(value = "/deleteCurricula/{curriculaId}", method = RequestMethod.POST)
    public String deleteCurriculaForm(@PathVariable Integer curriculaId)
    {
        curriculaDAO.delete(curriculaId);
        return "redirect:/Curricula";
    }
    @RequestMapping(path = "/curricula/details/{curriculaId}", method = RequestMethod.GET)
    public String showCurriculaDetail(ModelMap modelMap, @PathVariable int curriculaId) {
        Curricula curricula = curriculaDAO.getById(curriculaId);
        modelMap.addAttribute("curricula", curricula);
        return "/common/curriculaDetails";
    }
}

