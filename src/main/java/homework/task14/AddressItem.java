package homework.task14;

import java.io.Serializable;
import java.time.LocalDate;

public class AddressItem implements Serializable {
    private static final long serialVersionUID = 8524163652131434056L;

    private static int nextID = 1;

    final String name;
    final String fullName;
    final String emailAddress;
    final String phoneNumber;
    final LocalDate birthDate;
    final int id;



    public AddressItem(String name, String fullName, String emailAddress, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.id = nextID;
        nextID++;

    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getId() {
        return id;
    }

    //System.out.format("| %-10s | %3s |", "test", "test");

    @Override
    public String toString() {
        //return System.out.format("| %-2s | %-10s | %-10s | %-10s | %-10s | %-10s |", id, name, fullName, emailAddress, phoneNumber, birthDate).toString();
        return System.out.format("| %-2s | %-10s | %-15s | %-30s | %-9s | %-10s |", id, name, fullName, emailAddress, phoneNumber, birthDate).toString();
    }

//    @Override
//    public String toString() {
//        return "AddressItem{" +
//                "name='" + name + '\'' +
//                ", fullName='" + fullName + '\'' +
//                ", emailAddress='" + emailAddress + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", birthDate=" + birthDate +
//                ", id=" + id +
//                '}';
//    }
}
