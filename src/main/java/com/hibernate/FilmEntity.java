package com.hibernate;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "FILM", schema = "EQUIPE112", catalog = "")
public class FilmEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "IDFILM", nullable = false, precision = 0)
    private BigInteger idfilm;
    @Basic
    @Column(name = "TITRE", nullable = true, length = 100)
    private String titre;
    @Basic
    @Column(name = "ANNEESORTIE", nullable = true, precision = 0)
    private Short anneesortie;
    @Basic
    @Column(name = "LANGUE", nullable = true, length = 25)
    private String langue;
    @Basic
    @Column(name = "DUREE", nullable = true, precision = 0)
    private BigInteger duree;
    @Basic
    @Column(name = "RESUME", nullable = true)
    private String resume;
    @Basic
    @Column(name = "AFFICHE", nullable = true, length = 250)
    private String affiche;
    @Basic
    @Column(name = "NOMBRECOPYTOTAL", nullable = true, precision = 0)
    private BigInteger nombrecopytotal;
    @OneToMany(mappedBy = "film")
    private Collection<CopiephysiquefilmEntity> copiephysiquefilms;
    @OneToMany(mappedBy = "film")
    private Collection<FilmartisteEntity> roleArtistes;
    @OneToMany(mappedBy = "film")
    private Collection<BandeannonceEntity> bandeAnnonces;
    @ManyToMany
    @JoinTable(name = "FILMGENRE", catalog = "", schema = "EQUIPE112", joinColumns = @JoinColumn(name = "IDFILM", referencedColumnName = "IDFILM", nullable = false), inverseJoinColumns = @JoinColumn(name = "GENRE", referencedColumnName =
            "GENRE", nullable = false))
    private Collection<GenreEntity> genres;
    @ManyToMany
    @JoinTable(name = "FILMPAYS", catalog = "", schema = "EQUIPE112", joinColumns = @JoinColumn(name = "IDFILM", referencedColumnName = "IDFILM", nullable = false), inverseJoinColumns = @JoinColumn(name = "PAYS", referencedColumnName =
            "PAYS", nullable = false))
    private Collection<PaysEntity> pays;

    public BigInteger getIdfilm() {
        return idfilm;
    }

    public void setIdfilm(BigInteger idfilm) {
        this.idfilm = idfilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Short getAnneesortie() {
        return anneesortie;
    }

    public void setAnneesortie(Short anneesortie) {
        this.anneesortie = anneesortie;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public BigInteger getDuree() {
        return duree;
    }

    public void setDuree(BigInteger duree) {
        this.duree = duree;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public BigInteger getNombrecopytotal() {
        return nombrecopytotal;
    }

    public void setNombrecopytotal(BigInteger nombrecopytotal) {
        this.nombrecopytotal = nombrecopytotal;
    }

    public Collection<CopiephysiquefilmEntity> getCopiephysiquefilms() {
        return copiephysiquefilms;
    }

    public void setCopiephysiquefilms(Collection<CopiephysiquefilmEntity> copiephysiquefilms) {
        this.copiephysiquefilms = copiephysiquefilms;
    }

    public Collection<FilmartisteEntity> getRoleArtistes() {
        return roleArtistes;
    }

    public void setRoleArtistes(Collection<FilmartisteEntity> roleArtistes) {
        this.roleArtistes = roleArtistes;
    }

    public Collection<BandeannonceEntity> getBandeAnnonces() {
        return bandeAnnonces;
    }

    public void setBandeAnnonces(Collection<BandeannonceEntity> bandeAnnonces) {
        this.bandeAnnonces = bandeAnnonces;
    }

    public Collection<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Collection<GenreEntity> genres) {
        this.genres = genres;
    }

    public Collection<PaysEntity> getPays() {
        return pays;
    }

    public void setPays(Collection<PaysEntity> pays) {
        this.pays = pays;
    }
}
