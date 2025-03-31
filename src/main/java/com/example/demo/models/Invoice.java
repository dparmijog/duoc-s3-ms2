package com.example.demo.models;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private String id;
    private String issuerNif;
    private String issuerName;
    private String receiverNif;
    private String receiverName;
    private String petName;
    private String petDescription;
    private String date;
    private List<Detail> details;

    public Invoice() {
    }

    public Invoice(String id, String issuerNif, String issuerName, String receiverNif, String receiverName, String petName, String petDescription, String date, List<Detail> details) {
        this.id = id;
        this.issuerNif = issuerNif;
        this.issuerName = issuerName;
        this.receiverNif = receiverNif;
        this.receiverName = receiverName;
        this.petName = petName;
        this.petDescription = petDescription;
        this.date = date;
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIssuerNif() {
        return issuerNif;
    }

    public void setIssuerNif(String issuerNif) {
        this.issuerNif = issuerNif;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getReceiverNif() {
        return receiverNif;
    }

    public void setReceiverNif(String receiverNif) {
        this.receiverNif = receiverNif;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetDescription() {
        return petDescription;
    }

    public void setPetDescription(String petDescription) {
        this.petDescription = petDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    public BigDecimal getSubTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Detail detail : details) {
            total = detail.getAmount().add(total);
        }
        return total;
    }

    public BigDecimal getVAT() {
        BigDecimal total = BigDecimal.ZERO;
        for (Detail detail : details) {
            total = detail.getAmount().add(total);
        }
        return total.multiply(BigDecimal.valueOf(0.19));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Detail detail : details) {
            total = detail.getAmount().add(total);
        }
        return total.multiply(BigDecimal.valueOf(1.19));
    }
}
