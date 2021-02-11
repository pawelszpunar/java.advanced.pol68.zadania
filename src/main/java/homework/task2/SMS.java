package homework.task2;

public class SMS extends Message{

    final String phoneNumber;

    public SMS(String content) {
        super(content);
        phoneNumber = "";
    }

    public SMS(String content, String phoneNumber) {
        super(content);
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String send() {
        String error = "SMS nie może zostać wysłany.";
        if(super.getContent() == null) {
            return error + " Brak treści";
        }
        if(phoneNumber.length() != 9 || phoneNumber.matches("[0-9]+")) {
            return error + " Niepoprawny numer telefonu";
        }

        if(super.canSend() && phoneNumber.matches("[0-9]+") && phoneNumber.length() == 9) {
            return  "SMS o treści " + super.getContent() + " został wysłany na adres " + phoneNumber + ".";
        }

        return error;
    }



//    @Override
//    public String send() {
//        if(canSend(super.getContent()) && phoneNumber.length() == 9 && phoneNumber.contains("[0-9]")) {
//            return  "SMS o treści" + super.getContent() + " został wysłany na adres " + phoneNumber + ".";
//        } else {
//            return "SMS nie może zostać wysłany";
//        }
//    }



//    @Override
//    public void Send(String content, String phoneNumber) {
//        System.out.println("SMS o treści " + content + " został wysłany na numer " + phoneNumber + ".");
//    }

}
