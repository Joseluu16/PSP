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
public class Frecuencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]vocales = new int[5];
        
        System.out.println("Escriba una palabra");
        String texto = sc.nextLine();
        
        for(int i=0;i < texto.length();i++){
            char caracter = texto.charAt(i);
            switch(caracter){
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
        for(int i=0;i < vocales.length;i++){
            System.out.println(vocales[i]+ " ");
        }
        sc.close();
    }
}
