package siit.homework10.dataModel;

/**
 * This is a biathlon athlete.
 */
public class BiathlonAthlete {
    private int athleteNumber;
    private String name;
    private String countryCode;

    /**
     * Creates a biathlon athlete.
     *
     * @param athleteNumber the biathlon athlete number
     * @param name          the biathlon athlete name
     * @param countryCode   the biathlon athlete country code
     */
    public BiathlonAthlete(int athleteNumber, String name, String countryCode) {
        this.athleteNumber = athleteNumber;
        this.name = name;
        this.countryCode = countryCode;
    }

    public int getAthleteNumber() {
        return athleteNumber;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }
//    @Override
//    public String toString() {
//        return "BiathlonAthlete{" +
//                "athleteNumber=" + athleteNumber +
//                ", name='" + name + '\'' +
//                ", countryCode='" + countryCode + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return name;
    }
}
