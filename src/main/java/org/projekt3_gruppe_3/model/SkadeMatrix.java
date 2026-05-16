package org.projekt3_gruppe_3.model;

import java.time.LocalDate;

//estera
public class SkadeMatrix {
    private int id;
    private int bilId;
    private double omkostninger;
    private LocalDate registreringsDate;

    public SkadeMatrix(int id, int bilId, double omkostninger, LocalDate registreringsDate) {
        this.id = id;
        this.bilId = bilId;
        this.omkostninger= omkostninger;
        this.registreringsDate = registreringsDate;
    }

    public SkadeMatrix(int bilId, double omkostninger, LocalDate registreringsDate) {
        this.bilId = bilId;
        this.omkostninger = omkostninger;
        this.registreringsDate = registreringsDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public double getOmkostninger() {
        return omkostninger;
    }

    public void setOmkostninger(double omkostninger) {
        this.omkostninger = omkostninger;
    }

    public LocalDate getRegistreringsDate() {
        return registreringsDate;
    }

    public void setRegistreringsDate(LocalDate registreringsDate) {
        this.registreringsDate = registreringsDate;
    }


}
