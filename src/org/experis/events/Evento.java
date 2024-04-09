package org.experis.events;

import java.time.LocalDate;

public abstract class Evento {
    // attributi
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;


    // costruttori
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) {
        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        numeroPostiPrenotati = 0;
    }



    // getter e setter


    // metodi
}
