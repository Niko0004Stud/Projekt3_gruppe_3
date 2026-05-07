package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.math.BigDecimal;

@Service
public class LejeaftaleService {
        @Autowired
        private LejeaftaleRepo lejeaftaleRepo;

        public void createLejeaftale(int bilId, int kundeId, int skadeMatrixId,
                                     LocalDate startDato, int laengdeDays, LocalDate slutDato, double prisKr) {

            valideringLejeaftale(bilId, kundeId, skadeMatrixId, startDato, laengdeDays, slutDato, prisKr);

            Lejeaftale lejeaftale = new Lejeaftale(
                    bilId, kundeId, skadeMatrixId, startDato, laengdeDays, slutDato,  prisKr);

            lejeaftaleRepo.createLejeaftale(lejeaftale);
        }



        public void validate(int bilId,int kundeId, int skadeMatrixId,
                             LocalDate startDato, int laengdeDays, LocalDate slutDato, double prisKr) {

            if (bilId <=0) throw new IllegalArgumentException("Bil mangler");
            if (kundeId <=0) throw new IllegalArgumentException("Kunde mangler");

            if (skadeMatrixId < 0)
                throw new IllegalArgumentException("Ugyldig skadeMatrixId");

            if (startDato == null)
                throw new IllegalArgumentException("Startdato mangler");

            if (slutDato == null)
                throw new IllegalArgumentException("Slutdato mangler");

            if (slutDato.isBefore(startDato))
                throw new IllegalArgumentException("Slutdato må ikke være før startdato");

            if (laengdeDays <= 0)
                throw new IllegalArgumentException("Længde skal være over 0 dage");

    public void valideringLejeaftale(Lejeaftale lejeaftale){
        valideringBilId(lejeaftale.getBilId());
        valideringKundeId(lejeaftale.getKundeId());
        valideringskadeMatrixId(lejeaftale.getSkadeMatrixId());
        valideringstartDato(lejeaftale.getStartDato().toString());
        valideringLaengdeDays(lejeaftale.getLaengeDays());
        valideringslutDato(lejeaftale.getSlutDato().toString());
        valideringprisKr(lejeaftale.getPrisKr());
    }

    // bilId INT NOT NULL,
    public void valideringBilId(int id){
        if(id<=0){
            throw new IllegalArgumentException("BilId kan ikke være 0");
        }
    }

    //kundeId INT NOT NULL,
    public void valideringKundeId(int id){
        if(id<=0){
            throw new IllegalArgumentException("KundeId kan ikke være 0");
        }
    }

    //skadeMatrixId INT NOT NULL,
    public void valideringskadeMatrixId(int id){
        if(id<=0){
            throw new IllegalArgumentException("skadeMatrixId kan ikke være 0");
        }
    }

    //startDato DATE NOT NULL,
    public void valideringstartDato(String startDato){
        String trimmed=startDato.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDato kan ikke være en mere 12 tegn");
        }
    }

    //laengdeDays INTEGER NOT NULL,
    public void valideringLaengdeDays(int dage){
        if(dage<=0){
            throw new IllegalArgumentException("LaengdeDays kan ikke være 0");
        }
    }

    //slutDato DATE NOT NULL,
    public void valideringslutDato(String slutDato){
        String trimmed=slutDato.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDato kan ikke være en mere 12 tegn");
        }
    }

    //prisKr DECIMAL NOT NULL
    public void valideringprisKr(BigDecimal pris){
        if(pris==null || pris.compareTo(BigDecimal.valueOf(0))<=0){
            throw new IllegalArgumentException("prisKr kan ikke være 0 eller mindre end 0");
        }
    }

}
