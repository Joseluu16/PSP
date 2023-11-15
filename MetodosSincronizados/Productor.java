
package MetodosSincronizados;

import java.util.Random;


public class Productor implements Runnable {
     private ColaSincronizada cola;

    public Productor(ColaSincronizada cola) {
        this.cola = cola;
    }

    public void run() {
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            cola.put(i);

            try {
                Thread.sleep(rand.nextInt(1000));  // Tiempo de espera aleatorio entre 0 y 1000 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
