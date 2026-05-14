package org.projekt3_gruppe_3.model;

import java.time.LocalDate;

//estera
public class Skade {
    private int id;
    private String beskrivelse;
    private double omkostning;
    private LocalDate registreringsDate;

    public Skade(int id, String beskrivelse, double omkostning, LocalDate registreringsDate) {
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.omkostning = omkostning;
        this.registreringsDate = registreringsDate;
    }

    public Skade() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public double getOmkostning() {
        return omkostning;
    }

    public void setOmkostning(double omkostning) {
        this.omkostning = omkostning;
    }

    public LocalDate getRegistreringsDate() {
        return registreringsDate;
    }

    public void setRegistreringsDate(LocalDate registreringsDate) {
        this.registreringsDate = registreringsDate;
    }


}
