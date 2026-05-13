package org.projekt3_gruppe_3.model;

public class Bil {

    private int id;
    private String vognnummer;
    private String stelnummer;
    private int modelId;
    private int udstyrsNiveau;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;

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

    public Bil(
            String vognnummer,
            String stelnummer,
            int modelId,
            int udstyrsNiveau,
            double staalpris,
            double regAfgift,
            double co2Udledning) {

        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
        this.modelId = modelId;
        this.udstyrsNiveau = udstyrsNiveau;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModel(int modelId) {
        this.modelId = modelId;
    }

    public int getUdstyrsNiveau() {
        return udstyrsNiveau;
    }

    public void setUdstyrsNiveau(int udstyrsniveau) {
        this.udstyrsNiveau = udstyrsniveau;
    }

    public double getStaalpris() {
        return staalpris;
    }

    public void setStaalpris(double staalpris) {
        this.staalpris = staalpris;
    }

    public double getRegAfgift() {
        return regAfgift;
    }

    public void setRegAfgift(double regAfgift) {
        this.regAfgift = regAfgift;
    }

    public double getCo2Udledning() {
        return co2Udledning;
    }

    public void setCo2Udledning(double co2Udledning) {
        this.co2Udledning = co2Udledning;
    }
}
