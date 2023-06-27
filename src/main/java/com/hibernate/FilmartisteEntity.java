package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "FILMARTISTE", schema = "EQUIPE112", catalog = "")
@IdClass(FilmartisteEntityPK.class)
public class FilmartisteEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDFILM", nullable = false, precision = 0)
    private BigInteger idfilm;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDARTISTE", nullable = false, precision = 0)
    private BigInteger idartiste;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "METIER", nullable = false, length = 20)
    private String metier;
    @Basic
    @Column(name = "PERSONNAGE", nullable = true, length = 200)
    private String personnage;

    public BigInteger getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(BigInteger idfilm) {
        this.idfilm = idfilm;
    }

    public BigInteger getIdartiste() {
        return idartiste;
    }

    public void setIdartiste(BigInteger idartiste) {
        this.idartiste = idartiste;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

}
