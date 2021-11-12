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
public class Juego {
    private String nombre;
    private int vecesJugado;
    private ListaPartidas lp;
    
    public Juego(String nombre){
        this.nombre = nombre;
        vecesJugado = 0;
        lp = new ListaPartidas(1000);
    }

    public ListaPartidas getPartidas(){
        return lp;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVecesJugado() {
        return vecesJugado;
    }

    public void setVecesJugado(int vecesJugado) {
        this.vecesJugado = vecesJugado;
    }
    
}
