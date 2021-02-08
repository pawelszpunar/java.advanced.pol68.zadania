package homework.task3;

public class CellPhone extends Device {
    final int batteryCapacity;
    final String producer;
    final String simCard;
    final int cameraSize;
    boolean isWiFi;

    public CellPhone(int batteryCapacity, String producer, String simCard, int cameraSize) {
        this.batteryCapacity = batteryCapacity;
        this.producer = producer;
        this.simCard = simCard;
        this.cameraSize = cameraSize;
    }

    public int maxWorkTime(int consumptionPerHour) {
        return batteryCapacity / consumptionPerHour;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String getProducer() {
        return producer;
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

    @Override
    public boolean isWiFi() {
        return isWiFi;
    }

    @Override
    public void setWiFi(boolean wiFi) {
        isWiFi = wiFi;
    }

//    public boolean isWiFi() {
//        return isWiFi;
//    }
//
//    public void setWiFi(boolean wiFi) {
//        isWiFi = wiFi;
//    }
}
