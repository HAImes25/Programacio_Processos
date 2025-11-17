package Ejercicio2;

public class Contador {
    private int valor =0;
    // Este metodo es synchronized asi que no habran problemas con los hilos 
    public synchronized void inc(){
        valor++;
    }
    public int getValor(){return valor;}



}
