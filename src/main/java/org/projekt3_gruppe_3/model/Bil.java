package org.projekt3_gruppe_3.model;

public class Bil {

    private int id;
    private String vognnummer;
    private String stelnummer;
    private String maerke;
    private String model;
    private int udstyrsniveau;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;


    public Bil(double co2Udledning){
        this.co2Udledning=co2Udledning;
    }
}
