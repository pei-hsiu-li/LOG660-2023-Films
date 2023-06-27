package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "ABONNEMENT", schema = "EQUIPE112", catalog = "")
public class AbonnementEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDABONNEMENT", nullable = false, precision = 0)
    private BigInteger idabonnement;
    @Basic
    @Column(name = "IDCLIENT", nullable = false, precision = 0)
    private BigInteger idclient;
    @Basic
    @Column(name = "CODEFORFAIT", nullable = false, length = 1)
    private String codeforfait;

    public BigInteger getIdabonnement() {
        return idabonnement;
    }

    public void setIdabonnement(BigInteger idabonnement) {
        this.idabonnement = idabonnement;
    }

    public BigInteger getIdclient() {
        return idclient;
    }

    public void setIdclient(BigInteger idclient) {
        this.idclient = idclient;
    }

    public String getCodeforfait() {
        return codeforfait;
    }

    public void setCodeforfait(String codeforfait) {
        this.codeforfait = codeforfait;
    }
}
