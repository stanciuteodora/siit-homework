package siit.homework05.phones;

/**
 * This is SamsungGalaxyS6. Each SamsungGalaxyS6 extends{@link Samsung}.
 */
public class SamsungGalaxyS6 extends Samsung {

    public SamsungGalaxyS6(String color, String material, String imei) {
        super(color, material, imei);
        this.batteryLife = 10;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS6{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei=" + imei + '\'' +
                ", battery life=" + batteryLife +
                '}';
    }


}
