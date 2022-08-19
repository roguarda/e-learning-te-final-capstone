package com.techelevator.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.model.dto.Curricula;
import com.techelevator.model.dao.CurriculaDAO;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CurriculaController {


    private CurriculaDAO curriculaDAO;

    @Autowired
    public CurriculaController(CurriculaDAO curriculaDAO) {
        this.curriculaDAO = curriculaDAO;
    }

    @RequestMapping(path="/Curricula", method= RequestMethod.GET)
    public String displayAllCurricula(ModelMap modelMap){
            List<Curricula> curricula = curriculaDAO.getAllCurricula();
                    modelMap.put("curricula", curricula);
            return "Teacher/allCurricula";

    }

    @RequestMapping(path="/CreateCurricula", method= RequestMethod.GET)
    public String showCreateCurriculaForm (ModelMap modelHolder){
        if( ! modelHolder.containsAttribute("curricula")) {
            modelHolder.addAttribute("curricula", new Curricula());
        }
        return "Teacher/CreateCurricula";

    }


    @RequestMapping(path="/CreateCurricula", method= RequestMethod.POST)
    public String submitCurriculaForm(
            @Valid @ModelAttribute("createCurricula") Curricula curricula,
            BindingResult result,
            RedirectAttributes flash
    ){
        if(result.hasErrors()) {
            flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "createCurricula", result);

            return "redirect:/CreateCurricula";
        }

        flash.addFlashAttribute("message", "You have successfully created the curricula.");
        curriculaDAO.add(curricula.getCurriculaName(), curricula.getDailyInstruction(), curricula.getDailyHomework() );
        return "redirect:/teacherHomePage?curriculaName="+curricula.getCurriculaName();
    }

    @RequestMapping(path = "/curricula/delete/{curriculaId}", method = RequestMethod.GET)
    public String deleteCurricula() {
        //continuar este codigo, lo deje a la mitad para fixear el tema del mail que no compila
        return "/Teacher/CurriculaConfirmation";
    }
}

