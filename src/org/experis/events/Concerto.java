package org.experis.events;

import exceptions.EventoException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

    public class Concerto extends Evento {
        // attributi
        private LocalTime ora;
        private BigDecimal prezzo;

        // costruttori
        public Concerto(String titolo, LocalDate data, int numeroPostiTotali,LocalTime ora,BigDecimal prezzo) throws EventoException {
            super(titolo, data, numeroPostiTotali);
            if (getData().isEqual(LocalDate.now())) {
                if (ora.isBefore(LocalTime.now())) {
                    throw new EventoException("Non puoi programmare l'evento controlla che sia maggiore della data attuale!");
                }
            }
            if (prezzo.compareTo(BigDecimal.ZERO) < 0) {
                throw new EventoException("Il prezzo non può essere negativo");
            }
            this.ora = ora;
            this.prezzo = prezzo;
        }

        // getter e setter

        public LocalTime getOra() {
            return ora;
        }

        public void setOra(LocalTime ora) throws EventoException {
            if (getData().isEqual(LocalDate.now())) {
                if (ora.isBefore(LocalTime.now())) {
                    throw new EventoException("Non puoi programmare l'evento controlla che sia maggiore della data attuale!");
                }
            }
            this.ora = ora;
        }

        public BigDecimal getPrezzo() {
            return prezzo.setScale(2, RoundingMode.HALF_UP);
        }

        public void setPrezzo(BigDecimal prezzo) throws EventoException{
            if (prezzo.compareTo(BigDecimal.ZERO) < 0) {
                throw new EventoException("Il prezzo non può essere negativo");
            }
            this.prezzo = prezzo;
        }


        // metodi
        public String formattaDataOra(){
            return formattaData(getData()) + " ore:" + getOra();
        }

        @Override
        public String toString() {
            return formattaDataOra() + " - " + getTitolo() + " - " + getPrezzo()+"€" ;
        }
    }
