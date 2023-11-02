/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *
 * @author jolun
 */
public class Creacion2Hilos {
    
    class HiloPin extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("PIN");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
    
    class HiloPon extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("PON");
            try {
                Thread.sleep(1000); // Espera 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
     public void main(String[] args) {
        HiloPin hiloPin = new HiloPin();
        HiloPon hiloPon = new HiloPon();

        hiloPin.start(); // Inicia el hilo HiloPin
        hiloPon.start(); // Inicia el hilo HiloPon
    }

}
