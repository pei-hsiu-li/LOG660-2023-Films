package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "LOCATION", schema = "EQUIPE112", catalog = "")
public class LocationEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator = "seq")
    @SequenceGenerator(name="seq", sequenceName="LOCATION_SEQ", allocationSize = 1)
    @Column(name = "IDLOCATION", unique = true, nullable = false, precision = 0)
    private BigInteger idlocation;
    @Basic
    @Column(name = "IDCLIENT", nullable = false, precision = 0)
    private BigInteger idclient;
    @Basic
    @Column(name = "CODEFILM", nullable = false, precision = 0)
    private int codefilm;
    @Basic
    @Column(name = "DATEPRET", nullable = false)
    private Date datepret;
    @Basic
    @Column(name = "DATERETOUR", nullable = true)
    private Date dateretour;
    @OneToOne
    @JoinColumn(name = "CODEFILM", referencedColumnName = "CODEFILM", nullable = false)
    private CopiephysiquefilmEntity copiephysiquefilm;

    public BigInteger getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(BigInteger idlocation) {
        this.idlocation = idlocation;
    }

    public BigInteger getIdclient() {
        return idclient;
    }

    public void setIdclient(BigInteger idclient) {
        this.idclient = idclient;
    }

    public int getCodefilm() {
        return codefilm;
    }

    public void setCodefilm(int codefilm) {
        this.codefilm = codefilm;
    }

    public Date getDatepret() {
        return datepret;
    }

    public void setDatepret(Date datepret) {
        this.datepret = datepret;
    }

    public Date getDateretour() {
        return dateretour;
    }

    public void setDateretour(Date dateretour) {
        this.dateretour = dateretour;
    }

    public CopiephysiquefilmEntity getCopiephysiquefilm() {
        return copiephysiquefilm;
    }

    public void setCopiephysiquefilm(CopiephysiquefilmEntity copiephysiquefilm) {
        this.copiephysiquefilm = copiephysiquefilm;
    }
}
