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
        if(canSend(super.getContent()) && emailAddress != null && emailAddress.contains("@")) {
            return  "Mail o treści" + super.getContent() + " został wysłany na adres " + emailAddress + ".";
        }
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
        return error;
    }


//    @Override
//    public String send() {
//        if(canSend(subject) && emailAddress.contains("@")) {
//            return  "Mail o treści" + subject + " został wysłany na adres " + emailAddress + ".";
//        } else {
//            return "Mail nie może zostać wysłany";
//        }
//    }


    public Email(String content, String emailAddress, String subject) {
        super(content);
        this.emailAddress = emailAddress;
        this.subject = subject;
    }



//    @Override
//    public String send(String content, String emailAddress) {
//        if(canSend(content) && emailAddress.contains("@")) {
//            return  "Mail o treści" + content + " został wysłany na adres " + emailAddress + ".";
//        } else {
//            return "Mail nie może zostać wysłany";
//        }
//
//    }

//    @Override
//    public void Send(String content, String emailAddress) {
//        System.out.println("Mail o treści" + content + " został wysłany na adres " + emailAddress + ".");
//    }

}
