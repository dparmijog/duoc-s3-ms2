package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "issuer_nif")
    private String issuerNif;

    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "issuer_name")
    private String issuerName;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "receiver_nif")
    private String receiverNif;
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "receiver_name")
    private String receiverName;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "pet_name")
    private String petName;

    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "pet_description")
    private String petDescription;
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "invoice_date")
    private String date;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}