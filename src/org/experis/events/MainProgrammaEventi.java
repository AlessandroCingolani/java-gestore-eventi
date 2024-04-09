package org.experis.events;

import exceptions.EventoException;

import java.time.LocalDate;
import java.util.List;

public class MainProgrammaEventi {
    public static void main(String[] args) {
        try {
            ProgrammaEventi list = new ProgrammaEventi("Ciao");
            list.addEvento(new Evento("ciao", LocalDate.parse("2024-11-12"),1000));
            System.out.println(list);
        } catch (EventoException e) {
            System.out.println(e);
        }
    }
}
