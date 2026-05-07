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

            if (prisKr <= 0)
                throw new IllegalArgumentException("Pris skal være over 0");
        }
    }
