
package Ejer5Hilos;

public class ContadorVocales {

    public static void main(String[] args) {
        String texto = "Hola Ne llamo jose Luis y esto es para probar las vocales";
        int totalVocales = 0;
        
        // Crear 5 contadores de vocales
        ContadorVocal contadorA = new ContadorVocal('a', texto);
        ContadorVocal contadorE = new ContadorVocal('e', texto);
        ContadorVocal contadorI = new ContadorVocal('i', texto);
        ContadorVocal contadorO = new ContadorVocal('o', texto);
        ContadorVocal contadorU = new ContadorVocal('u', texto);
        
        // Crear hilos para cada contador
        Thread hiloA = new Thread(contadorA);
        Thread hiloE = new Thread(contadorE);
        Thread hiloI = new Thread(contadorI);
        Thread hiloO = new Thread(contadorO);
        Thread hiloU = new Thread(contadorU);
        
        // Iniciar los hilos
        hiloA.start();
        hiloE.start();
        hiloI.start();
        hiloO.start();
        hiloU.start();
        
        // Esperar a que todos los hilos terminen
        try {
            hiloA.join();
            hiloE.join();
            hiloI.join();
            hiloO.join();
            hiloU.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Sumar los totales de cada contador
        totalVocales = contadorA.getTotal() + contadorE.getTotal() + contadorI.getTotal() + contadorO.getTotal() + contadorU.getTotal();
        
        System.out.println("Total de vocales: " + totalVocales);
    }
}

class ContadorVocal implements Runnable {
    private char vocal;
    private String texto;
    private int total = 0;
    
    public ContadorVocal(char vocal, String texto) {
        this.vocal = vocal;
        this.texto = texto;
    }
    
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == vocal) {
                total++;
            }
        }
    }
    
    public int getTotal() {
        return total;
    }
}

