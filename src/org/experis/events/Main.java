package org.experis.events;

import exceptions.EventoException;

public class Main {
    public static void main(String[] args) {

        Evento evento = null;
        try {
            evento = new Evento("Ciao","2024-11-23",1000);
        } catch (EventoException e) {
            System.out.println(e);
        }

        System.out.println(evento.getNumeroPostiTotali());

        try {
            evento.prenota(500);
            evento.disdici(501);
        } catch (EventoException e) {
            System.out.println(e);
        }

        System.out.println(evento.getNumeroPostiPrenotati());
    }
}
