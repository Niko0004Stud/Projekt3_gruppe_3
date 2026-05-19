package org.projekt3_gruppe_3.model;
import java.time.LocalDate;

//Natasha
public class Forhaandsaftale {
   private int id;
   private int bilId;
   private int kundeID;
   private int fhaKvitteringId;
   private LocalDate RegDate;
   private double StartPrisKr;


   public Forhaandsaftale(int id,int bilId,
                          int kundeID,
                          int fhaKvitteringId,
                          LocalDate RegDate, double StartPrisKr) {
       this.id = id;
       this.bilId = bilId;
       this.kundeID = kundeID;
       this.fhaKvitteringId = fhaKvitteringId;
       this.RegDate = RegDate;
       this.StartPrisKr = StartPrisKr;

   }

public Forhaandsaftale (int bilId,
                        int kundeID,
                        int fhaKvitteringId,
                        LocalDate RegDate, double StartPrisKr){

    this.bilId = bilId;
    this.kundeID = kundeID;
    this.fhaKvitteringId = fhaKvitteringId;
    this.RegDate = RegDate;
    this.StartPrisKr = StartPrisKr;

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
        return RegDate;


    }
    public double getStartPrisKr(){
        return StartPrisKr;
    }

}
