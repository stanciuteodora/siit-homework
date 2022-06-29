package siit.homework04.cars;

/**
 * This is a Volkswagen. Each Volkswagen extends {@link Car}.
 */
public abstract class Volkswagen extends Car {

    public Volkswagen(float availableFuel, int tireSize, String chassisNumber) {
        super(availableFuel, tireSize, chassisNumber);
    }
}
