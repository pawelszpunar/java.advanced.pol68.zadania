package concurrency;

import java.util.Random;

public class CounterThread extends Thread{
    final Counter counter;
    private int localCounter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        int count = 10;
        Random random = new Random();
        while (!this.isInterrupted() && count-- > 0) {
            // zakomentowany kod dotyczy sytuacji gdy inc nie jest synchronizowana
//            synchronized (counter) {   // synchronizacja na wspólnym obiekcie za pomocą bloku synchronized
//                counter.inc();      //sekcja krytyczna, bo odwołujemy się do wspólnego obiektu dla wszystkich wątków
//            }

            counter.inc();   // nie musimy umieszczać w bloku synchronized, bo metoda jest synchronizowana na swoim obiekcie

            localCounter++;
            try {
                Thread.sleep(random.nextInt(1));
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku");
                this.interrupt();
            }
        }
        System.out.println("KONIEC WĄTKU" + this.isInterrupted());
    }

    public int getLocalCounter() {
        return localCounter;
    }
}
