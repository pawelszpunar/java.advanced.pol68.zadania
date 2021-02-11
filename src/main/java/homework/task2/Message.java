package homework.task2;

abstract public class Message {
    private final String content;

    public Message(String content) {
        this.content = content;
    }

    abstract public String send();

    boolean canSend(){
        if(content == null || content.isEmpty() || content.length() < 5){
            return false;
        }
        return true;
    }

    public String getContent() {
        return content;
    }


}
