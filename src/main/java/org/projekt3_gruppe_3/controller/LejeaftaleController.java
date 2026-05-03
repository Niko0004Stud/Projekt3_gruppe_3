package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LejeaftaleController {

    @Autowired
    LejeaftaleService lejeaftaleService;

    @GetMapping("/showAllLejeaftaler")
    public String showAllLejeaftaler(){

        System.out.println(lejeaftaleService.getAllLejeaftaler());

        return"/";
    }
}
