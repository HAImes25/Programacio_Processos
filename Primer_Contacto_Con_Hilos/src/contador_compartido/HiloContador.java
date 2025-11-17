
package contador_compartido;

public class HiloContador extends Thread {

    int contador = 0;

    public HiloContador(String name, int contador) {
        super(name);
        this.contador = contador;
    }

    @Override
    public void run() {
        suma1();
//        for (int i = 0; i < 1000; i++) {
//            i++;
//            System.out.println(getName() + "dd" + i);
//
//        }
        
    }
    public void suma1() {

        contador++;

    }
}
