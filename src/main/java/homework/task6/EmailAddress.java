package homework.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {
    final String email;

    private EmailAddress(String email) {
        this.email = email;
    }

    public static EmailAddress of(String email){
        String pattern = "^[A-z0-9][\\dA-z-_.]+@([A-Za-z0-9][A-z\\d][A-z\\d-]+\\.){1,6}[A-z]{2,6}$";
        if(!Pattern.matches(pattern,email)){
            return null;
        }
        return new EmailAddress(email);
    }

    public String getEmail() {
        return email;
    }

    public String username(){
        String patternUsername = "^([A-z0-9-_.]+?)@.*";
        //String patternUsername = "^([A-z0-9][\\dA-z-_.]+)@(.*)";
        Pattern pattern = Pattern.compile(patternUsername);
        Matcher matcher = pattern.matcher(email);
        while(matcher.find()){
            return matcher.group(1);
        }
        return "Ups! Coś poszło nie tak.";
    }

    public String host(){
        String patternHost = ".*@([A-z0-9-]+)..*";
        Pattern pattern = Pattern.compile(patternHost);
        Matcher matcher = pattern.matcher(email);
        while(matcher.find()){
            return matcher.group(1);
        }
        return "Ups! Coś poszło nie tak.";
    }

    public String topDomain(){
        String patternTopDomain = ".*@([A-Za-z0-9][A-z\\d][A-z\\d-]+\\.){1,6}([A-z]{2,6})$";
        Pattern pattern = Pattern.compile(patternTopDomain);
        Matcher matcher = pattern.matcher(email);
        while(matcher.find()){
            return matcher.group(2);
        }
        return "Ups! Coś poszło nie tak.";
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
                "email='" + email + '\'' +
                '}';
    }
}
