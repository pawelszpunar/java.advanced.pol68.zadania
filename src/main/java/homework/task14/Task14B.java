package homework.task14;

import anonymous.Callback;
import anonymous.Menu;
import anonymous.MenuItem;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Napisz program, który obsługuje książkę adresową zapisywaną w pliku.
 * Format pliku jest binarny, a zapisywane są serializowane obiekty klasy
 * AddressItem. Dodaj do tej klasy odpowiedni interfejs, który umożliwia serializację.
 * Program powinien umożliwiać:
 * - dodanie nowego adresu
 * - usunięcie adresu
 * - wyświetlenie całej zawartości
 * - wyszukanie na podstawie pola name lub phoneNumber adresu lub adresów (dla pola name)
 */
public class Task14B {
    static Scanner scanner = new Scanner(System.in);
    static String path = "address.txt";
    public static void main(String[] args){

        AddressItem addressItem1 = new AddressItem("Andrzej", "Kowalski", "mail@o.pl", "666000111", LocalDate.of(1980,1,1));
        AddressItem addressItem2 = new AddressItem("Piotr", "Iksiński", "pi@onet.pl", "654852154", LocalDate.of(1989,12,3));
        AddressItem addressItem3 = new AddressItem("Ewelina", "Kotarska", "aa@aa.pl", "658425411", LocalDate.of(1999,4,8));
        AddressItem addressItem4 = new AddressItem("Paulina", "Modrzejewska", "buziaczek@poczta.server.cn", "555444123", LocalDate.of(1990,2,22));
        AddressItem addressItem5 = new AddressItem("Andrew", "Brown", "pro@office.bn", "888456258", LocalDate.of(1975,5,15));

        List<AddressItem> addresses = new ArrayList<>();
        addresses.add(addressItem1);
        addresses.add(addressItem2);
        addresses.add(addressItem3);
        addresses.add(addressItem4);
        addresses.add(addressItem5);

        try(ObjectOutputStream newStream = new ObjectOutputStream(new FileOutputStream(path))) {
            for(AddressItem address: addresses) {
                newStream.writeObject(address);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MenuItem addNewAddress = new MenuItem("Dodaj adres", 1);
        MenuItem deleteAddress = new MenuItem("Usuń adres", 2);
        MenuItem showAddresses = new MenuItem("Pokaż wszystko", 3);
        MenuItem searchForAddress = new MenuItem(("Znajdź adres wg pola name lub phone number"), 4);
        MenuItem exitFromProgram = new MenuItem(("Wyjście z programu"), 5);

        addNewAddress.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.print("Podaj imie: ");
                scanner.nextLine();
                String imie = scanner.nextLine();
                System.out.print("Podaj nazwisko: ");
                String nazwisko = scanner.nextLine();
                System.out.print("Podaj adres email: ");
                String email = scanner.nextLine();
                System.out.print("Podaj numer telefonu: ");
                String nrTelefonu = scanner.nextLine();
                System.out.print("Podaj datę urodzenia w formacie RRRR-MM-DD: ");
                String dataUrodzeniaString = scanner.nextLine();
                LocalDate dataUrodzenia = LocalDate.parse(dataUrodzeniaString);
                //===> tutaj można dodac weryfikacje podanej daty <===
                AddressItem addressToAdd = new AddressItem(imie, nazwisko, email, nrTelefonu, dataUrodzenia);
                //==> klasa AppendingObjectOutputStream pozwala na zapisanie na końcu pliku zamiast nadpisania(!!), bez tego mamy błąd StreamCorruptedException
                try(ObjectOutputStream newStream = new AppendingObjectOutputStream(new FileOutputStream("address.txt",true))) {
                    newStream.writeObject(addressToAdd);
                    newStream.close();
                    System.out.println("Adres dodany poprawnie.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        deleteAddress.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.println("Dostępne adresy w bazie: ");
                showAllAddresses(path);
                System.out.print("Podaj ID adresu do usunięcia (Wpisz 0 aby anulować): ");
                scanner.nextLine();
                String userInput = scanner.nextLine();

                if(userInput.equals("0")) {
                    System.out.println("Anulowano. Wracam do menu.");
                } else {
                    List<AddressItem> objectsList = new ArrayList<>();
                    AddressItem addressItem;
                    //deserializacja
                    try(ObjectInputStream newStream = new ObjectInputStream(new FileInputStream(path))) {
                        while((addressItem = (AddressItem) newStream.readObject()) != null) {
                            objectsList.add(addressItem);
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("FileNotFoundException");
                    } catch (IOException e) {
                        System.out.println("IOException");
                    } catch (ClassCastException e) {
                        System.out.println("ClassCastException");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    ListIterator<AddressItem> iterator = objectsList.listIterator();
                    while (iterator.hasNext()) {
                        AddressItem item = iterator.next();
                        if(Integer.parseInt(userInput) == item.getId()) {
                            iterator.remove();
                            System.out.println("Adres usunięty poprawnie!");
                        }
                    }

                    try(ObjectOutputStream streamAddAfterDelete = new ObjectOutputStream(new FileOutputStream(path))) {
                        for(AddressItem address: objectsList) {
                            streamAddAfterDelete.writeObject(address);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Aktualna baza:");
                    showAllAddresses(path);
                }
            }
        });

        searchForAddress.setCallback(new Callback() {
            @Override
            public void action() {
                System.out.print("Wyszukiwarka. Podaj imię lub numer telefonu: ");
                scanner.nextLine();
                String userSearchInput = scanner.nextLine();
                List<AddressItem> objectsListToSearch = new ArrayList<>();
                AddressItem addressItemToSearch;
                try(ObjectInputStream streamSearch = new ObjectInputStream(new FileInputStream(path))) {
                    while((addressItemToSearch = (AddressItem) streamSearch.readObject()) != null) {
                        objectsListToSearch.add(addressItemToSearch);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException");
                } catch (IOException e) {
                    System.out.print("");
                } catch (ClassCastException e) {
                    System.out.println("ClassCastException");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                ListIterator<AddressItem> iterator = objectsListToSearch.listIterator();
                System.out.println("+- Wyniki wyszukiwania: ------------+--------------------------------+-----------+------------+");
                System.out.println("+----+------------+-----------------+--------------------------------+-----------+------------+");
                while (iterator.hasNext()) {
                    AddressItem item = iterator.next();
                    if(item.getName().equals(userSearchInput) || item.getPhoneNumber().equals(userSearchInput)) {
                        System.out.format("| %-2s | %-10s | %-15s | %-30s | %-9s | %-10s |", item.getId(), item.getName(), item.getFullName(), item.getEmailAddress(), item.getPhoneNumber(), item.getBirthDate());
                        System.out.println();
                        System.out.println("+----+------------+-----------------+--------------------------------+-----------+------------+");
                    }
                }

            }
        });

        showAddresses.setCallback(new Callback() {
            @Override
            public void action() {
                showAllAddresses(path);
            }
        });

        exitFromProgram.setCallback(new Callback() {
            @Override
            public void action() {
                System.exit(0);
            }
        });

        Menu menu = new Menu(new MenuItem[]{addNewAddress, deleteAddress, showAddresses, searchForAddress, exitFromProgram});
        while(true) {
            menu.print();
            System.out.print("Twój wybór: ");
            int itemNumber = scanner.nextInt();
            menu.process(itemNumber);
        }
    }

    public static void showAllAddresses(String filePath) {
        try(ObjectInputStream newStream = new ObjectInputStream(new FileInputStream(filePath))) {
            Object tempObj = null;

            try {
                while ((tempObj = newStream.readObject()) != null) {
                    System.out.println(((AddressItem) tempObj).toString());
                }
            } catch (EOFException e) {
                System.out.println("====Koniec pliku====");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }
}
