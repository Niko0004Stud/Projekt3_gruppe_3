package org.projekt3_gruppe_3.controller;


import org.projekt3_gruppe_3.repository.FhaKvitteringRepo;
import org.projekt3_gruppe_3.repository.ForhaandsaftaleRepo;
import org.projekt3_gruppe_3.repository.LaKvitteringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FhaKvitteringController {

    @Autowired
    FhaKvitteringRepo fhaKvitteringRepo;

    //Natasha
    @GetMapping("/getAllFhaKvitteringer")
    public String getAll(Model model){
        model.addAttribute("fhaKvitteringer", fhaKvitteringRepo.getAll());
        System.out.println(fhaKvitteringRepo.getAll());
        return "oversigtPage";
    }

    //Natasha
    @GetMapping("/getFhaKvitteringById")
    public String getById(@RequestParam("id") int id , Model model){
        model.addAttribute("FhaKvittering", fhaKvitteringRepo.getbyId(id));
        System.out.println(fhaKvitteringRepo.getbyId(id));
        return "oversigtPage";
    }

}
