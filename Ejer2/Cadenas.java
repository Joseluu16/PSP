/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Cadenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de cadenas a generar: ");
        int Cadenas = scanner.nextInt();
        scanner.close();
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try {
            FileWriter fileWriter = new FileWriter("resultados.txt");

            for (int i = 0; i < Cadenas; i++) {
                int longitud = new Random().nextInt(20) + 1;
                StringBuilder cadena = new StringBuilder();
                for (int j = 0; j < longitud; j++) {
                    int indice = new Random().nextInt(alfabeto.length());
                    char caracter = alfabeto.charAt(indice);
                    cadena.append(caracter);
                }
                String cadenaGenerada = cadena.toString();
                System.out.println("Cadena " + (i + 1) + ": " + cadenaGenerada);

                // Llamar a Frecuencia para contar las vocales en la cadena generada
                int[] frecuencias = Frecuencia.contarVocales(cadenaGenerada);

                fileWriter.write("Cadena " + (i + 1) + ": ");
                for (int k = 0; k < frecuencias.length; k++) {
                    fileWriter.write("Vocal " + (char) ('a' + k) + ": " + frecuencias[k] + " ");
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
