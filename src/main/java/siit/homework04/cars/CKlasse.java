package siit.homework04.cars;

/**
 * This is a CKlasse. Each CKlasse extends {@link Mercedes};
 */
public class CKlasse extends Mercedes {

    public CKlasse(float availableFuel, int tireSize, String chassisNumber) {
        super(availableFuel, tireSize, chassisNumber);
        this.fuelTankSize = 65;
        this.fuelType = "Petrol";
        this.gears = 5;
        this.consumptionPer100Km = 7;
    }
}
