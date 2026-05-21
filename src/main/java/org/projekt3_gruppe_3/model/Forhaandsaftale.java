package org.projekt3_gruppe_3.model;
import java.time.LocalDate;

//Natasha
public class Forhaandsaftale {
   private int id;
   private int bilId;
   private int kundeID;
   private int fhaKvitteringId;
   private LocalDate registreringsDate;
   private double startPrisKr;


   public Forhaandsaftale(int id, int bilId,
                          int kundeID,
                          int fhaKvitteringId,
                          LocalDate registreringsDate, double startPrisKr) {
       this.id = id;
       this.bilId = bilId;
       this.kundeID = kundeID;
       this.fhaKvitteringId = fhaKvitteringId;
       this.registreringsDate = registreringsDate;
       this.startPrisKr = startPrisKr;

   }

public Forhaandsaftale (int bilId,
                        int kundeID,
                        int fhaKvitteringId,
                        LocalDate registreringsDate, double startPrisKr){

    this.bilId = bilId;
    this.kundeID = kundeID;
    this.fhaKvitteringId = fhaKvitteringId;
    this.registreringsDate = registreringsDate;
    this.startPrisKr = startPrisKr;

       }

    public int getId(){
        return  id;}

   public int getBilId(){
       return  bilId;
   }

   public int getFhaKvitteringId(){
       return fhaKvitteringId;
   }

   public int getkundeID(){
       return kundeID;
   }

    public LocalDate RegDate() {
        return registreringsDate;


    }
    public double getStartPrisKr(){
        return startPrisKr;
    }

    public void setBilId(int bilId) {
        this.bilId = bilId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public void setFhaKvitteringId(int fhaKvitteringId) {
        this.fhaKvitteringId = fhaKvitteringId;
    }

    public void setRegistreringsDate(LocalDate registreringsDate) {
        this.registreringsDate = registreringsDate;
    }

    public void setStartPrisKr(double startPrisKr) {
        this.startPrisKr = startPrisKr;
    }

}
