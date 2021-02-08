package homework.task3;

abstract public class Device {

    abstract public boolean isWiFi();

    abstract public void setWiFi(boolean wiFi);

    abstract public String getProducer();

    abstract public String sendSMS(String sms);
}
