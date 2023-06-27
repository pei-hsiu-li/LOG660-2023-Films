package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "CARTEDECREDIT", schema = "EQUIPE112", catalog = "")
public class CartedecreditEntity {
    @Basic
    @Column(name = "TYPECARTE", nullable = false, length = 20)
    private String typecarte;

    @Id
    @Column(name = "NUMERO", nullable = false, length = 19)
    private String numero;
    @Basic
    @Column(name = "DATEEXPIRATION", nullable = false)
    private Date dateexpiration;
    @Basic
    @Column(name = "IDCLIENT", nullable = false, precision = 0)
    private BigInteger idclient;

    public String getTypecarte() {
        return typecarte;
    }

    public void setTypecarte(String typecarte) {
        this.typecarte = typecarte;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public BigInteger getIdclient() {
        return idclient;
    }

    public void setIdclient(BigInteger idclient) {
        this.idclient = idclient;
    }
}
