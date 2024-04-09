package org.experis.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammaEventi{
    //attributi
    private String titolo;
    private List<Evento> eventi;

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

    public List<Evento> filterData(LocalDate data) {
        return this.eventi.stream().filter(e -> e.getData().equals(data)).collect(Collectors.toList());
    }

    public Integer arraySize(){
       return this.eventi.size();
    }

    public void clearArray(){
        this.eventi.clear();
    }

    @Override
    public String toString() {
        return "ProgrammaEventi{" +
                "titolo='" + titolo + '\'' +
                ", eventi=" + eventi +
                '}';
    }


    // con lambda
    public String ordinaPerData() {
        return this.eventi.stream()
                 .sorted(Comparator.comparing(Evento::getData))
                  .map(e -> e.getData() + " - " + e.getTitolo())
                 .collect(Collectors.joining("\n"));
    }

}
