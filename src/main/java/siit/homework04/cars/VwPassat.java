package siit.homework04.cars;

/**
 * This is a VwPassat. Each VwPassat extends {@link Volkswagen}.
 * VwPassat consumes the same amount of fuel regardless of the gear; however VwPassat consumes 10% (5.5l/100km) more
 * if the tires are bigger than 15"
 */
public class VwPassat extends Volkswagen {

    public VwPassat(float availableFuel, int tireSize, String chassisNumber) {
        super(availableFuel, tireSize, chassisNumber);
        this.fuelTankSize = 50;
        this.fuelType = "Petrol";
        this.gears = 6;
        this.consumptionPer100Km = 5;
    }

    /**
     * VwPassat consumes 10% (5.5l/100km) more if the tires are bigger than 15";
     *
     * @return computed consumption;
     */
    @Override
    public double getConsumptionPer100Km() {
        double i = 1.1;
        double computedConsumption = consumptionPer100Km;
        if (tireSize > 15) {
            computedConsumption = consumptionPer100Km * i;
        }
        return computedConsumption;
    }
}
