/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jhona
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        SistemaJuegos sys = new SistemaJuegosImpl();
        lecturaJuegos(sys);
        lecturaJugadores(sys);
        lecturaPartidas(sys);
        menu(sys);
    }

    public static void lecturaJuegos(SistemaJuegos sys) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("juegos.txt"));
        while(scan.hasNextLine()){
            String nombre = scan.nextLine();
            if (!sys.añadirJuego(nombre)){
                System.out.println("No pueden existir mas juegos dentro del sistema!");
            }
        }
    }

    private static void lecturaJugadores(SistemaJuegos sys) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("jugadores.txt"));
        while (scan.hasNextLine()){
            String[] partes = scan.nextLine().split(",");
            String nombre = partes[0];
            int fichas = Integer.parseInt(partes[1]);
            if (!sys.añadirJugador(nombre, fichas)){
                System.out.println("No pueden existir mas juegadores dentro del sistema!");
            }
        }
    }

    private static void lecturaPartidas(SistemaJuegos sys) throws FileNotFoundException {
        Scanner scan = new Scanner(new File("partidas.txt"));
        while (scan.hasNextLine()){
            String [] partes = scan.nextLine().split(",");
            String nombreJugador = partes[0];
            String nombreJuego = partes[1];
            int puntaje = Integer.parseInt(partes[2]);
            try{
                sys.añadirPartida(nombreJuego, nombreJugador, puntaje);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static void menu(SistemaJuegos sys) {
        System.out.println("-------Estadísticas de jugadores------");
        System.out.println(sys.obtenerEstadisticasJugadores());
        System.out.println("-------Jugador con mas partidas ------");
        System.out.println(sys.obtenerJugadorConMasPartidas());
        System.out.println("-------Juego mas jugado         ------");
        System.out.println(sys.obtenerJuegoMasJugador());
        System.out.println("---------------------------------------");
        System.out.println(sys.ordenamientoPartidas());
        System.out.println("---------------------------------------");
        System.out.println(sys.ordenamientoJuegos());
        System.out.println("---------------------------------------");
        try {
            sys.jugarMultijugador();
            System.out.println("-------Jugador ganador Multi    -------");
            System.out.println(sys.obtenerGanadorPartidaMultijugador());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-------La Consentida ------------------");
        try {
            sys.iniciarLaConsentida();
            Scanner scan = new Scanner(System.in);
            System.out.println("JugadorA! ingresa tu valor: ");
            int valorA = Integer.parseInt(scan.nextLine()) ;
            System.out.println("JugadorB! ingresa tu valor: ");
            int valorB = Integer.parseInt(scan.nextLine()) ;
            for (int i = 0; i < 5; i++) {
                System.out.println("Iteración de 'La Consentida' N°"+(i+1));
                System.out.println(sys.jugarLaConsentida(valorA, valorB));
                System.out.println("JugadorA! ingresa tu valor: ");
                valorA = Integer.parseInt(scan.nextLine()) ;
                System.out.println("JugadorB! ingresa tu valor: ");
                valorB = Integer.parseInt(scan.nextLine()) ;
            }
            System.out.println(sys.terminarLaConsentida());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
}
