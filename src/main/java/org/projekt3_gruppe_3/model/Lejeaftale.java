package org.projekt3_gruppe_3.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Lejeaftale {

    private int id;
    private int bilId;
    private int kundeId;
    private int skadeMatrixId;//lidt i tvivl, der er snak
    private LocalDate startDato;
    private int laengeDays;
    private LocalDate slutDato;
    private BigDecimal prisKr;

    public Lejeaftale(int id, int bilId, int kundeId, int skadeMatrixId, LocalDate startDato, int laengeDays, LocalDate slutDato, BigDecimal prisKr) {
        this.id = id;
        this.bilId = bilId;
        this.kundeId = kundeId;
        this.skadeMatrixId = skadeMatrixId;
        this.startDato = startDato;
        this.laengeDays = laengeDays;
        this.slutDato = slutDato;
        this.prisKr = prisKr;
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

    public int getSkadeMatrixId() {
        return skadeMatrixId;
    }

    public void setSkadeMatrixId(int skadeMatrixId) {
        this.skadeMatrixId = skadeMatrixId;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public int getLaengeDays() {
        return laengeDays;
    }

    public void setLaengeDays(int laengeDays) {
        this.laengeDays = laengeDays;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public BigDecimal getPrisKr() {
        return prisKr;
    }

    public void setPrisKr(BigDecimal prisKr) {
        this.prisKr = prisKr;
    }

}
