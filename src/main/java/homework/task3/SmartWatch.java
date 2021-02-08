package homework.task3;

public class SmartWatch extends Device {
    final String strapColor;

    public SmartWatch(String producer, int batteryCapacity, String strapColor) {
        super(batteryCapacity, producer);
        this.strapColor = strapColor;
    }

    public String getStrapColor() {
        return strapColor;
    }

    @Override
    public String sendSMS(String sms){
        if (super.isWiFi){
            return "Your smartwatch is Sending " + sms;
        } else {
            return "Cant send. Turn on Wifi";
        }
    }
}
