package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.repository.LaKvitteringRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class LaKvitteringController {

    @Autowired
    LaKvitteringRepo laKvitteringRepo;

    //estera
    @GetMapping("/getAllKvitteringer")
    public String getAll(Model model){
        model.addAttribute("laKvitteringer", laKvitteringRepo.getAll());
        System.out.println(laKvitteringRepo.getAll());
        return "oversigtPage";
    }

    //estera
    @GetMapping("/getLaKvitteringById")
    public String getById(@RequestParam("id") int id ,Model model){
        model.addAttribute("laKvittering", laKvitteringRepo.getById(id));
        System.out.println(laKvitteringRepo.getById(id));
        return "oversigtPage";
    }

    @GetMapping("/createLaKvittering")
    public String createLaKvittering (
            @RequestParam("skadeMatrixId") int skadeMatrix, Model model){
        return "oversigtPage";
    }
}
