package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "BANDEANNONCE", schema = "EQUIPE112", catalog = "")
@IdClass(BandeannonceEntityPK.class)
public class BandeannonceEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "LIENBANDEANNONCE", nullable = false, length = 250)
    private String lienbandeannonce;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDFILM", nullable = false, precision = 0)
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
}
