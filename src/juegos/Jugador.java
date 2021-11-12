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
public class Jugador {
    private String nombreUsuario;
    private int fichas;
    private int vecesJugadas;
    private ListaPartidas lp;
    
    public Jugador(String nombre, int fichas){
        nombreUsuario = nombre;
        this.fichas = fichas;
        vecesJugadas = 0;
        lp = new ListaPartidas(1000);
    }
    
    public ListaPartidas getPartidas(){
        return lp;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public int getVecesJugadas() {
        return vecesJugadas;
    }

    public void setVecesJugadas(int vecesJugadas) {
        this.vecesJugadas = vecesJugadas;
    }
    
}
