
package ServidorClienteTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        final String servidorIP = "127.0.0.1"; // Cambia esto a la dirección IP del servidor si es necesario
        final int puerto = 12345;

        try {
            Socket socket = new Socket(servidorIP, puerto);
            System.out.println("Conectado al servidor en " + servidorIP + ":" + puerto);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            // Bucle para enviar mensajes al servidor hasta que se introduzca un asterisco
            while (true) {
                System.out.print("Ingrese un mensaje (o '*' para salir): ");
                String mensaje = scanner.nextLine();

                salida.println(mensaje);

                if (mensaje.equals("*")) {
                    break; // Salir del bucle si se introduce un asterisco
                }

                String respuesta = entrada.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);
            }

            System.out.println("Desconectando del servidor.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

