package homework.task1;

import java.time.LocalDate;

public class SuperPerson extends Person{

    public SuperPerson(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    @Override
    public String toString() {
        return "Bohater " + name + " urodzony w " + birthDate.getDayOfMonth() + "-" + birthDate.getMonthValue() + "-" + birthDate.getYear();
    }
}
