package siit.homework05.phones;

/**
 * This is Iphone12. Each Iphone12 extends{@link Iphone}.
 */
public class Iphone12 extends Samsung {

    public Iphone12(String color, String material, String imei) {
        super(color, material, imei);
        this.batteryLife = 10;
    }

    @Override
    public String toString() {
        return "Iphone12{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei=" + imei + '\'' +
                ", battery life=" + batteryLife +
                '}';
    }


}
