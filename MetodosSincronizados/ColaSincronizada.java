
package MetodosSincronizados;

import java.util.ArrayList;


public class ColaSincronizada {
     private ArrayList<Integer> contenedor = new ArrayList<>();

    public synchronized void put(int value) {
        contenedor.add(value);
        System.out.println("Productor produce: " + value);
        notify();  // Notificar a los consumidores que hay datos disponibles
    }

    public synchronized int get() {
        while (contenedor.isEmpty()) {
            try {
                wait();  // Esperar hasta que haya datos disponibles
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int value = contenedor.remove(0);
        System.out.println("Consumidor consume: " + value);
        return value;
    }
}

