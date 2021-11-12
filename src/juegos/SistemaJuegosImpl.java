/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import java.util.Scanner;

/**
 *
 * @author jhona
 */
public class SistemaJuegosImpl implements SistemaJuegos{

    private ListaJuegos juegos;
    private ListaJugador jugadores;
    private ListaPartidas partidas;
    private PartidaMultijugador multi;
    private LaConsentida consentida;
    
    public SistemaJuegosImpl(){
        juegos = new ListaJuegos(1000);
        jugadores = new ListaJugador(1000);
        partidas = new ListaPartidas(1000);
        multi = new PartidaMultijugador();
        consentida = new LaConsentida();
    }
    
    @Override
    public boolean añadirJuego(String nombre) {
        Juego j = new Juego(nombre);
        return juegos.agregarJuego(j);
    }

    @Override
    public boolean añadirJugador(String nombre, int fichas) {
        Jugador j = new Jugador(nombre, fichas);
        return jugadores.agregarJugador(j);
    }

    @Override
    public void añadirPartida(String nombreJuego, String nombreJugador, int puntaje) {
        Jugador jugador = jugadores.buscarJugador(nombreJugador); //puede retornar nulo
        Juego juego = juegos.buscarJuego(nombreJuego); //puede retornar nulo
        if (jugador!=null && juego!=null){
            Partida partida = new Partida(puntaje);
            if (jugador.getFichas()==0){
                throw new NullPointerException("El jugador no tiene fichas para jugar!");
            }else{
                jugador.setFichas(jugador.getFichas() -1);
                if (jugador.getPartidas().agregarPartida(partida)){
                    if (juego.getPartidas().agregarPartida(partida)){
                        if (partidas.agregarPartida(partida)){
                            partida.setJuego(juego);
                            partida.setJugador(jugador);
                            juego.setVecesJugado(juego.getVecesJugado()+1);
                            jugador.setVecesJugadas(jugador.getVecesJugadas()+1);
                        }
                        else{
                            throw new NullPointerException("La partida no puede ser jugada!");
                        }
                    }
                    else{
                        throw new NullPointerException("El juego no puede ser jugado!");
                    }
                }
                else{
                    throw new NullPointerException("El jugador no puede jugar mas partidas!");
                }
            }
        }
        else{
            throw new NullPointerException("El jugador o el juego no existen! ("+nombreJuego+","+nombreJugador+")");
        }
    }

    @Override
    public String obtenerEstadisticasJugadores() {
        String text = "";
        for (int i = 0; i < jugadores.getCant(); i++) {
            Jugador j = jugadores.getJugadorI(i);
            text += j.getNombreUsuario()+" | "+j.getFichas()+" | veces jugado: "+j.getVecesJugadas()+"\n";
            for (int k = 0; k < j.getPartidas().getCant(); k++) {
                Partida p = j.getPartidas().getPartidaI(k);
                text+= "\tPartida:"+p.getJuego().getNombre()+" | Puntaje:"+p.getPuntaje()+"\n";
            }
        }
        return text;
    }

    @Override
    public String obtenerJugadorConMasPartidas() {
        int mayor = -1;
        Jugador m = null;
        for (int i = 0; i < jugadores.getCant(); i++) {
            Jugador j = jugadores.getJugadorI(i);
            if (j.getVecesJugadas()>mayor){
                mayor = j.getVecesJugadas();
                m = j;
            }
        }
        return m.getNombreUsuario();
    }

    @Override
    public String obtenerJuegoMasJugador() {
        int mayor = -1;
        Juego m = null;
        for (int i = 0; i < juegos.getCant(); i++) {
            Juego j = juegos.getJuegoI(i);
            if (j.getVecesJugado()>mayor){
                mayor = j.getVecesJugado();
                m = j;
            }
        }
        return m.getNombre();
    }

    @Override
    public String porcentajes() {
        String text = "";
        int total = partidas.getCant();
        for (int i = 0; i < juegos.getCant(); i++) {
            Juego j = juegos.getJuegoI(i);
            text+= j.getNombre()+" "+j.getVecesJugado()+" "+(float)(j.getVecesJugado()*100/total)+"%\n";
        }
        return text;
    }

    @Override
    public void eliminacion(String nombreJuego,String nombreJugador) {
        Partida p = partidas.buscarPartida(nombreJuego, nombreJugador);
        if (p==null){
            throw new NullPointerException("Esta partida no existe");
        }
        else{
            if (!partidas.eliminarPartida(nombreJuego, nombreJugador)){
                throw new NullPointerException("Esta partida no puedo ser eliminada!");
            }
        }
    }

    @Override
    public String ordenamientoPartidas() {
        jugadores.ordenar();
        String text = "";
        for (int i = 0; i < jugadores.getCant(); i++) {
            text+=jugadores.getJugadorI(i).getNombreUsuario()+","+jugadores.getJugadorI(i).getVecesJugadas();
            text+="\n";
        }
        return text;
    }

    @Override
    public void jugarMultijugador() {
        try {
            Jugador ganador = null;
            Jugador masJugadas = jugadores.getJugadorI(0);
            Jugador segundoMenosJugadas = jugadores.getJugadorI(jugadores.getCant()-2);
            Juego juego = juegos.getJuegoI(juegos.getCant()-1);
            multi.setJuego(juego);
            multi.setJugadorA(masJugadas);
            multi.setJugadorB(segundoMenosJugadas);
            Partida pMasJugadas =masJugadas.getPartidas().buscarPartida(masJugadas.getNombreUsuario(), juego.getNombre());
            Partida pSegundoMenosJugada = segundoMenosJugadas.getPartidas().buscarPartida(segundoMenosJugadas.getNombreUsuario(),juego.getNombre());
            if (pMasJugadas==null || pSegundoMenosJugada==null){
                if (masJugadas.getFichas()<segundoMenosJugadas.getFichas()){
                    ganador = masJugadas;
                }
                else{
                    ganador = segundoMenosJugadas;
                }
            }
            else{
                if (pMasJugadas.getPuntaje()>pSegundoMenosJugada.getPuntaje()){
                    ganador = masJugadas;
                }
                else{
                    ganador = segundoMenosJugadas;
                }
            }
            multi.setGanador(ganador);
        } catch (Exception e) {
            throw new NullPointerException("Existen algún error en el sistema!");
        }
        
    }

    @Override
    public String ordenamientoJuegos() {
        juegos.ordenar();
        String text = "";
        for (int i = 0; i < juegos.getCant(); i++) {
            text+=juegos.getJuegoI(i).getNombre()+","+juegos.getJuegoI(i).getVecesJugado();
            text+="\n";
        }
        return text;
    }

    @Override
    public String obtenerGanadorPartidaMultijugador() {
        Jugador j = multi.getGanador();
        return "Nombre:"+j.getNombreUsuario()+", Veces jugado:"+j.getVecesJugadas()+", Fichas: "+j.getFichas();
    }

    @Override
    public void iniciarLaConsentida() {
        try {
            int mediana = jugadores.getCant()/2;
            JugadorConsentida jugadorConsentidoA = new JugadorConsentida(1000);
            Jugador jugadorA = jugadores.getJugadorI(mediana); //Este será el jugador en la mediana del sistema!
            jugadorConsentidoA.setJugador(jugadorA);
            JugadorConsentida jugadorConsentidoB = new JugadorConsentida(1000);
            Jugador jugadorB = jugadores.getJugadorI(1); //Este será el segundo jugador con mas partidas del sistema!
            jugadorConsentidoB.setJugador(jugadorB);
            consentida.setJugadorA(jugadorConsentidoA);
            consentida.setJugadorB(jugadorConsentidoB);
        } catch (Exception e) {
            throw new NullPointerException("'La Consentida' ha fallado en su iniciación!");
        }
        
    }
    
}
