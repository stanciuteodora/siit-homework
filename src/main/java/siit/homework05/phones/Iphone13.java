package siit.homework05.phones;

/**
 * This is Iphone13. Each Iphone13 extends{@link Iphone}.
 */
public class Iphone13 extends Samsung {

    public Iphone13(String color, String material, String imei) {
        super(color, material, imei);
        this.batteryLife = 10;
    }

    @Override
    public String toString() {
        return "Iphone13{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei=" + imei + '\'' +
                ", battery life=" + batteryLife +
                '}';
    }


}
