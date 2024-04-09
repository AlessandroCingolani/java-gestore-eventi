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
        if (data == null || data.isBefore(LocalDate.now())){
            throw new EventoException("La data non può essere nulla o minore della data attuale!");
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
        if (data == null || data.isBefore(LocalDate.now())){
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
//    public void prenota(int numeroPostiPrenotati){
//        if()
//
//    }
//
//    public void  disdici(){
//
//    }

    private String formattaData(LocalDate data){
        DateTimeFormatter formatoItaliano = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALIAN);
        return data.format(formatoItaliano);
    }

    @Override
    public String toString() {
        return formattaData(getData());
    }
}
