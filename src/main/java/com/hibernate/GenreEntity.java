package com.hibernate;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "GENRE", schema = "EQUIPE112", catalog = "")
public class GenreEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "GENRE", nullable = false, length = 20)
    private String genre;
    @ManyToMany(mappedBy = "genres")
    private Collection<FilmEntity> films;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Collection<FilmEntity> getFilms() {
        return films;
    }

    public void setFilms(Collection<FilmEntity> films) {
        this.films = films;
    }
}
