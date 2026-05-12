package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BilService {

    @Autowired
    BilRepo bilRepo;

    public String sCreateBil(String vognnummer,
                             String stelnummer,
                             String maerke,
                             String model,
                             int udstyrsniveau,
                             double staalpris,
                             double regAfgift,
                             double co2Udledning){

        bilRepo.rCreateBil(new Bil(vognnummer, stelnummer, maerke, model, udstyrsniveau, staalpris, regAfgift, co2Udledning));
        return "redirect:/userpage";
    }

}
