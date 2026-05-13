package org.projekt3_gruppe_3.model;

import java.time.LocalDate;

public class LaKvittering {
    private  int id;
    private  int skadeMatrixId;
    private LocalDate startDate;
    private LocalDate slutDate;
    private double totalPrisKr;
    private String type;
    private int lejeaftaleId;
    private double foerstegangsydelseKr;

    public LaKvittering(int id, int skadeMatrixId, LocalDate startDate, LocalDate slutDate, double totalPrisKr, String type, int lejeaftaleId, double foerstegangsydelseKr) {
        this.id = id;
        this.skadeMatrixId = skadeMatrixId;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.totalPrisKr = totalPrisKr;
        this.type = type;
        this.lejeaftaleId=lejeaftaleId;
        this.foerstegangsydelseKr=foerstegangsydelseKr;
    }

    public LaKvittering() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSkadeMatrixId() {
        return skadeMatrixId;
    }

    public void setSkadeMatrixId(int skadeMatrixId) {
        this.skadeMatrixId = skadeMatrixId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }

    public void setSlutDate(LocalDate slutDate) {
        this.slutDate = slutDate;
    }

    public double getTotalPrisKr() {
        return totalPrisKr;
    }

    public void setTotalPrisKr(double totalPrisKr) {
        this.totalPrisKr = totalPrisKr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLejeaftaleId() {
        return lejeaftaleId;
    }

    public void setLejeaftaleId(int lejeaftaleId) {
        this.lejeaftaleId = lejeaftaleId;
    }

    public double getFoerstegangsydelseKr() {
        return foerstegangsydelseKr;
    }

    public void setFoerstegangsydelseKr(double foerstegangsydelseKr) {
        this.foerstegangsydelseKr = foerstegangsydelseKr;
    }



}