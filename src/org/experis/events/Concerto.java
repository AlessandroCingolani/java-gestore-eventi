package org.experis.events;

import exceptions.EventoException;

import java.time.LocalDate;
import java.time.LocalTime;
// attributi


    // costruttori
    public class Concerto extends Evento {
        public Concerto(String titolo, LocalDate data, int numeroPostiTotali) throws EventoException {
            super(titolo, data, numeroPostiTotali);
        }
    // metodi
}
