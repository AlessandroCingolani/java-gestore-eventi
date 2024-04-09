package org.experis.events;

import exceptions.EventoException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Evento evento = null;
        // flag choice  prenotazioni
        boolean flagPrenotazioni = false;
        boolean flagDisdette = false;
        do {
            System.out.println("========================================================");
            System.out.println("Inserisci i seguenti dati per aggiungere un nuovo evento");
            System.out.print("Titolo:");
            String title = scan.nextLine();
            System.out.print("Data con yyyy-mm-gg:");
            String date = scan.nextLine();
            int totalSeat = 0;
            try {
                System.out.print("Numero di posti che può ospitare l'evento:");
                totalSeat = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero maggiore di 0");
            }
            try {
                evento = new Evento(title,date,totalSeat);
                System.out.println(evento);
            } catch (EventoException e) {
                System.out.println(e);
            }
        }while(evento == null);

        // prenotazioni
        prenotazioni(evento, scan, flagPrenotazioni);

        // disdette
        disdette(evento, scan, flagDisdette);


        scan.close();

    }

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
        }while(!flagPrenotazioni);
    }

    private static void disdette(Evento evento, Scanner scan, boolean flagDisdette) {
        do {
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
        }while(!flagDisdette);
    }

    private static String seatPrint(int prenotati ,int disponibili){
        return "Posti prenotati: "+ prenotati + "\t" + "Posti disponibili:" + disponibili;
    }

}
