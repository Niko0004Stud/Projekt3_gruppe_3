package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.projekt3_gruppe_3.service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class LejeaftaleController {

    @Autowired
    LejeaftaleRepo lejeaftaleRepo;

    @Autowired
    LejeaftaleService lejeaftaleService;

    @GetMapping("/showAllLejeaftaler")
    public String showAllLejeaftaler(){
        System.out.println("Du kon ind i showaalllejeaftaler af");
        System.out.println(lejeaftaleRepo.readAllLejeaftaler());

        return"/";
    }

    @PostMapping("/lejeaftale/create")
    public String createLejeaftale(
            @RequestParam("bilId") int bilId,
            @RequestParam("kundeId") int kundeId,
            @RequestParam("skadeMatrixId") int skadeMatrix,
            @RequestParam("startDato") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDato,
            @RequestParam("laengdeDays") int laengdeDays,
            @RequestParam("slutDato") @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate slutDato,
            @RequestParam("prisKr") double prisKr,
            Model model) {

      try{
        lejeaftaleService.createLejeaftale(bilId, kundeId, skadeMatrix,
                startDato, laengdeDays, slutDato, prisKr
        );
        return "redirect:/lejeaftale/list";
      }catch (IllegalArgumentException e){
          model.addAttribute("error", e.getMessage());
          return "LejeaftaleForm";}
    }
}
