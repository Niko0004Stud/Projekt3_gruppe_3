package org.projekt3_gruppe_3.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

public class Lejeaftale {

    private int id;
    private int bilId;
    private int kundeId;
    private int skadeMatrixId;//lidt i tvivl, der er snak
    private LocalDate startDato;
    private int laengeDays;
    private LocalDate slutDato;
    private double prisKr;

}
