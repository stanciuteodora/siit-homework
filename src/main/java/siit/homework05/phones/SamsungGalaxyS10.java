package siit.homework05.phones;

/**
 * This is SamsungGalaxyS10. Each SamsungGalaxyS10 extends{@link Samsung}.
 */
public class SamsungGalaxyS10 extends Samsung {

    public SamsungGalaxyS10(String color, String material, String imei) {
        super(color, material, imei);
        this.batteryLife = 10;
    }

    @Override
    public String toString() {
        return "SamsungGalaxyS10{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                ", imei=" + imei + '\'' +
                ", battery life=" + batteryLife +
                '}';
    }


}
