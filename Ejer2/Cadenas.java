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
public class Cadenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de cadenas a generar: ");
        int Cadenas = scanner.nextInt();
        scanner.close();
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < Cadenas; i++) {
            int longitud = new Random().nextInt(20) + 1;           
            StringBuilder cadena = new StringBuilder();
            for (int j = 0; j < longitud; j++) {
                int indice = new Random().nextInt(alfabeto.length());
                char caracter = alfabeto.charAt(indice);
                cadena.append(caracter);
            }
        System.out.println("Cadena " + (i + 1) + ": " + cadena.toString());
    }
 }
}
