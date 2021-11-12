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
public class ListaJugador {
    private int count;
    private int max;
    private Jugador[] list;
    
    public ListaJugador(int max){
        this.max = max;
        count = 0;
        list = new Jugador[max];
    }
    public int getCant(){ return count;}
    public boolean agregarJugador(Jugador j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Jugador buscarJugador(String nombre){
        for (int i = 0; i < count; i++) {
            if (list[i].getNombreUsuario().equals(nombre)){
                return list[i];
            }
        }
        return null;
    }
    
    public Jugador getJugadorI(int i){
        if (i<count) return list[i];
        return null;
    }

    public void ordenar() {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count-1; j++) {
                if (list[j].getVecesJugadas() < list[j+1].getVecesJugadas()){
                    Jugador aux = list[j];
                    list[j] = list[j+1];
                    list[j+1] = aux;
                }
            }
        }
    }
}
