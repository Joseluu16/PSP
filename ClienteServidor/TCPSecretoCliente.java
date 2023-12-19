package ClienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPSecretoCliente {

    public static void main(String[] args) {
        try {
            // Establecer conexión con el servidor
            Socket socket = new Socket("localhost", 2000);

            // Flujo de entrada y salida para comunicarse con el servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Flujo de entrada para la entrada del usuario
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            boolean adivinado = false;

            while (!adivinado) {
                // Solicitar al usuario que ingrese un número
                System.out.print("Ingresa un número: ");
                int numeroUsuario = Integer.parseInt(userInput.readLine());

                // Enviar el número al servidor
                out.println(numeroUsuario);

                // Recibir la respuesta del servidor
                String respuesta = in.readLine();
                System.out.println("Respuesta del servidor: " + respuesta);

                // Verificar si el número fue adivinado
                if (respuesta.equals("Adivinaste")) {
                    adivinado = true;
                }
            }

            // Cerrar conexiones
            in.close();
            out.close();
            userInput.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
