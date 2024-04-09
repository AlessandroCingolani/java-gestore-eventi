package org.experis.events;

import exceptions.EventoException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Evento evento = null;
        LocalDate data = null;
        // flag choice  prenotazioni
        boolean flagPrenotazioni = false;
        boolean flagDisdette = false;


        // tested concerto
//        Concerto concerto = null;
//        try {
//             concerto = new Concerto("ciao",LocalDate.parse("2024-11-12"),1000, LocalTime.parse("10:50"),new BigDecimal("12"));
//        } catch (EventoException e) {
//            System.out.println(e);
//        }
//
//        System.out.println(concerto);

        do {
            System.out.println("========================================================");
            System.out.println("Inserisci i seguenti dati per aggiungere un nuovo evento");
            System.out.print("Titolo:");
            String title = scan.nextLine();
            do {
                try {
                    System.out.print("Data con yyyy-mm-gg:");
                    data = LocalDate.parse(scan.nextLine());
                } catch (Exception e) {
                    System.out.println("Errore inserisci il data giusto");
                }

            }while(data == null);

            int totalSeat = 0;
            try {
                System.out.print("Numero di posti che può ospitare l'evento:");
                totalSeat = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero maggiore di 0");
            }
            try {
                evento = new Evento(title,data,totalSeat);
                System.out.println(evento);
            } catch (EventoException e) {
                System.out.println(e);
            }
        }while(evento == null);

        // prenotazioni
        prenotazioni(evento, scan, flagPrenotazioni);

        // disdette
        disdette(evento, scan, flagDisdette);


        System.out.println("===================================================");
        System.out.println(seatPrint(evento.getNumeroPostiPrenotati(), evento.postiDisponibili()));
        System.out.println("===================================================");

        scan.close();

    }


    // metodi static
    private static void prenotazioni(Evento evento, Scanner scan, boolean flagPrenotazioni) {
        do {
            System.out.println("===================================================");
            System.out.println(seatPrint(evento.getNumeroPostiPrenotati(), evento.postiDisponibili()));
            System.out.println("===================================================");
            System.out.print("Vuoi effettuare delle prenotazioni? y/n: ");

            String choice = scan.nextLine().toLowerCase();
            switch (choice){
                case "y":
                    // aggiungi
                    System.out.print("Quante posti da prenotare:");
                    int prenotazioni = Integer.parseInt(scan.nextLine());
                    try {
                        evento.prenota(prenotazioni);
                    } catch (EventoException e) {
                        System.out.println(e);
                    }
                    break;
                case "n":
                    flagPrenotazioni = true;
                    break;
                default:
                    System.out.println("Inserisci opzione valida!");
                    break;
            }
        }while(!flagPrenotazioni && evento.postiDisponibili() > 0);
    }

    private static void disdette(Evento evento, Scanner scan, boolean flagDisdette) {
        while(!flagDisdette && evento.getNumeroPostiPrenotati() > 0){
            System.out.println("===================================================");
            System.out.println(seatPrint(evento.getNumeroPostiPrenotati(), evento.postiDisponibili()));
            System.out.println("===================================================");
            System.out.print("Vuoi disdire delle prenotazioni? y/n: ");

            String choice = scan.nextLine().toLowerCase();
            switch (choice){
                case "y":
                    // disdici
                    System.out.print("Quante posti da disdire:");
                    int disdette = Integer.parseInt(scan.nextLine());
                    try {
                        evento.disdici(disdette);
                    } catch (EventoException e) {
                        System.out.println(e);
                    }
                    break;
                case "n":
                    flagDisdette = true;
                    break;
                default:
                    System.out.println("Inserisci opzione valida!");
                    break;
            }
        }

    };


    private static String seatPrint(int prenotati ,int disponibili){
        return "Posti prenotati: "+ prenotati + "\t" + "Posti disponibili:" + disponibili;
    }



}
