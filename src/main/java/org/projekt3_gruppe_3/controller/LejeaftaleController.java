package org.projekt3_gruppe_3.controller;

import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.projekt3_gruppe_3.service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            /*@RequestParam("id") Long id,*/
            @RequestParam("bilId") Long bilId,
            @RequestParam("kundeId") Long kundeId,
            @RequestParam("skadeMatrixId") int skadeMatrix,
            @RequestParam("startDato") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDato,
            @RequestParam("laengdeDays") int laengeDays,
            @RequestParam("prisKr") double pris,
            @RequestParam("slutDato") @DateTimeFormat(pattern = "yyyy-MM-dd")Date slutDato) {
        System.out.println("du kom til createlejeaftale");
        return "redirect:/lejeaftale/list";

//           lejeaftaleService.createLejeaftale(
//                   id, bilId, kundeId, skadeMatrix, startDato, laengeDays, slutDato, pris
//            );

//            return "redirect:/lejeaftale/list";
//        }

//        @PostMapping("/delete")
//        public String deleteLejeaftale(@RequestParam("id") Long id) {
//            lejeaftaleService.deleteLejeaftale(id);
//            return "redirect:/lejeaftale/list";
//        }
    }
}
