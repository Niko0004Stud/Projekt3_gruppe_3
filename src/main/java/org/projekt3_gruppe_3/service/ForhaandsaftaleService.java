package org.projekt3_gruppe_3.service;


import org.projekt3_gruppe_3.model.FhaKvittering;
import org.projekt3_gruppe_3.model.Forhaandsaftale;
import org.projekt3_gruppe_3.model.LaKvittering;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.projekt3_gruppe_3.repository.FhaKvitteringRepo;
import org.projekt3_gruppe_3.repository.ForhaandsaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

//Natasha
@Service
public class ForhaandsaftaleService {
    @Autowired
    private ForhaandsaftaleRepo forhaandsaftaleRepo;
    private Forhaandsaftale forhaandsaftale;

    @Autowired
    private FhaKvitteringRepo fhaKvitteringRepo;
    private FhaKvittering fhaKvittering;

    @Autowired
    private BilRepo bilRepo;


    //Natasha

    public void createForhaandsaftale(int bilid, int kundeId, int fhaKvitteringId, LocalDate registreringsDate, double startprisKr, double totalPrisKr){

        System.out.println("registeringsDate: "+ registreringsDate);
        valideringForhaandsaftale(bilid, kundeId, fhaKvitteringId, registreringsDate, startprisKr);
        FhaKvittering fhaKvittering=new FhaKvittering(registreringsDate, totalPrisKr);

        fhaKvitteringId=fhaKvitteringRepo.createFhaK(fhaKvittering);
        Forhaandsaftale forhaandsaftale = new Forhaandsaftale(kundeId, bilid, fhaKvitteringId, registreringsDate, startprisKr);
        forhaandsaftale.setFhaKvitteringId(fhaKvitteringId);
        forhaandsaftaleRepo.create(forhaandsaftale);
        bilRepo.updateStatusBil(bilid, "reserveret");
    }


    public void createFhaKvittering (double totalPrisKr, LocalDate registeringDate) {

        FhaKvittering fhaKvittering = new FhaKvittering(registeringDate, totalPrisKr);
        fhaKvitteringRepo.createFhaK(fhaKvittering);

    }


    //Natasha
    public  void updateForhaandsaftaler(int kundeId, int bilId, int fhaKvitteringId, LocalDate registeringsDate, double startPrisKr, double totalPrisKr){

        Forhaandsaftale forhaandsaftale=new Forhaandsaftale(kundeId, bilId, fhaKvitteringId,registeringsDate, startPrisKr);


        FhaKvittering fhaKvittering=new FhaKvittering( registeringsDate, totalPrisKr);
        forhaandsaftaleRepo.update(forhaandsaftale);

    }


    public void valideringForhaandsaftale(int bilId, int kundeId,  int fhaKvitteringId, LocalDate registreringsDate, double startPrisKr){
        valideringBilId(bilId);
        valideringKundeId(kundeId);
        valideringstartDate(registreringsDate.toString());
        valideringstartPrisKr(startPrisKr);
    }


    public void valideringBilId(int id){
        if(id<=0){
            throw new IllegalArgumentException("BilId værdi skal være en heltal større end 0");
        }
    }


    public void valideringKundeId(int id){
        if(id<=0){
            throw new IllegalArgumentException("KundeId kan ikke være 0");
        }
    }


    public void valideringafahaKvitteringId(int id){
        if(id<=0){
            throw new IllegalArgumentException("FhaKvitteringId kan ikke være 0");
        }
    }

    public void valideringstartDate(String registeringsDate){
        String trimmed=registeringsDate.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("registeringsDate kan ikke være en mere 12 tegn");
        }
    }



    public void valideringstartPrisKr(double pris){
        if(pris<=0){
            throw new IllegalArgumentException("startPrisKr kan ikke være 0 eller mindre end 0");
        }
    }
}

