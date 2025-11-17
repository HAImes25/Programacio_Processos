package Hilos_Par_Inpar;
public class HiloPar extends Thread{
    // El constructor pide el nombre
    public HiloPar(String name) {
        super(name);
    }

    @Override
    public void run() {
        // mostrar los numeros pares del 1 al 20
        for (int i = 2; i <= 20; i += 2) {
            //System.out.println(getName() + i);
            System.out.println(Thread.currentThread().getName() + "Soy el proceso " + (i));
        }

    }
}
