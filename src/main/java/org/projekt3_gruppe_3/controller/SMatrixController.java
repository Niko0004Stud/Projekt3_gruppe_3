package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.repository.SMatrixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

//estera
@Controller
public class SMatrixController {

    @Autowired
    SMatrixRepo skadeRepo;

    @GetMapping("/getAllSkader")
    public String getAll(Model model){
        model.addAttribute("skade", skadeRepo.getAll());
        System.out.println(skadeRepo.getAll());
        return "redirect:/userpage";
    }

    @PostMapping("opretSkadeMatrix")
    public String cCreateSkadeMatrix(
            @RequestParam("bilId") int bilId,
            @RequestParam("omkostninger") double omkostninger,
            @RequestParam("registreringsDate")LocalDate registreringsDate){

        return " ";
    }
}
