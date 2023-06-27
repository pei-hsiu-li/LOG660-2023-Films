package com.gui;

public class GetFilmNameSingleton {
    private static String film;

    public static String getFilm() {
        return film;
    }

    public static void setFilm(String film) {
        GetFilmNameSingleton.film = film;
    }
}
