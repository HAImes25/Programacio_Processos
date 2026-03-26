import java.io.*;    // Clases para entrada/salida: BufferedReader, InputStreamReader, PrintWriter, etc.
import java.net.*;   // Clases de red: Socket, InetAddress, etc.
import java.util.Scanner;   // 🎹 Scanner para leer lo que escribe el usuario por teclado

public class ClienteTCP {
    public static void main(String[] args) throws IOException {
        // IP del servidor al que nos queremos conectar:
        // 127.0.0.1 = "localhost" = esta misma máquina
        String ip = "127.0.0.1";

        // Puerto donde el servidor está escuchando (debe coincidir con el del servidor)
        int puerto = 5000;

        // Crea el socket de cliente y se conecta a ip:puerto.
        // Si no hay servidor escuchando, aquí salta "Connection refused".
        Socket socket = new Socket(ip, puerto);

        // "Entrada" desde el servidor (lo que el servidor nos envía)
        // socket.getInputStream() da bytes; InputStreamReader convierte a texto;
        // BufferedReader permite leer por líneas con readLine().
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        // "Salida" hacia el servidor (lo que enviamos nosotros)
        // PrintWriter permite enviar texto fácilmente.
        // El 'true' activa autoFlush: cada println() se envía inmediatamente por la red.
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // System.in es la entrada estándar (el teclado).
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.print("Tú: ");
            String mensaje = teclado.nextLine();   // lee una línea completa del teclado

            // Enviamos una línea al servidor.
            // println añade '\n', importante si el servidor usa readLine() para leer.
            out.println(mensaje);

            // Leemos UNA línea de respuesta del servidor y la mostramos por consola.
            // Si el servidor no responde o no envía '\n', esto se queda esperando (bloqueado).
            String respuesta = in.readLine();
            System.out.println("Servidor: " + respuesta);
            // Lo comprobamos DESPUÉS de recibir la respuesta del servidor
            // para que le dé tiempo a mostrar el "bye" que responde el servidor.
            if (mensaje.equalsIgnoreCase("bye")) {
                break;
            }
        }

        // Cerramos el socket (cierra también los streams asociados).
        teclado.close();
        socket.close();
    }
}