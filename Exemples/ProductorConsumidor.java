import java.io.IOException;
import java.util.LinkedList;

/**
 * Exemple bàsic del patró Productor–Consumidor
 * utilitzant els mètodes wait() i notifyAll().
 *
 * @author jass_
 * 
 */
public class ProductorConsumidor {

    // Llista compartida entre productor i consumidor
    // Actua com una "cua" on el productor posa elements i el consumidor els treu.
    protected LinkedList<Object> lista = new LinkedList<>();

    // ---------------------- PRODUCIR ----------------------
    protected void producir() {
        int cantidadElementos = 0;
        // Bloque sincronitzat: només un fil pot entrar a la vegada.
        //Bloquea el objeto lista → solo un hilo puede acceder al bloque a la vez.
        //Te da permiso para usar métodos que gestionan el monitor (wait(), notify(), etc.).
        //Evita condiciones de carrera (que dos hilos modifiquen lista a la vez).
        synchronized (lista) {
            // Creem un nou objecte per afegir a la llista (el producte).
            System.out.println("→ Entrando a producir()");
            Object nuevoElemento = new Object();
            lista.addFirst(nuevoElemento); // afegim al principi de la cua
            cantidadElementos = lista.size(); // guardem la quantitat actual

            // notifyAll() desperta els fils que estan esperant (consumidors)
            // perquè hi ha un nou producte disponible.
            lista.notifyAll();
            System.out.println("→ Saliendo de producir()");
        }

        System.out.println("Cantidad de elementos después de la producción: " + cantidadElementos);
    }

    // ---------------------- CONSUMIR ----------------------
    protected void consumir() {
        Object elemento = null;
        int cantidadElementos = 0;

        // Bloque sincronitzat per garantir accés segur a la llista
        synchronized (lista) {
            // Mentre la llista estigui buida, el consumidor espera.
            while (lista.size() == 0) {
                try {
                    // wait() deixa el monitor i posa el fil en pausa fins que algú faci notifyAll()
                    lista.wait();
                } catch (InterruptedException e) {
                    return; // si el fil és interromput, surt del mètode
                }
            }
            System.out.println("→ Entrando a consumir()");
            // Quan ja hi ha elements, en treu un (per la cua, FIFO)
            elemento = lista.removeLast();
            cantidadElementos = lista.size();
            System.out.println("→ Saliendo de consumir()");
        }

        // Mostra per pantalla quin element s'ha tret i quants queden
        System.out.println("Elemento extraído de la lista: " + elemento);
        System.out.println("Cantidad de elementos después del consumo: " + cantidadElementos);
    }

    // ---------------------- MAIN ----------------------
    public static void main(String[] args) throws IOException {
        ProductorConsumidor pc = new ProductorConsumidor();

        System.out.println("Presione p para producir o c para consumir:");
        int codigoCaracter;

        // Llegeix caràcter a caràcter del teclat
        while ((codigoCaracter = System.in.read()) != -1) {
            char caracter = (char) codigoCaracter;

            switch (caracter) {
                case 'p':
                    pc.producir(); // si l’usuari escriu ‘p’, produeix (afegeix)
                    break;
                case 'c':
                    pc.consumir(); // si escriu ‘c’, consumeix (treu)
                    break;
            }
        }
    }
}
