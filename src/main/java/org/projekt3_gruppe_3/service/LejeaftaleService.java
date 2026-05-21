package org.projekt3_gruppe_3.service;

import org.projekt3_gruppe_3.model.LaKvittering;
import org.projekt3_gruppe_3.model.Lejeaftale;
import org.projekt3_gruppe_3.repository.BilRepo;
import org.projekt3_gruppe_3.repository.LaKvitteringRepo;
import org.projekt3_gruppe_3.repository.LejeaftaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class LejeaftaleService {
        @Autowired
        private LejeaftaleRepo lejeaftaleRepo;

        private Lejeaftale lejeaftale;
    @Autowired
    private LaKvitteringRepo laKvitteringRepo;
    @Autowired
    private BilRepo bilRepo;

    //estera & sebastian
        public void createLejeaftale(int bilId, int kundeId, LocalDate startDate, LocalDate slutDate, double startPrisKr) {

            System.out.println("Startdate: "+startDate+" slutdate: "+slutDate);
            valideringLejeaftale(bilId, kundeId, startDate, slutDate, startPrisKr);
            String type="startKvittering";
            LaKvittering laKvittering=new LaKvittering( startDate, slutDate, startPrisKr, type);

            int laKvitteringId=laKvitteringRepo.createLaK(laKvittering );
            Lejeaftale lejeaftale = new Lejeaftale(bilId, kundeId, startDate, slutDate, startPrisKr);
            lejeaftale.setLaKvitteringId(laKvitteringId);
            lejeaftaleRepo.create(lejeaftale);
            bilRepo.updateStatusBil(bilId, "reserveret");
        }

        //estera
        public void createLaKvittering(LocalDate startDate, LocalDate slutDate, double startPrisKr, String type){
            type="startKvittering";
            LaKvittering laKvittering=new LaKvittering( startDate, slutDate, startPrisKr, type);
            laKvitteringRepo.createLaK(laKvittering);
        }

        //estera
        public void slutLaKvittering(int skadeMatrixId, LocalDate startDate, LocalDate slutDate, double totalPrisKr, String type){
            type="slutLaKvittering";
            LaKvittering laKvittering= new LaKvittering(skadeMatrixId, startDate, slutDate, totalPrisKr, type);
            int laKvitteringId = lejeaftale.getLaKvitteringId();
            int id=lejeaftale.getId();
            lejeaftaleRepo.updateLak(id,laKvitteringId);
        }

        //estera
        public  void updateLejeaftale(int bilId, int kundeId, int laKvitteringId, LocalDate startDate, LocalDate slutDate, double startPrisKr){

            Lejeaftale lejeaftale=new Lejeaftale(bilId, kundeId, startDate, slutDate, startPrisKr);

            String type="slutKvittering";
            LaKvittering laKvittering=new LaKvittering(startDate, slutDate, startPrisKr, type);
            lejeaftaleRepo.update(lejeaftale);

        }

    //estera & sebastian
    public void valideringLejeaftale(int bilId, int kundeId, LocalDate startDate, LocalDate slutDate, double startPrisKr){
        valideringBilId(bilId);
        valideringKundeId(kundeId);
        valideringstartDate(startDate.toString());
        valideringslutDate(slutDate.toString());
        valideringstartPrisKr(startPrisKr);
    }

    // estera & sebastian
    public void valideringBilId(int id){
        if(id<=0){
            throw new IllegalArgumentException("BilId værdi skal være en heltal større end 0");
        }
    }

    //estera & sebastian
    public void valideringKundeId(int id){
        if(id<=0){
            throw new IllegalArgumentException("KundeId kan ikke være et tal under 1");
        }
    }

    // estera & sebastian
    public void valideringlaKvitteringId(int id){
        if(id<=0){
            throw new IllegalArgumentException("laKvitteringId kan ikke være et tal under 1");
        }
    }

    // estera & sebastian
    public void valideringstartDate(String startDate){
        String trimmed=startDate.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDate kan ikke være en mere 12 tegn");
        }
    }


    //estera & sebastian
    public void valideringslutDate(String slutDate){
        String trimmed=slutDate.trim();
        if(trimmed.length()<4||trimmed.length()>12){
            throw new IllegalArgumentException("startDate kan ikke være en mere 12 tegn");
        }
    }

    // estera & sebastian
    public void valideringstartPrisKr(double pris){
        if(pris<=0){
            throw new IllegalArgumentException("startPrisKr kan ikke være 0 eller mindre end 0");
        }
    }

}
