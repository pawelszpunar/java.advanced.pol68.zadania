package homework.task15;

public class Task15AThread extends Thread{
    @Override
    public void run() {
        while(!this.isInterrupted()) {
            System.out.println("Hello");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Przerwanie wątku");
                this.interrupt();
            }
        }
        System.out.println("Koniec wątku!");
    }
}
