package org.projekt3_gruppe_3.model;

public class Bil {

    private int id;
    private String vognnummer;
    private String stelnummer;
    private int modelId;

    public Bil(int id, String vognnummer, String stelnummer,
               int modelId, int udstyrsNiveau, double staalpris, double regAfgift,
               double co2Udledning) {
        this.id = id;
        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
        this.modelId = modelId;
        this.udstyrsNiveau = udstyrsNiveau;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
    }

    private int udstyrsNiveau;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;


}
