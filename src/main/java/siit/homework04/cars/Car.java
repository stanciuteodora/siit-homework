package siit.homework04.cars;

/**
 * This is a car. Each car implements {@link Vehicle} and has:
 * properties which can not change: fuelTankSize, fuelType (PETROL, DIESEL, etc),
 * gears (max 6), consumptionPer100Km (i.e 4.7);
 * properties that are configurable: availableFuel, tireSize(15, 17, etc);
 * properties that are instance specific: chassisNumber, currentGear, tripConsumption, tripTotalDistance;
 */
public abstract class Car implements Vehicle {

    protected double fuelTankSize;
    protected String fuelType;
    protected int gears;
    protected double consumptionPer100Km;
    protected double availableFuel;
    protected int tireSize;
    protected String chassisNumber;
    protected int currentGear;
    private double tripConsumption;
    private double tripTotalDistance;

    public Car(float availableFuel, int tireSize, String chassisNumber) {
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
        this.currentGear = 1;
        this.tripConsumption = 0;
        this.tripTotalDistance = 0;
    }

    /**
     * Given a number driven of kilometers, it calculates the availableFuel, the tripConsumption and the tripTotalDistance;
     *
     * @param km the number of driven kilometers;
     */
    @Override
    public void drive(double km) {
        double consumedFuel = km * getConsumptionPer100Km() / 100;
        availableFuel = availableFuel - consumedFuel;
        if (availableFuel < 0) {
            throw new IllegalArgumentException("Cannot drive this long: insufficient fuel");
        }
        tripConsumption = tripConsumption + consumedFuel;
        tripTotalDistance = tripTotalDistance + km;
        System.out.println(" Car was driven for " + km + "km");
    }

    /**
     * Gets the total amount of fuel consumed in a trip. It is reset when the car starts;
     *
     * @return the total amount of fuel consumed in a trip;
     */
    public double getTripConsumption() {
        return tripConsumption;
    }

    /**
     * Gets the average fuel consumption/100 km for a trip. It is reset when the car starts;
     *
     * @return the average fuel consumption/100 km for a trip;
     */
    public double getAverageFuelConsumption() {
        return tripConsumption * 100 / tripTotalDistance;
    }

    /**
     * Updates the availableFuel after adding fuel. If you are trying to add more fuel than the tank volume, the
     * excess is discarded;
     *
     * @param liters the quantity of fuel to be added;
     */
    public void refuel(double liters) {
        if ((availableFuel + liters) > fuelTankSize) {
            availableFuel = fuelTankSize;
        } else {
            availableFuel = availableFuel + liters;
        }
    }

    /**
     * Gets the volume of fuel currently in the tank;
     *
     * @return the volume of fuel currently in the tank
     */
    public double getAvailableFuel() {
        return availableFuel;
    }

    /**
     * It shifts the gears.
     *
     * @param gear the gear
     * @throws IllegalArgumentException if you're trying to shift in a gear that doesn't exist;
     */
    public void shiftGear(int gear) {
        if (gear > gears) {
            throw new IllegalArgumentException("This car has not enough gears for that");
        }
        currentGear = gear;
    }

    /**
     * Gets the consumption of the car in cruising mode (last gear).
     *
     * @return the consumption of the car in cruising mode (last gear).
     */
    public double getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    /**
     * It starts the car, keeps track of how much it has consumed and resets the stats;
     */
    @Override
    public void start() {
        System.out.println("Previous trip consumption: " + tripConsumption);
        tripConsumption = 0;
        tripTotalDistance = 0;
        System.out.println("The car starts");
    }

    /**
     * It stops the car and keeps track of how much it has consumed and average consumption/100 km
     */
    @Override
    public void stop() {
        System.out.println("The car stops. The trip consumption is: " + getTripConsumption() + "; average consumption/100 km " +
                "is: " + getAverageFuelConsumption());
    }

}
