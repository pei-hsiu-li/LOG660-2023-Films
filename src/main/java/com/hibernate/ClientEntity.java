package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "CLIENT", schema = "EQUIPE112", catalog = "")
public class ClientEntity {
    @Basic
    @Column(name = "IDPERSONNE", nullable = false, precision = 0)
    private BigInteger idpersonne;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDCLIENT", nullable = false, precision = 0)
    private BigInteger idclient;
    @OneToOne(mappedBy = "client")
    private AbonnementEntity abonnements;
//    @OneToOne(mappedBy = "client")
//    private CartedecreditEntity cartedecredits;

    public BigInteger getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(BigInteger idpersonne) {
        this.idpersonne = idpersonne;
    }

    public BigInteger getIdclient() {
        return idclient;
    }

    public void setIdclient(BigInteger idclient) {
        this.idclient = idclient;
    }

    public AbonnementEntity getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(AbonnementEntity abonnements) {
        this.abonnements = abonnements;
    }

//    public CartedecreditEntity getCartedecredits() {
//        return cartedecredits;
//    }

//    public void setCartedecredits(CartedecreditEntity cartedecredits) {
//        this.cartedecredits = cartedecredits;
//    }
}
