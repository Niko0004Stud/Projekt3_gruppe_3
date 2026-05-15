package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.Bil;
import org.projekt3_gruppe_3.model.Bilmodel;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BilService {

    @Autowired
    BilRepo bilRepo;

    // CreateBil logik fra controller til repo af Nicklas
    public String sCreateBil(String vognnummer,
                             String stelnummer,
                             String maerke,
                             String model,
                             int udstyrsNiveau,
                             double staalpris,
                             double regAfgift,
                             double co2Udledning,
                             String beskrivelse,
                             String statusBil){


        bilRepo.createBil(new Bil(vognnummer, stelnummer, udstyrsNiveau, staalpris, regAfgift, co2Udledning, statusBil), new Bilmodel(model, maerke, beskrivelse));
        return "redirect:/userpage";
    }

    public List<Bil> sReadAllBil(){


        return bilRepo.getAll();
    }

    public void sUpdateStatusBil(int id, String updateStatus){

        bilRepo.updateStatusBil(id, updateStatus);
    }
}
