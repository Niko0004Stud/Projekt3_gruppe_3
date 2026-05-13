package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BilController {

    @Autowired
    BilService bilService;

    @PostMapping("opretBil")
    public String cCreateBil(@RequestParam("vognnummer") String vognnummer,
                             @RequestParam("stelnummer") String stelnummer,
                             @RequestParam("maerke") String maerke,
                             @RequestParam("model") String model,
                             @RequestParam("udstyrsniveau") int udstyrsniveau,
                             @RequestParam("staalpris") double staalpris,
                             @RequestParam("regAfgift") double regAfgift,
                             @RequestParam("co2Udledning")double co2Udledning){

        return bilService.sCreateBil(vognnummer, stelnummer, maerke, model, udstyrsniveau, staalpris, regAfgift, co2Udledning);
    }

    @GetMapping("visAlleBiler")
    public String cReadAllBil(Model model){

        return bilService.sReadAllBil(model);
    }



}
