package org.projekt3_gruppe_3.model;
import java.time.LocalDate;

public class Lejeaftale {
    private int id;
    private int bilId;
    private int kundeId;
    private int laKvitteringId;
    private LocalDate startDate;
    private LocalDate slutDate;
    private double startPrisKr;

    // Til at oprette fra eksisterende objekt i DB
    public Lejeaftale(int id, int bilId, int kundeId, int laKvitteringId, LocalDate startDate, LocalDate slutDate, double startPrisKr) {
        this.id = id;
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.laKvitteringId = laKvitteringId;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.startPrisKr = startPrisKr;
    }

    // Til at oprette nyt objekt til DB
    public Lejeaftale(int bilId, int kundeId, LocalDate startDate, LocalDate slutDate, double startPrisKr) {
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.laKvitteringId = laKvitteringId;
        this.startDate = startDate;
        this.slutDate = slutDate;
        this.startPrisKr = startPrisKr;
    }

    public String toString() {
        return "Id: " + id + " Bil id: " + bilId + " Kunde id: " + kundeId  + " startDate: " + startDate + " slutDate: " + slutDate + " pris: " + startPrisKr;
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

    public double getstartPrisKr() {
        return startPrisKr;
    }

    public void setstartPrisKr(double startPrisKr) {
        this.startPrisKr = startPrisKr;
    }

}
