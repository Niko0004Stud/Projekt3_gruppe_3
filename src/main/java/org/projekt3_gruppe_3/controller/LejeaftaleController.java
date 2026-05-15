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

@Controller
public class LejeaftaleController {

    @Autowired
    LejeaftaleRepo lejeaftaleRepo;

    @Autowired
    LejeaftaleService lejeaftaleService;

    //estera & sebastian
    @GetMapping("/showAllLejeaftaler")
    public String showAllLejeaftaler(){
        System.out.println(lejeaftaleRepo.getAll());

        return"redirect:/";
    }

    //estera & sebastian
    @PostMapping("opretLejeaftale")
    public String createLejeaftale(
            @RequestParam("bilId") int bilId,
            @RequestParam("kundeId") int kundeId,
            @RequestParam(value = "laKvitteringId", required = false) int laKvitteringId,
            @RequestParam("startDate") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate startDate,
            @RequestParam("slutDate") @DateTimeFormat(pattern = "dd-mm-yyyy")LocalDate slutDate,
            @RequestParam("startPrisKr") double startPrisKr,
            Model model) {

      try{
        lejeaftaleService.createLejeaftale(bilId, kundeId, laKvitteringId,
                startDate, slutDate, startPrisKr
        );
        return "redirect:/userpage";
      }catch (IllegalArgumentException e){
          model.addAttribute("error", e.getMessage());
          return "LejeaftaleForm";}
    }
}
