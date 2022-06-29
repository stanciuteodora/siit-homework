package siit.homework04.cars;

/**
 * This is a vehicle. It can be started, stopped and driven for a number of km
 */
public interface Vehicle {

    /**
     * Starts the vehicle;
     */
    void start();

    /**
     * Stops the vehicle;
     */
    void stop();

    /**
     * Drives the vehicle for a number of km;
     *
     * @param km the number of km;
     */
    void drive(double km);

}
