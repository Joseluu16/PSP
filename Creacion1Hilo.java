/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

/**
 *
 * @author jolun
 */
public class Creacion1Hilo extends Thread{
     private int n;

    public Creacion1Hilo(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int a = 1, b = 1;
        System.out.println("Sucesión de Fibonacci de los primeros " + n + " números:");
        System.out.print(a + " " + b + " ");

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }


    public static void main(String[] args) {
        int n = 10; // Cambia n al número deseado de elementos en la sucesión de Fibonacci
        Creacion1Hilo hiloFibonacci = new Creacion1Hilo(n);
        hiloFibonacci.start();
    }
}
