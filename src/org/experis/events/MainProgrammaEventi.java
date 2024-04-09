package org.experis.events;

import exceptions.EventoException;

import java.time.LocalDate;
import java.util.List;

public class MainProgrammaEventi {
    public static void main(String[] args) {
        ProgrammaEventi list = null;
        try {
            list = new ProgrammaEventi("Ciao");
            list.addEvento(new Evento("ciao", LocalDate.parse("2024-11-12"),1000));
            list.addEvento(new Evento("bella", LocalDate.parse("2024-11-11"),2000));
            list.addEvento(new Evento("asdrubbale", LocalDate.parse("2024-11-12"),2000));
            System.out.println(list);
        } catch (EventoException e) {
            System.out.println(e);
        }
        // filtraggio per data
        System.out.println(list.filterData( LocalDate.parse("2024-11-12")));

        // size array eventi
        System.out.println(list.arraySize());

        // svuoto array eventi

    }
}
