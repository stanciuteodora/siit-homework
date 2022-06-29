package siit.homework04.cars;

/**
 * This is a VwGolf. Each VwGolf extends {@link Volkswagen};
 * VwGolf consumes the same amount of fuel regardless of the tires; however VwGolf has a 10% decrease
 * every time it shifts up;
 */
public class VwGolf extends Volkswagen {

    public VwGolf(float availableFuel, int tireSize, String chassisNumber) {
        super(availableFuel, tireSize, chassisNumber);
        this.fuelTankSize = 40;
        this.fuelType = "Diesel";
        this.gears = 5;
        this.consumptionPer100Km = 4;
    }

    /**
     * VWGolf has a 10% decrease every time it shifts up;
     *
     * @return the consumptionPer100Km depending on the gear;
     */
    @Override
    public double getConsumptionPer100Km() {
        return consumptionPer100Km * Math.pow(1.1, (gears - currentGear));

//        int i = currentGear;
//        double computedConsumption = consumptionPer100Km;
//        while (i< gears){
//            computedConsumption = consumptionPer100Km*1.1;
//            i++;
    }

//        if (currentGear == 5 ){
//            consumptionPer100Km = consumptionPer100Km;
//        }else if (currentGear == 4 ){
//            consumptionPer100Km = consumptionPer100Km*1.1;
//        }else if (currentGear == 3 ){
//            consumptionPer100Km = consumptionPer100Km*1.1*1.1;
//        } else if (currentGear == 2 ){
//            consumptionPer100Km = consumptionPer100Km*1.1*1.1*1.1;
//        } else if (currentGear == 1 ){
//            consumptionPer100Km = consumptionPer100Km*1.1*1.1*1.1*1.1;
//        }
}

