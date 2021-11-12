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
public class ListaPartidas {
    private int count;
    private int max;
    private Partida[] list;
    
    public ListaPartidas(int max){
        this.max = max;
        count = 0;
        list = new Partida[max];
    }
    public int getCant(){ return count;}
    public boolean agregarPartida(Partida j){
        if (count<max){
            list[count] = j;
            count++;
            return true;
        }
        return false;
    }
    
    public Partida buscarPartida(String nombreUsuario, String nombreJuego){
        for (int i = 0; i < count; i++) {
            if (list[i].getJugador().getNombreUsuario().equals(nombreUsuario) && list[i].getJuego().getNombre().equals(nombreJuego)){
                return list[i];
            }
        }
        return null;
    }
    
    public Partida getPartidaI(int i){
        if (i<count) return list[i];
        return null;
    }
    /**
     * text es nombreJuego
     * text2 es nombreJugador
     * @param text
     * @param text2
     * @return 
     */
    public boolean eliminarPartida(String text,String text2){
        int i = 0;
        while(i < count && !list[i].getJuego().getNombre().equals(text) && !list[i].getJugador().getNombreUsuario().equals(text2)) {
            i++;
        }
        
        if(i == count) {
            //No esta la partida en la lista
            return false;
        }
        else {
            //Corrimiento
            for(int k = i; k < count-1; k++) {
                list[k]=list[k+1];
            }
            count--;
            return true;
        }
    }


}
