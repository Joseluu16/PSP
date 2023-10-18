/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejer4;

import java.io.IOException;

/**
 *
 * @author jolun
 */
public class Proceso {
    public static void main(String[] args) {
        try {
            // Iniciar el proceso del Bloc de notas
            ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
            Process notepadProcess = processBuilder.start();

            // Verificar si el proceso del Bloc de notas está en ejecución
            if (notepadProcess.isAlive()) {
                System.out.println("El Bloc de notas está en ejecución.");
            }
            Thread.sleep(20000);
            
            if (notepadProcess.isAlive()) {
                System.out.println("El Bloc de notas todavía está en ejecución.");
            } else {
                System.out.println("El Bloc de notas se ha cerrado durante la pausa.");
            }

            // Cerrar el proceso del Bloc de notas
            notepadProcess.destroy();

            // Verificar nuevamente si el proceso está cerrado 
            if (notepadProcess.isAlive()) {
                System.out.println("El Bloc de notas sigue en ejecución después de destroy().");
            } else {
                System.out.println("El Bloc de notas se ha cerrado correctamente después de destroy().");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}


