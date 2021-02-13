package homework.task10;

import java.util.Objects;
import java.util.regex.Pattern;

class IllegalArgumentException extends Exception {
    String address;
    IllegalArgumentException(String address, String message) {
        super(message);
        this.address = address;
    }
}

class IllegalUsernameException extends Exception {
    IllegalUsernameException(String message) {
        super(message);
    }
}

class IllegalHostException extends Exception {
    String host;
    IllegalHostException(String message) {
        super(message);
    }
}

class IllegalTopDomainException extends Exception {
    String host;
    IllegalTopDomainException(String message) {
        super(message);
    }
}

public class EmailAddress {
    final String address;

    private EmailAddress(String address) {
        this.address = address;
    }

    /**
     * Zaimplementuj metodę, która zwróci obiekt EmailAddress, tylko gdy parametr address jest poprawny
     * jeśli nie to zgłosi wyjątek IllegalArgumentException z komunikatem: address + "is not valid email address!"
     */



    public static EmailAddress of(String address) throws IllegalArgumentException {

        //String pattern = "^[A-z0-9][\\dA-z-_.]+@([A-z-]+\\.){1,6}[A-z]{2,6}$";
        String pattern = "^[A-z][\\dA-z-_.]+@([0-9A-z-]+\\.){0,5}([A-z-]+\\.)+[A-z]{2,6}$";
        if(!Pattern.matches(pattern,address)){
            throw new IllegalArgumentException(address, address + " is not valid email address!");
        }
        return new EmailAddress(address);
    }

    /**
     * Zaimplementuj metodę, która tworzy obiekt EmailAddress na podstawie username i hosta
     * Jeśli nie można zbudowac poprawnego adresu np. gdy w login znajduje się znak '@' lub inny niż alfanumeryczny
     * to zgłosi jeden z dwóch wyjątków:
     *          - IllegalUsernameException, gdy username jest niepoprawnie zbudowany
     *          - IllegalHostException, gdy nazwa host nie niepoprawna
     * Jeśli oba argumenty są błędne to zgłaszamy pierwszy wyjątek
     * Obie klasy wyjątków należy samodzielnie zdefiniować
     */

    public static EmailAddress of(String username, String host) throws IllegalUsernameException, IllegalHostException, IllegalTopDomainException{
        String patternUsername = "^[A-z][\\dA-z-_.]+";
        //String patternHost = "([A-z-]+\\.){1,6}[A-z]{2,6}$";
        String patternHost = "[A-z]+([0-9A-z-]+\\.){0,5}([A-z-]+\\.)+[A-z]{2,6}$";

        String patternTopDomain = "([A-z-]+\\.)+[A-z]{2,6}$";

        if(username == null || !Pattern.matches(patternUsername,username)){
            throw new IllegalUsernameException("username is not valid!");
        }

        if(host == null || !Pattern.matches(patternTopDomain,host)){
            throw new IllegalTopDomainException("top domain is not valid!");
        }

        if(host == null || !Pattern.matches(patternHost,host)){
            throw new IllegalHostException("host is not valid!");
        }
        return new EmailAddress(username + "@" + host);

    }


    public static EmailAddress of2(String username, String host) throws IllegalTopDomainException{

        String patternTopDomain = "([A-z-]+\\.)+[A-z]{2,6}$";

        if(host == null || !Pattern.matches(patternTopDomain,host)){
            throw new IllegalTopDomainException("top domain is not valid!");
        }

        return new EmailAddress(username + "@" + host);

    }


    public String get(){
         return address;
    }
    public String username(){
        return extractUsername(address);
    }
    public String host(){
        return extractHost(address);
    }
    public String topDomain(){
        return extractTopDomain(address);
    }

    static private boolean isValidUsername(String input){
        return !isNull(input) && !isEmpty(input) && !hasOneAtSymbol(input) && hasValidCharacters(input);
    }

    static private boolean isValidHost(String input){
        return !isNull(input) && !isEmpty(input) && !hasOneAtSymbol(input) && hasValidCharacters(input) && input.contains(".");
    }

    static private  boolean isValidAddress(String address){
        return !isNull(address)
                && !isEmpty(address)
                && hasOneAtSymbol(address)
                && hasAtLeastOneDotAfterAtSymbol(address)
                && isValidUsername(extractUsername(address))
                && isValidHost(extractHost(address));
    }

    static private String extractUsername(String address){
        return address.substring(0, address.indexOf('@'));
    }

    static private String extractHost(String address){
        return address.substring(address.indexOf('@') + 1);
    }

    static private String extractTopDomain(String address){
        return address.substring(address.lastIndexOf('.') + 1);
    }

    static private boolean isNull(String input){
        return Objects.isNull(input);
    }

    static private boolean isEmpty(String input){
        return input.isEmpty();
    }

    static private boolean hasOneAtSymbol(String input){
        return input.indexOf('@') == input.lastIndexOf('@') && input.indexOf('@') >= 0;
    }

    static private boolean hasAtLeastOneDotAfterAtSymbol(String input){
        return input.indexOf('@') < input.lastIndexOf('.');
    }

    static private boolean hasValidCharacters(String input){
        String str =  input.replace("@","").replace(".","");
        for(char c: str.toCharArray()){
            if (!Character.isAlphabetic(c)){
                return false;
            }
        }
        return true;
    }
}
