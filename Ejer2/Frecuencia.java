/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer2;

import java.util.Scanner;

/**
 *
 * @author jolun
 */
import java.util.Scanner;

public class Frecuencia {
    public static int[] contarVocales(String texto) {
        int[] vocales = new int[5];

        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            switch (caracter) {
                case 'a':
                    vocales[0]++;
                    break;
                case 'e':
                    vocales[1]++;
                    break;
                case 'i':
                    vocales[2]++;
                    break;
                case 'o':
                    vocales[3]++;
                    break;
                case 'u':
                    vocales[4]++;
                    break;
                default:
                    break;
            }
        }
        return vocales;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escriba una palabra");
        String texto = sc.nextLine();

        int[] frecuencias = contarVocales(texto);

        for (int i = 0; i < frecuencias.length; i++) {
            System.out.println(frecuencias[i] + " ");
        }
        sc.close();
    }
}
