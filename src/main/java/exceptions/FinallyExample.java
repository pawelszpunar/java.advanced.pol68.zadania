package exceptions;

import homework.task7.Ingredient;

import java.util.Scanner;
/*kombinacje klauzul w try ... catch /// finally
*  - try .... catch
*  - try ... catch ... finally
*  - try ... finally
*  liczba catch dowolna np:
*  try {
*  } catch(...){
*  } catch(...){
*  }...
*     catch(..){
*  }
*
* łączenie wyjątków w jeden catch - po przecinku (!!!)
*
*
* */

public class FinallyExample {
    public static int parse(String str){
        try{
            Integer.parseInt(str);
        } catch (NumberFormatException|ArithmeticException e){
            return 0;
            //blok finally dominuje nad wszystkimi return-ami w metodzie
            //i tylko jego return zwroci wartość z metody
        } finally {
            return -1;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        //CZESC 1
        System.out.println("CZESC 1");
        try{
            int number = Integer.parseInt(str);
            System.out.println("koniec" + number);
        } catch (NumberFormatException e){
            System.out.println("Niepoprawna liczba całkowita");
        }
        finally {
            System.out.println("KONIEC");
        }


        //CZESC 2
        System.out.println("CZESC 2");
        System.out.println(parse(str));


    }
}
