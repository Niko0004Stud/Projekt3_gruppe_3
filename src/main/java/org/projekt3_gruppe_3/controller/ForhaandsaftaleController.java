package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.model.Forhaandsaftale;
import org.projekt3_gruppe_3.repository.ForhaandsaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ForhaandsaftaleController {
    @Autowired
    private ForhaandsaftaleRepo forhaandsaftaleRepo;

    @GetMapping("/forhaandsaftaler")
    public String visForhaandsaftaler(Model model){
        model.addAttribute("forhaandsaftaler",forhaandsaftaleRepo.readAllForhaandsaftaler());
        model.addAttribute("forhaandsaftale", new Forhaandsaftale());
        return "forhaandsaftaler";
    }
    @PostMapping("/opretForhaandsaftale")
    public String opretForhaandsaftale(Forhaandsaftale forhaandsaftale){
        forhaandsaftaleRepo.createForhaandsaftale(forhaandsaftale);

        return "redirect:/forhaandsaftaler";
    }
}
