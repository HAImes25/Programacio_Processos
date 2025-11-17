package contador_compartido;

public class main {
    public static void main(String[] args) {

        int contador = 0;

        HiloContador h1 = new HiloContador("H1", contador);
        HiloContador h2 = new HiloContador("H2", contador);

        h1.start();
        h2.start();
        h1.suma1();


        System.out.println("El contador es: " + contador);





    }
}
