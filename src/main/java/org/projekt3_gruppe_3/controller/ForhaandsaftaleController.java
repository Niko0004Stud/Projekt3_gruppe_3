package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.Forhaandsaftale;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.repository.ForhaandsaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
//Natasha
public class ForhaandsaftaleController {
    @Autowired
    private ForhaandsaftaleRepo forhaandsaftaleRepo;

    @GetMapping("/forhaandsaftaler")
    public String visForhaandsaftaler(@RequestParam("oversigtPageType") String oversigtPageType, HttpSession session, Model modelPType, Model model) {
        session.getAttribute("user");
        modelPType.addAttribute("oversigtPageType", oversigtPageType);
        model.addAttribute("forhaandsaftaler", forhaandsaftaleRepo.getAll());
        return "oversigtPage";
    }
    //Natasha
    @PostMapping("/opretForhaandsaftale")
    public String opretForhaandsaftale(@RequestParam("bilId") int bilId,
                                       @RequestParam("kundeId") int kundeId,
                                       @RequestParam("fhaKvitteringId") int fhaKvitteringId,
                                       @RequestParam("regDate") LocalDate RegDate,
                                       @RequestParam("startPrisKr") double StartPrisKr, Model model) {

        Forhaandsaftale forhaandsaftale = new Forhaandsaftale(bilId, kundeId, fhaKvitteringId, RegDate, StartPrisKr);
        try {
            forhaandsaftaleRepo.create(forhaandsaftale);
            return "redirect:/getUserPageData";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/forhaandsaftaler";


        }
    }
}
