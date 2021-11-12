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
public class LaConsentida {
    private String nombre = "La Consentida";
    private JugadorConsentida jugadorA;
    private JugadorConsentida jugadorB;
    private JugadorConsentida ganador;
    
    public LaConsentida(){
        jugadorA = null;
        jugadorB = null;
        ganador = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JugadorConsentida getJugadorA() {
        return jugadorA;
    }

    public void setJugadorA(JugadorConsentida jugadorA) {
        this.jugadorA = jugadorA;
    }

    public JugadorConsentida getJugadorB() {
        return jugadorB;
    }

    public void setJugadorB(JugadorConsentida jugadorB) {
        this.jugadorB = jugadorB;
    }

    public JugadorConsentida getGanador() {
        return ganador;
    }

    public void setGanador(JugadorConsentida ganador) {
        this.ganador = ganador;
    }
    
}
