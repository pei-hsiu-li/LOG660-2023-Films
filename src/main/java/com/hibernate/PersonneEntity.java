package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;

@Entity
@Table(name = "PERSONNE", schema = "EQUIPE112", catalog = "")
public class PersonneEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDPERSONNE", nullable = false, precision = 0)
    private BigInteger idpersonne;
    @Basic
    @Column(name = "PRENOM", nullable = false, length = 25)
    private String prenom;
    @Basic
    @Column(name = "NOMFAMILLE", nullable = false, length = 25)
    private String nomfamille;
    @Basic
    @Column(name = "COURRIEL", nullable = false, length = 50)
    private String courriel;
    @Basic
    @Column(name = "TELEPHONE", nullable = false, length = 12)
    private String telephone;
    @Basic
    @Column(name = "MOTDEPASSE", nullable = false, length = 15)
    private String motdepasse;
    @Basic
    @Column(name = "DATEDENAISSANCE", nullable = false)
    private Date datedenaissance;
    @Basic
    @Column(name = "ADRESSE", nullable = false, length = 500)
    private String adresse;
    @OneToOne(mappedBy = "personne")
    private ClientEntity clients;

    public BigInteger getIdpersonne() {
        return idpersonne;
    }

    public void setIdpersonne(BigInteger idpersonne) {
        this.idpersonne = idpersonne;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNomfamille() {
        return nomfamille;
    }

    public void setNomfamille(String nomfamille) {
        this.nomfamille = nomfamille;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public ClientEntity getClients() {
        return clients;
    }

    public void setClients(ClientEntity clients) {
        this.clients = clients;
    }
}
