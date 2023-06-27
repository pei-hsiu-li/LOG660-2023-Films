package com.hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class BandeannonceEntityPK implements Serializable {
    @Column(name = "LIENBANDEANNONCE", nullable = false, length = 250)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String lienbandeannonce;
    @Column(name = "IDFILM", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger idfilm;

    public String getLienbandeannonce() {
        return lienbandeannonce;
    }

    public void setLienbandeannonce(String lienbandeannonce) {
        this.lienbandeannonce = lienbandeannonce;
    }

    public BigInteger getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(BigInteger idfilm) {
        this.idfilm = idfilm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BandeannonceEntityPK that = (BandeannonceEntityPK) o;
        return Objects.equals(lienbandeannonce, that.lienbandeannonce) && Objects.equals(idfilm, that.idfilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lienbandeannonce, idfilm);
    }
}
