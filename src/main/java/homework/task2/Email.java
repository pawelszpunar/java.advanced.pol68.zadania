package homework.task2;

public class Email extends Message{
    final String  emailAddress;
    final String subject;

    public Email(String content) {
        super(content);
        emailAddress = "";
        subject = "";
    }

    @Override
    public String send() {

        String error = "Mail nie może zostać wysłany.";
        if(emailAddress != null && !emailAddress.contains("@")) {
            return error + " Adres email nie zawiera znaku @.";
        }
        if(emailAddress == null) {
            return error + " Nie podano adresu email.";
        }
        if(subject == null) {
            return error + " Nie podano tematu maila.";
        }
        if(super.getContent() == null) {
            return error + " Brak treści maila.";
        }

        if(super.canSend() && emailAddress != null && emailAddress.contains("@")) {
            return  "Mail o treści" + super.getContent() + " został wysłany na adres " + emailAddress + ".";
        }
        return error;
    }

    public Email(String content, String emailAddress, String subject) {
        super(content);
        this.emailAddress = emailAddress;
        this.subject = subject;
    }

}
