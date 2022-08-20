package com.techelevator.controller;

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

    @Autowired
    public CurriculaController(CurriculaDAO curriculaDAO) {
        this.curriculaDAO = curriculaDAO;
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
        return "redirect:/teacherHomePage?curriculaName=" + curricula.getCurriculaName();
    }

    @RequestMapping(path = "/Curricula/edit/{curriculaId}", method = RequestMethod.GET)
    public String editCurriculaForm(ModelMap modelMap, int curriculaId) {
        Curricula curricula = curriculaDAO.getById(curriculaId);
        modelMap.put("curricula", curricula);
        return "Teacher/Curricula/editCurricula";

    }

    @RequestMapping(path = "/Curricula/edit/{curriculaId}", method = RequestMethod.POST)
    public String editCurriculaForm(
            @Valid @ModelAttribute("editCurricula") Curricula curricula,
            BindingResult result,
            RedirectAttributes flash
    ) {
        if (result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "editCurricula", result);
            return "redirect:/Teacher/Curricula/editCurricula";
        }
        flash.addFlashAttribute("message", "You have successfully edited the curricula.");
//        curriculaDAO.update(flash.);
        return "redirect:/Curricula?curriculaName=" + curricula.getCurriculaName();
    }


    //    //edit GET
//    @RequestMapping("/edit/{id}")
//    public String editForm(@PathVariable Integer id, ModelMap map)
//    {
//        Genre genre = genreDao.getById(id);
//
//        map.put("genre", genre);
//
//        return "genres/edit";
//    }
//
//    //edit POST
//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
//    public String editSubmit(@PathVariable Integer id, @ModelAttribute Genre genre)
//    {
//        genreDao.update(id, genre);
//
//        return "redirect:/genres";
//    }
//
//


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
}

