package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "COPIEPHYSIQUEFILM", schema = "EQUIPE112", catalog = "")
public class CopiephysiquefilmEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "CODEFILM", nullable = false, precision = 0)
    private int codefilm;
    @Basic
    @Column(name = "IDFILM", nullable = false, precision = 0)
    private BigInteger idfilm;

    public int getCodefilm() {
        return codefilm;
    }

    public void setCodefilm(int codefilm) {
        this.codefilm = codefilm;
    }

    public BigInteger getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(BigInteger idfilm) {
        this.idfilm = idfilm;
    }
}
