package org.projekt3_gruppe_3.model;
import java.time.LocalDate;


public class Forhaandsaftale {
   private int id;
   private int bilId;
   private int kundeID;
   private int FhaKvitteringId;
   private LocalDate RegDate;
   private double StartPrisKr;


   public Forhaandsaftale(int id,int bilId,
                          int kundeID,
                          int FhaKvitteringId,
                          LocalDate RegDate, double StartPrisKr) {
       this.id = id;
       this.bilId = bilId;
       this.kundeID = kundeID;
       this.FhaKvitteringId = FhaKvitteringId;
       this.RegDate = RegDate;
       this.StartPrisKr = StartPrisKr;

   }

public Forhaandsaftale (){

       }

    public int getId(){
        return  id;}

   public int getBilId(){
       return  bilId;
   }

   public int getFhaKvitteringId(){
       return FhaKvitteringId;
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
