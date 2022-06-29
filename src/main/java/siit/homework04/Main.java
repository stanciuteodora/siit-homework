package siit.homework04;

import siit.homework04.cars.*;

/**
 *
 */
public class Main {
    /**
     * main method
     * @param args unused
     */
    public static void main(String[] args) {

        // passat4 has an increase in consumption with larger tires(16').
        Car passat4 = new VwPassat(15, 16, "jkl");
        // golf1 has a 10% decrease every time it shifts up.
        Car golf1 = new VwGolf(35, 14, "mno");
        // unused/just for fun
        Car passat1 = new VwPassat(50, 15, "abc");
        Car passat2 = new VwPassat(30, 14, "def");
        Car passat3 = new VwPassat(25, 16, "ghi");
        Car cKlasse1 = new CKlasse(45, 17, "pqr");
        Car sKlasse1 = new SKlasse(70, 18, "stu");


        System.out.println("PASSAT4 FIRST TRIP");
        System.out.println("Available fuel is: " + passat4.getAvailableFuel());
        passat4.start();
        passat4.shiftGear(1);
        passat4.drive(1);
        System.out.println("Consumption is: " + passat4.getConsumptionPer100Km());
        passat4.shiftGear(2);
        passat4.drive(10);
        System.out.println("Consumption is: " + passat4.getConsumptionPer100Km());
        passat4.shiftGear(3);
        passat4.drive(15);
        System.out.println("Consumption is: " + passat4.getConsumptionPer100Km());
        passat4.stop();
        System.out.println("Available fuel is: " + passat4.getAvailableFuel());

        System.out.println("PASSAT4 SECOND TRIP");
        System.out.println("Available fuel is: " + passat4.getAvailableFuel());
        passat4.start();
        passat4.shiftGear(1);
        passat4.drive(2);
        System.out.println("Consumption is: " + passat4.getConsumptionPer100Km());
        passat4.shiftGear(2);
        passat4.drive(20);
        System.out.println("Consumption is: " + passat4.getConsumptionPer100Km());
        passat4.stop();
        System.out.println("Available fuel is: " + passat4.getAvailableFuel());

        System.out.println("GOLF1 FIRST TRIP");
        System.out.println("Available fuel is: " + golf1.getAvailableFuel());
        golf1.start();
        golf1.shiftGear(1);
        golf1.drive(10);
        System.out.println("Consumption is: " + golf1.getConsumptionPer100Km());
        golf1.shiftGear(2);
        golf1.drive(10);
        System.out.println("Consumption is: " + golf1.getConsumptionPer100Km());
        golf1.shiftGear(3);
        golf1.drive(10);
        System.out.println("Consumption is: " + golf1.getConsumptionPer100Km());
        golf1.stop();
        System.out.println("Available fuel is: " + golf1.getAvailableFuel());
    }
}
