package org.projekt3_gruppe_3.model;

public class Bilmodel {
    private int id;
    private String model;
    private String maerke;
    private String beskrivelse;

    public Bilmodel(int id, String model, String maerke, String beskrivelse) {
        this.id = id;
        this.model = model;
        this.maerke = maerke;
        this.beskrivelse = beskrivelse;
    }

    public Bilmodel(String model, String maerke, String beskrivelse) {
        this.model = model;
        this.maerke = maerke;
        this.beskrivelse = beskrivelse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaerke() {
        return maerke;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
