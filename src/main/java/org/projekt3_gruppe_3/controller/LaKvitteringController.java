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

    @GetMapping("/showAlleLaKvitteringer")
    public String showAlleLaKvitteringer(@RequestParam("id") int id ,Model model){
        model.addAttribute("laKvitteringer", laKvitteringRepo.readAlleLaKvitteringer());
        System.out.println(laKvitteringRepo.readAlleLaKvitteringer());
        return "showAlleLaKvitteringer";
    }

    @GetMapping("/showLaKvittering")
    public String showLaKvittering(@RequestParam("id") int id ,Model model){
        model.addAttribute("LaKvittering", laKvitteringRepo.readById(id));
        System.out.println(laKvitteringRepo.readById(id));
        return "showLaKvittering";
    }

}
