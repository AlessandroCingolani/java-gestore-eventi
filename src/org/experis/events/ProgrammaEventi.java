package org.experis.events;

import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {
    //attributi
    private String titolo;
    List<Evento> eventi;

    // costruttore

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        eventi = new ArrayList<>();
    }

    // getter
    public String getTitolo() {
        return titolo;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    // metodi
    public void  addEvento(Evento evento){
       eventi.add(evento);
    }

//    public List<Evento> filterData(List eventi)

    @Override
    public String toString() {
        return "ProgrammaEventi{" +
                "titolo='" + titolo + '\'' +
                ", eventi=" + eventi +
                '}';
    }
}
