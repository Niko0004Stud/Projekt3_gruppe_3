package org.projekt3_gruppe_3.model;

public class Bil {

    private int id;
    private String vognnummer;
    private String stelnummer;
    private int modelId;
    private Bilmodel bilmodel;
    private int udstyrsNiveau;
    private double staalpris;
    private double regAfgift;
    private double co2Udledning;
    private String statusBil;


    public Bil(int id, String vognnummer, String stelnummer,
               Bilmodel bilmodel, int udstyrsNiveau, double staalpris, double regAfgift,
               double co2Udledning, String statusBil) {
        this.id = id;
        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
        this.bilmodel = bilmodel;
        this.udstyrsNiveau = udstyrsNiveau;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
        this.statusBil = statusBil;
    }

    public Bil(
            String vognnummer,
            String stelnummer,
//            Bilmodel bilmodel,
            int udstyrsNiveau,
            double staalpris,
            double regAfgift,
            double co2Udledning,
            String statusBil) {

        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
//        this.bilmodel = bilmodel;
        this.udstyrsNiveau = udstyrsNiveau;
        this.staalpris = staalpris;
        this.regAfgift = regAfgift;
        this.co2Udledning = co2Udledning;
        this.statusBil = statusBil;
    }
    public Bil(){

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

    public Bilmodel getBilmodel() {
        return bilmodel;
    }

    public void setBilmodel(Bilmodel bilmodel) {
        this.bilmodel = bilmodel;
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

    public String getStatusBil(){
        return statusBil;
    }

    public String setStatusBil(String statusBil){
        return this.statusBil = statusBil;
    }
}
