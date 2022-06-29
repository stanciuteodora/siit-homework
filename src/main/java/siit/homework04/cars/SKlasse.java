package siit.homework04.cars;

/**
 * This is a CKlasse. Each CKlasse extends {@link Mercedes};
 */
public class SKlasse extends Mercedes {

    public SKlasse(float availableFuel, int tireSize, String chassisNumber) {
        super(availableFuel, tireSize, chassisNumber);
        this.fuelTankSize = 80;
        this.fuelType = "Diesel";
        this.gears = 6;
        this.consumptionPer100Km = 10;
    }
}
