package homework.task14;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CZĘŚĆ 1
 * W pliku task14.txt znajduje się tekst. Wczytaj go i policz:
 * - liczbę słów
 * - liczbę wierszy
 * - liczbę słów 4-literowych
 * - liczbę słów, które są liczbami (całkowite lub dziesiętne np. 12, 34,45 itd.)
 *
 * CZĘŚĆ 2
 * Zapisz do pliku out_task14.txt wyniki uzyskane z części 1 plus:
 * - listę słów 4-literowych
 * - listę wszystkich liczb
 * Lokalizację pliku out_task14.txt możesz wybrać dowolną np. w bieżącym katalogu
 */
public class Task14A {
    public static void main(String[] args) {
        //W taki sposób tworzymy strumień wejściowy do plików w katalogu resources
        InputStream input = Task14A.class.getResourceAsStream("../../task14.txt");
        //sekwencja ../ powoduje przejście o katalog wyżej
        //dwie sa konieczne ponieważ każdy pakiet to katalog, a mamy pakiet task14 w pakiecie homework

        List<String> outputList = new ArrayList<>();
        int words4CountLambda = 0;
        List<String> words4letters = new ArrayList<>();
        try(BufferedReader bufferedInput = new BufferedReader(new InputStreamReader(input))) {
            String line;

            while((line = bufferedInput.readLine()) != null) {
                outputList.add(line);
                words4letters = Arrays.stream(line.split(" ")).filter(l -> l.length() == 3 && l.matches("\\w+")).collect(Collectors.toList());
                words4CountLambda += words4letters.size();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        } catch (IOException e) {
            System.out.println("IOException");
        }
        int wordsCounter = 0;
        int linesCounter = 0;
        int wordsWith4LettersCounter = 0;
        int digitsCounter = 0;
        List<String> wordsWith4CharList = new ArrayList<>();
        List<String> digitsList = new ArrayList<>();

        Iterator iterator = outputList.iterator();
        while(iterator.hasNext()) {
            String line = iterator.next().toString();
            if(line != null || !line.isEmpty()) {
                String[] wordsCounterTemp = line.split("\\s+");
                wordsCounter += wordsCounterTemp.length;
                //wordsWith4LettersCounter
                for(String a: wordsCounterTemp) {
                    if(a.length() == 4) {
                        wordsWith4LettersCounter++;
                        wordsWith4CharList.add(a);
                    }
                    if(a.matches("[0-9.]+")) {
                        digitsCounter++;
                        digitsList.add(a);
                    }
                }
            }
            linesCounter++;
        }

//        //sposób z lambda
//        int wordsWith4LettersCounter2 = 0;
//        Iterator iterator2 = outputList.iterator();
//        String liner;
//
//        while(iterator2.hasNext()) {
//            liner = iterator2.next().toString();
//            List<String> words4letters = Arrays.stream(liner.split(" ")).filter(l -> l.length() == 3).collect(Collectors.toList());
//            wordsWith4LettersCounter2 += words4letters.size();
//        }


        List<String> inputList = Arrays.asList("Ilość wyrazów: " + wordsCounter,
                "Ilość linii: " + linesCounter,
                "Ilość wyrazów 4-literowych: " + wordsWith4LettersCounter,
                "liczbę słów, które są liczbami: " + digitsCounter);


        try(PrintWriter printer = new PrintWriter(new FileWriter("c:\\data\\task14_input.txt"))) {
            for(String name: inputList){
                printer.println(name);
            }
            printer.println("===============\nLista wyrazów 4-literowych:\n");
            for(String a: words4letters){
                printer.print(a + " ");
            }
            printer.println("\n===============\nLista liczb:\n");
            for(String b: digitsList) {
                printer.print(b + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ilość wyrazóe: " + wordsCounter);
        System.out.println("Ilość linii: " + linesCounter);
        System.out.println("Ilość wyrazów 4-literowych: " + words4CountLambda);
        System.out.println("liczbę słów, które są liczbami: " + digitsCounter);
    }
}
