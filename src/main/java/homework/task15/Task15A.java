package homework.task15;

import java.util.Scanner;

/**
 * Napisz program, który co 5 sekund wyświetla komunikat "Hello" do czasu naciśnięcia klawisza Q przez użytkownika
 */
public class Task15A {
    public static void main(String[] args) throws InterruptedException {
        Task15AThread thread = new Task15AThread();
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("q") || input.equals("Q")) {
                thread.interrupt();
            }
            Thread.sleep(1);
            if(!thread.isAlive()) {
                System.out.println("Wątek już się zakońćzył");
                return;
            }
        }
    }
}
