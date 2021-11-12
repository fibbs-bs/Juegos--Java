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
public class ListaJuegos {
    private int count;
    private int max;
    private Juego[] list;
    
    public ListaJuegos(int max){
        this.max = max;
        count = 0;
        list = new Juego[max];
    }
    
    public boolean agregarJuego(Juego j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    public int getCant(){ return count;}
    public Juego buscarJuego(String nombreJuego){
        for (int i = 0; i < count; i++) {
            if (list[i].getNombre().equals(nombreJuego)){
                return list[i];
            }
        }
        return null;
    }
    
    public Juego getJuegoI(int i){
        if (i<count) return list[i];
        return null;
    }

    public void ordenar() {
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < count-1; j++) {
                if (list[j].getVecesJugado()< list[j+1].getVecesJugado()){
                    Juego aux = list[j];
                    list[j] = list[j+1];
                    list[j+1] = aux;
                }
            }
        }
    }
}
