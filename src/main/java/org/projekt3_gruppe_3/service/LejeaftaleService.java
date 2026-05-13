package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class LejeaftaleService {
        @Autowired
        private LejeaftaleRepo lejeaftaleRepo;

        private Lejeaftale lejeaftale;

        //estera & sebastian
        public void createLejeaftale(int bilId, int kundeId, int skadeMatrixId,
                                     LocalDate startDato, int laengdeDays, LocalDate slutDato, double prisKr) {

            valideringLejeaftale(bilId, kundeId, skadeMatrixId, startDato, laengdeDays, slutDato, prisKr);

            Lejeaftale lejeaftale = new Lejeaftale(
                    bilId, kundeId, skadeMatrixId, startDato, laengdeDays, slutDato,  prisKr);

            lejeaftaleRepo.create(lejeaftale);
        }

    //estera & sebastian
    public void valideringLejeaftale(int bilId, int kundeId, int skadeMatrixId,
                                     LocalDate startDato, int laengdeDays, LocalDate slutDato, double prisKr){
        valideringBilId(bilId);
        valideringKundeId(kundeId);
        valideringskadeMatrixId(skadeMatrixId);
        valideringstartDato(startDato.toString());
        valideringLaengdeDays(laengdeDays);
        valideringslutDato(slutDato.toString());
        valideringprisKr(prisKr);
    }

    // bilId INT NOT NULL, estera & sebastian
    public void valideringBilId(int id){
        if(id<=0){
            throw new IllegalArgumentException("BilId kan ikke være 0");
        }
    }

    //kundeId INT NOT NULL, estera & sebastian
    public void valideringKundeId(int id){
        if(id<=0){
            throw new IllegalArgumentException("KundeId kan ikke være 0");
        }
    }

    //skadeMatrixId INT NOT NULL, estera & sebastian
    public void valideringskadeMatrixId(int id){
        if(id<=0){
            throw new IllegalArgumentException("skadeMatrixId kan ikke være 0");
        }
    }

    //startDato DATE NOT NULL, estera & sebastian
    public void valideringstartDato(String startDato){
        String trimmed=startDato.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDato kan ikke være en mere 12 tegn");
        }
    }

    //laengdeDays INTEGER NOT NULL,estera & sebastian
    public void valideringLaengdeDays(int dage){
        if(dage<=0){
            throw new IllegalArgumentException("LaengdeDays kan ikke være 0");
        }
    }

    //slutDato DATE NOT NULL,estera & sebastian
    public void valideringslutDato(String slutDato){
        String trimmed=slutDato.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDato kan ikke være en mere 12 tegn");
        }
    }

    //prisKr DECIMAL NOT NULL, estera & sebastian
    public void valideringprisKr(double pris){
        if(pris<=0){
            throw new IllegalArgumentException("prisKr kan ikke være 0 eller mindre end 0");
        }
    }

}
