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
public interface SistemaJuegos {
    /**
     * This method create a game in the system.
     * @param nombre
     * @return a true if the method was succesfull
     */
    public boolean añadirJuego(String nombre);
    public boolean añadirJugador(String nombre, int fichas);
    /**
     * En este método crearemos una partida y la asociaremos a sus respecticas referencias (Jugador y Juego).
     */
    public void añadirPartida(String nombreJuego,String nombreJugador,int puntaje);
    
    public String obtenerEstadisticasJugadores();
    public String obtenerJugadorConMasPartidas();
    /**
     * Retornará un string con el nombre del juego y la cantidad de veces jugado
     * @return 
     */
    public String obtenerJuegoMasJugador();
    public String porcentajes();
    public void eliminacion(String text,String nombreJugador);
    public String ordenamientoPartidas();
    public String ordenamientoJuegos();
    public void jugarMultijugador();
    public String obtenerGanadorPartidaMultijugador();
    public void jugarLaConsentida();
}
