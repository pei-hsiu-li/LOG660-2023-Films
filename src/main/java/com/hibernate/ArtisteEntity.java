package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "ARTISTE", schema = "EQUIPE112", catalog = "")
public class ArtisteEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDARTISTE", nullable = false, precision = 0)
    private BigInteger idartiste;
    @Basic
    @Column(name = "NOM", nullable = true, length = 30)
    private String nom;
    @Basic
    @Column(name = "PRENOM", nullable = true, length = 30)
    private String prenom;
    @Basic
    @Column(name = "PHOTO", nullable = true, length = 250)
    private String photo;
    @Basic
    @Column(name = "DATEDENAISSANCE", nullable = true)
    private Date datedenaissance;
    @Basic
    @Column(name = "BIOGRAPHIE", nullable = true)
    private String biographie;
    @Basic
    @Column(name = "LIEUNAISSANCE", nullable = true, length = 150)
    private String lieunaissance;

    @OneToMany(mappedBy = "artiste")
    private Collection<FilmartisteEntity> contrats;

    public BigInteger getIdartiste() {
        return idartiste;
    }

    public void setIdartiste(BigInteger idartiste) {
        this.idartiste = idartiste;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDatedenaissance() {
        return datedenaissance;
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public String getLieunaissance() {
        return lieunaissance;
    }

    public void setLieunaissance(String lieunaissance) {
        this.lieunaissance = lieunaissance;
    }

    public Collection<FilmartisteEntity> getContrats() {
        return contrats;
    }

    public void setContrats(Collection<FilmartisteEntity> contrats) {
        this.contrats = contrats;
    }

}
