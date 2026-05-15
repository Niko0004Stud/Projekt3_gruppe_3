package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.LaKvittering;
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
        public void createLejeaftale(int bilId, int kundeId, int laKvitteringId,
                                     LocalDate startDate, LocalDate slutDate, double prisKr) {

            System.out.println("Startdate: "+startDate+" slutdate: "+slutDate);
            valideringLejeaftale(bilId, kundeId, laKvitteringId, startDate, slutDate, prisKr);

            Lejeaftale lejeaftale = new Lejeaftale(
                    bilId, kundeId, startDate, slutDate,  prisKr);

            String type="startKvittering";
            int skadeMatrixId=1;
            LaKvittering laKvittering=new LaKvittering(skadeMatrixId, startDate, startDate, prisKr, type);

            lejeaftaleRepo.create(lejeaftale, laKvittering);
        }

    //estera & sebastian
    public void valideringLejeaftale(int bilId, int kundeId, int laKvitteringId,
                                     LocalDate startDate, LocalDate slutDate, double prisKr){
        valideringBilId(bilId);
        valideringKundeId(kundeId);
        valideringlaKvitteringId(laKvitteringId);
        valideringstartDate(startDate.toString());
        valideringslutDate(slutDate.toString());
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

    //laKvitteringId INT NOT NULL, estera & sebastian
    public void valideringlaKvitteringId(int id){
        if(id<=0){
            throw new IllegalArgumentException("laKvitteringId kan ikke være 0");
        }
    }

    //startDate DATE NOT NULL, estera & sebastian
    public void valideringstartDate(String startDate){
        String trimmed=startDate.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDate kan ikke være en mere 12 tegn");
        }
    }


    //slutDate DATE NOT NULL,estera & sebastian
    public void valideringslutDate(String slutDate){
        String trimmed=slutDate.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDate kan ikke være en mere 12 tegn");
        }
    }

    //prisKr DECIMAL NOT NULL, estera & sebastian
    public void valideringprisKr(double pris){
        if(pris<=0){
            throw new IllegalArgumentException("prisKr kan ikke være 0 eller mindre end 0");
        }
    }

}
