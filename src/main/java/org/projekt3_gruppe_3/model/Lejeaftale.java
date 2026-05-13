package org.projekt3_gruppe_3.model;
import java.time.LocalDate;

public class Lejeaftale {
    private int id;
    private int bilId;
    private int kundeId;
    private int skadeMatrixId;//lidt i tvivl, der er snak
    private LocalDate startDate;
    private int laengeDays;
    private LocalDate slutDate;
    private double prisKr;

    // Til at oprette fra eksisterende objekt i DB
    public Lejeaftale(int id, int bilId, int kundeId, int skadeMatrixId, LocalDate startDate, int laengeDays, LocalDate slutDate, double prisKr) {
        this.id = id;
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.skadeMatrixId = skadeMatrixId;
        this.startDate = startDate;
        this.laengeDays = laengeDays;
        this.slutDate = slutDate;
        this.prisKr = prisKr;
    }

    // Til at oprette nyt objekt til DB
    public Lejeaftale(int bilId, int kundeId, int skadeMatrixId, LocalDate startDato, int laengeDays, LocalDate slutDato, double prisKr) {
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.skadeMatrixId = skadeMatrixId;
        this.startDate = startDate;
        this.laengeDays = laengeDays;
        this.slutDate = slutDate;
        this.prisKr = prisKr;
    }

    public String toString(){
        return "Id: "+id+" Bil id: "+bilId+" Kunde id: "+kundeId+" Skade Matrix id: "+skadeMatrixId+" startDate: "+startDate+" LængdeDays: "+laengeDays+" slutDato: "+slutDate+" pris: "+prisKr;
    }

    public int getBilId() {
        return bilId;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public int getKundeId() {
        return kundeId;
    }

    public void setKundeId(int kundeId) {
        this.kundeId = kundeId;
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

    public int getLaengeDays() {
        return laengeDays;
    }

    public void setLaengeDays(int laengeDays) {
        this.laengeDays = laengeDays;
    }

    public LocalDate getSlutDate() {
        return slutDate;
    }

    public void setSlutDato(LocalDate slutDate) {
        this.slutDate = slutDate;
    }

    public double getPrisKr() {
        return prisKr;
    }

    public void setPrisKr(double prisKr) {
        this.prisKr = prisKr;
    }

}
