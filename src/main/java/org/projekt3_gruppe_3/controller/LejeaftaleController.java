package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class LejeaftaleController {

    @Autowired
    LejeaftaleService lejeaftaleService;


        @PostMapping("/create")
        public String createLejeaftale(
                @RequestParam("id") Long id,
                @RequestParam("bilId") Long bilId,
                @RequestParam("kundeId") Long kundeId,
                @RequestParam("skadeMatrix") int skadeMatrix,
                @RequestParam("startDato") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDato,
                @RequestParam("laengeDays") int laengeDays,
                @RequestParam("pris") double pris
        ) {

            lejeaftaleService.createLejeaftale(
                    id, bilId, kundeId, skadeMatrix, startDato, laengeDays, pris
            );

            return "redirect:/lejeaftale/list";
        }

        @PostMapping("/delete")
        public String deleteLejeaftale(@RequestParam("id") Long id) {
            lejeaftaleService.deleteLejeaftale(id);
            return "redirect:/lejeaftale/list";
        }
    }
