import java.io.*;    // Clases de entrada/salida: BufferedReader, InputStreamReader, PrintWriter...
import java.net.*;   // Clases de red: ServerSocket, Socket...

public class ServidorTCP {
    public static void main(String[] args) throws IOException {

        // Puerto donde el servidor va a "escuchar".
        // Debe coincidir con el puerto al que se conecta el cliente.
        int puerto = 5000;

        // Creamos un ServerSocket: abre el puerto y se queda LISTENING (escuchando).
        // Si el puerto está ocupado, aquí saltará error (Address already in use).
        ServerSocket server = new ServerSocket(puerto);

        // Mensaje informativo para ver que el servidor está listo.
        System.out.println("Servidor escuchando en puerto " + puerto);

        // accept() BLOQUEA: el programa se queda esperando hasta que un cliente se conecte.
        // Cuando alguien se conecta, devuelve un Socket "cliente" para hablar con ese cliente.
        Socket cliente = server.accept(); // espera a que se conecte un cliente

        // Mostramos la IP del cliente que se conectó.
        System.out.println("Cliente conectado: " + cliente.getInetAddress());

        // Stream de entrada: lo que el cliente envía hacia el servidor.
        // Convertimos bytes -> texto y leemos por líneas con readLine().
        BufferedReader in = new BufferedReader(
                new InputStreamReader(cliente.getInputStream())
        );

        // Stream de salida: lo que el servidor envía hacia el cliente.
        // autoFlush=true para que cada println se envíe al momento.
        PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);
        String msg;

        // readLine() devuelve null si la conexión se cierra inesperadamente,
        // por eso comprobamos != null además del "bye".
        while ((msg = in.readLine()) != null) {
            if (msg.toLowerCase().equals("bye")) {
                out.println("bye");
                break;
            }

            // Respondemos al cliente con un "eco" del mensaje recibido.
            out.println("Eco: " + msg); // responde
        }

        // Cerramos la conexión con ese cliente (su socket).
        cliente.close();

        // Cerramos el ServerSocket (deja de escuchar en el puerto).
        // En este ejemplo el servidor solo acepta 1 cliente y se apaga.
        server.close();
    }
}