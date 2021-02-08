package homework.task3;

public class CellPhone extends Device {
    final String simCard;
    final int cameraSize;

    public CellPhone(int batteryCapacity, String producer, String simCard, int cameraSize) {
        super(batteryCapacity, producer);
        this.simCard = simCard;
        this.cameraSize = cameraSize;
    }

    public String getSimCard() {
        return simCard;
    }

    public int getCameraSize() {
        return cameraSize;
    }

    @Override
    public String sendSMS(String sms) {
        if (simCard != null) {
            return "Your cellphone is sending " + sms;
        } else {
            return "Cant send. No sim card";
        }
    }
}
