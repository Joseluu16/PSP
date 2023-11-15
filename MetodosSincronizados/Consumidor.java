
package MetodosSincronizados;

import java.util.Random;


public class Consumidor implements Runnable {
     private ColaSincronizada cola;

    public Consumidor(ColaSincronizada cola) {
        this.cola = cola;
    }

    public void run() {
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            int value = cola.get();

            try {
                Thread.sleep(rand.nextInt(500));  // Tiempo de espera aleatorio entre 0 y 500 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
