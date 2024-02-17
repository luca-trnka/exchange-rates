package com.example.kurzovni_listky.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortName;
    private LocalDateTime validFrom;
    private String name;
    private String country;
    private double move;
    private int amount;
    private double valBuy;
    private double valSell;
    private double valMid;
    private double currBuy;
    private double currSell;
    private double currMid;
    private int version;
    private double cnbMid;
    private double ecbMid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getMove() {
        return move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public void setValBuy(double valBuy) {
        this.valBuy = valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public void setValSell(double valSell) {
        this.valSell = valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public void setValMid(double valMid) {
        this.valMid = valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public void setCurrBuy(double currBuy) {
        this.currBuy = currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public void setCurrSell(double currSell) {
        this.currSell = currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public void setCurrMid(double currMid) {
        this.currMid = currMid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public void setCnbMid(double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public double getEcbMid() {
        return ecbMid;
    }

    public void setEcbMid(double ecbMid) {
        this.ecbMid = ecbMid;
    }
}