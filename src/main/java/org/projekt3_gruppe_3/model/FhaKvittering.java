package org.projekt3_gruppe_3.model;

import java.time.LocalDate;
//Natasha
public class FhaKvittering {
    private int id;
    private int skadeMatrixId;
    private LocalDate registreringDate;
    private double totalPrisKr;



   public FhaKvittering( int id, int skadeMatrixId, LocalDate registreringDate,double totalPrisKr){
        this.id=id;
        this.skadeMatrixId=skadeMatrixId;
        this.registreringDate=registreringDate;
        this.totalPrisKr=totalPrisKr;
    }

    public FhaKvittering(LocalDate registreringDate, double totalPrisKr){
       this.registreringDate=registreringDate;
       this.totalPrisKr=totalPrisKr;
    }

    public FhaKvittering (int skadeMatrixId, LocalDate registreringDate,double totalPrisKr){
        this.skadeMatrixId=skadeMatrixId;
        this.registreringDate=registreringDate;
        this.totalPrisKr=totalPrisKr;
    }

    public FhaKvittering (){

    }

    public int getId() {
        return id;
    }

    public int getSkadeMatrixId() {
        return skadeMatrixId;
    }

    public LocalDate getRegistreringDate() {
        return registreringDate;
    }

    public double getTotalPrisKr() {
        return totalPrisKr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSkadeMatrixId(int skadeMatrixId) {
        this.skadeMatrixId = skadeMatrixId;
    }

    public void setRegistreringDate(LocalDate registreringDate) {
        this.registreringDate = registreringDate;
    }

    public void setTotalPrisKr(double totalPrisKr) {
        this.totalPrisKr = totalPrisKr;
    }





}
