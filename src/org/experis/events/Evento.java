package org.experis.events;

import exceptions.EventoException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public  class Evento {
    // Attributi
    private String titolo;
    private LocalDate data;
    private int numeroPostiTotali;
    private int numeroPostiPrenotati;


    // Costruttori
    public Evento(String titolo, LocalDate data, int numeroPostiTotali) throws EventoException {
        if(titolo == null || titolo.isEmpty()) {
            throw new EventoException("Il titolo non può essere nullo o vuoto!");
        }

        if (data.isBefore(LocalDate.now())){
            throw new EventoException("La data non può essere minore della data attuale!");
        }
        if(numeroPostiTotali <= 0){
            throw new EventoException("Il numero dei posti totali deve essere maggiore di 0!");
        }

        this.titolo = titolo;
        this.data = data;
        this.numeroPostiTotali = numeroPostiTotali;
        numeroPostiPrenotati = 0;
    }



    // Getter e Setter

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) throws EventoException{
        if(titolo == null || titolo.isEmpty()) {
            throw new EventoException("Il titolo non può essere nullo o vuoto!");
        }
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) throws EventoException {
        if (data.isBefore(LocalDate.now())){
            throw new EventoException("La data non può essere nulla o minore della data attuale!");
        }
        this.data = data;

    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }


    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }


    // Metodi
    public void prenota(int prenota) throws EventoException{
        if(prenota > postiDisponibili() || this.data.isBefore(LocalDate.now()) || prenota < 0){
            throw new EventoException("Non puoi prenotare controlla data evento e posti disponibili!");
        }
        this.numeroPostiPrenotati += prenota;
    }

    public void  disdici(int disdici) throws EventoException {
        if(disdici > getNumeroPostiPrenotati() || this.data.isBefore(LocalDate.now()) || disdici < 0){
            throw new EventoException("Non puoi disdire controlla data evento e posti prenotati!");
        }
        this.numeroPostiPrenotati -= disdici;
    }

    public int postiDisponibili(){
        return getNumeroPostiTotali() - getNumeroPostiPrenotati();
    }

    private String formattaData(LocalDate data){
        DateTimeFormatter formatoItaliano = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);
        return data.format(formatoItaliano);
    }

    @Override
    public String toString() {
        return formattaData(getData()) + " - " + getTitolo();
    }
}
