package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "FORFAIT", schema = "EQUIPE112", catalog = "")
public class ForfaitEntity {
    @Basic
    @Column(name = "COUT", nullable = false, precision = 0)
    private BigInteger cout;
    @Basic
    @Column(name = "LOCATIONMAX", nullable = false, precision = 0)
    private byte locationmax;
    @Basic
    @Column(name = "DUREEMAX", nullable = false, precision = 0)
    private BigInteger dureemax;

    @Id
    @Column(name = "CODEFORFAIT", nullable = false, length = 1)
    private String codeforfait;

    public BigInteger getCout() {
        return cout;
    }

    public void setCout(BigInteger cout) {
        this.cout = cout;
    }

    public byte getLocationmax() {
        return locationmax;
    }

    public void setLocationmax(byte locationmax) {
        this.locationmax = locationmax;
    }

    public BigInteger getDureemax() {
        return dureemax;
    }

    public void setDureemax(BigInteger dureemax) {
        this.dureemax = dureemax;
    }

    public String getCodeforfait() {
        return codeforfait;
    }

    public void setCodeforfait(String codeforfait) {
        this.codeforfait = codeforfait;
    }
}
