package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.model.Skade;
import org.projekt3_gruppe_3.repository.SkadeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//estera
@Controller
public class SkadeController {

    @Autowired
    SkadeRepo skadeRepo;

    @GetMapping("/getAllSkader")
    public String getAll(Model model){
        model.addAttribute("skade", skadeRepo.getAll());
        System.out.println(skadeRepo.getAll());
        return "redirect:/userpage";
    }
}
