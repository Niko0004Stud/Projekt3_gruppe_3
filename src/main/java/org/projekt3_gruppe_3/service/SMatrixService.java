package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.SkadeMatrix;
import org.projekt3_gruppe_3.repository.SMatrixRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SMatrixService {

    @Autowired
    SMatrixRepo sMatrixRepo;
    public void sCreateMatrix(int bilId, double omkostninger, LocalDate registreringsDate){
        SkadeMatrix skadeMatrix=new SkadeMatrix(bilId, omkostninger, registreringsDate);
    }
}
