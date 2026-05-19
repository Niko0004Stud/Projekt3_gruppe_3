package org.projekt3_gruppe_3.controller;

import jakarta.servlet.http.HttpSession;
import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.User;
import org.projekt3_gruppe_3.service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

@Controller
public class BilController {

    @Autowired
    BilService bilService;

    @PostMapping("opretBil")
    public String cCreateBil(@RequestParam("vognnummer") String vognnummer,
                             @RequestParam("stelnummer") String stelnummer,
                             @RequestParam("maerke") String maerke,
                             @RequestParam("model") String model,
                             @RequestParam("udstyrsNiveau") int udstyrsNiveau,
                             @RequestParam("staalpris") double staalpris,
                             @RequestParam("regAfgift") double regAfgift,
                             @RequestParam("co2Udledning")double co2Udledning){
        String beskrivelse = "testBeskrivelseloremipsumeblablah";
        String statusBil = "nyBil";
        return bilService.sCreateBil(vognnummer, stelnummer, maerke, model, udstyrsNiveau, staalpris, regAfgift, co2Udledning, beskrivelse, statusBil);
    }

    @GetMapping("/getOversigtBil")
    public String cReadAllBil(@RequestParam("oversigtPageType") String oversigtPageType, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("oversigtPageType", oversigtPageType);
        model.addAttribute("bilList",bilService.sReadAllBil());
        model.addAttribute("user", user);

        return "oversigtPage";

    }

    @PostMapping("updateStatusBil")
    public String cUpdateStatusBil(@RequestParam("bilId") int bilId,
                                   @RequestParam("updateStatus") String updateStatus,
                                   Model model){


        if(updateStatus.equals("salgsKlar")){
//            model.addAttribute("bilid", bilId);
            return "redirect:/getCreatePage?opretPageType=createSkadeMatrix&bilId=" + bilId;
        }
        bilService.sUpdateStatusBil(bilId, updateStatus);

        return "redirect:/getOversigtBil?oversigtPageType=oversigtBil";
    }

}
