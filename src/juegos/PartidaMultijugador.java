/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

/**
 *
 * @author jhona
 */
public class PartidaMultijugador {
    private Juego juego;
    private Jugador jugadorA;
    private Jugador jugadorB;
    private Jugador ganador;
    
    public PartidaMultijugador(){
        juego = null;
        jugadorA = null;
        jugadorB = null;
        ganador = null;
    }

    public Juego getJuego() {
        //Hola que tal comoo estamo jaja
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Jugador getJugadorA() {
        return jugadorA;
    }

    public void setJugadorA(Jugador jugadorA) {
        this.jugadorA = jugadorA;
    }

    public Jugador getJugadorB() {
        return jugadorB;
    }

    public void setJugadorB(Jugador jugadorB) {
        this.jugadorB = jugadorB;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
}
