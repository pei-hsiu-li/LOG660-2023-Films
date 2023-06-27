package com.hibernate;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "PAYS", schema = "EQUIPE112", catalog = "")
public class PaysEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "PAYS", nullable = false, length = 50)
    private String pays;
    @ManyToMany(mappedBy = "pays")
    private Collection<FilmEntity> films;

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Collection<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }
}
