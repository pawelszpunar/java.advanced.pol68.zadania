package homework.task6;

public class Pesel {
    final String pesel;

    private Pesel(String pesel) {
        this.pesel = pesel;
    }

    public static Pesel of(String pesel){
        if(peselCheck(pesel)){
            return new Pesel(pesel);
        }
        System.out.println("Numer pesel nie jest poprawny");
        return null;
    }

    public static boolean peselCheck(String pesel){
        if(pesel.length() != 11) {
            return false;
        }
        String[] peselStringTable = pesel.split("");
        int[] peselInt = new int[peselStringTable.length];
        for (int i = 0; i < peselStringTable.length; i++) {
            peselInt[i] = Integer.parseInt(peselStringTable[i]);
        }
        int peselTest = peselInt[0] + peselInt[1] * 3 + peselInt[2] * 7 + peselInt[3] * 9 + peselInt[4] + peselInt[5] * 3 + peselInt[6] * 7 + peselInt[7] * 9 + peselInt[8] + peselInt[9] * 3 + peselInt[10];
        if(peselTest % 10 != 0 || peselTest < 0){
            return false;
        }
        return true;
    }

    public boolean isFemale(){
        int peselTest = Character.getNumericValue(pesel.charAt(9));
        return peselTest % 2 == 0;
    }

    public boolean isMale(){
        int peselTest = Character.getNumericValue(pesel.charAt(9));
        return peselTest % 2 != 0;
    }

    public String birthDate(){
        int year = (Character.getNumericValue(pesel.charAt(0)) * 10) + Character.getNumericValue(pesel.charAt(1));
        int month = (Character.getNumericValue(pesel.charAt(2)) * 10) + Character.getNumericValue(pesel.charAt(3));
        int day = (Character.getNumericValue(pesel.charAt(4)) * 10) + Character.getNumericValue(pesel.charAt(5));
        if(month > 20){
            year += 2000;
            month -= 20;
        } else {
            year += 1900;
        }
        return "Birth date: " + day + "." + month + "." + year;
    }

    public String get() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Pesel{" +
                "pesel='" + pesel + '\'' +
                '}';
    }
}