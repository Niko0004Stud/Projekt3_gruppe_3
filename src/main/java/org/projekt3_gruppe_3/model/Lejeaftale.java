package org.projekt3_gruppe_3.model;
import java.time.LocalDate;

public class Lejeaftale {
    private int id;
    private int bilId;
    private int kundeId;
    private int laKvitteringId;
    private LocalDate startDate;
    private LocalDate slutDate;
    private double prisKr;

    // Til at oprette fra eksisterende objekt i DB
    public Lejeaftale(int id, int bilId, int kundeId, int laKvitteringId, LocalDate startDate, LocalDate slutDate, double prisKr) {
        this.id = id;
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.laKvitteringId = laKvitteringId;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.prisKr = prisKr;
    }

    // Til at oprette nyt objekt til DB
    public Lejeaftale(int bilId, int kundeId, LocalDate startDate, LocalDate slutDate, double prisKr) {
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.laKvitteringId = laKvitteringId;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.prisKr = prisKr;
    }

    public String toString() {
        return "Id: " + id + " Bil id: " + bilId + " Kunde id: " + kundeId  + " startDate: " + startDate + " slutDate: " + slutDate + " pris: " + prisKr;
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

    public int getLaKvitteringId(){
        return laKvitteringId;
    }

    public void setLaKvitteringId( int laKvitteringId){
        this.laKvitteringId=laKvitteringId;
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

    public double getPrisKr() {
        return prisKr;
    }

    public void setPrisKr(double prisKr) {
        this.prisKr = prisKr;
    }

}
