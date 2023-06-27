package com.hibernate;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

public class FilmartisteEntityPK implements Serializable {
    private BigInteger idfilm;
    private BigInteger idartiste;
    private String metier;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmartisteEntityPK that = (FilmartisteEntityPK) o;
        return Objects.equals(idfilm, that.idfilm) && Objects.equals(idartiste, that.idartiste) && Objects.equals(metier, that.metier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfilm, idartiste, metier);
    }
}
