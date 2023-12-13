
package ServidorClienteTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        final int puerto = 12345;

        try {
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("Servidor escuchando en el puerto " + puerto);

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress().getHostAddress());

                // Crear un nuevo hilo para manejar la comunicación con el cliente
                Thread hiloCliente = new Thread(() -> {
                    try {
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                        PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                        String mensaje;
                        while ((mensaje = entrada.readLine()) != null) {
                            if (mensaje.equals("*")) {
                                break; // Salir del bucle si se recibe un asterisco
                            }

                            System.out.println("Mensaje recibido: " + mensaje);
                            String mensajeEnMayusculas = mensaje.toUpperCase();
                            salida.println(mensajeEnMayusculas);
                        }

                        System.out.println("Cliente desconectado.");
                        clienteSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                hiloCliente.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
