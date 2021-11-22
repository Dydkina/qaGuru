public class Car {

    private String name;
    private int yearOfProduction;
    private String whereIsRudder;
    private static int countOfRudder = 1;

    public Car(String name, int yearOfProduction, String whereIsRudder) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
        this.whereIsRudder = whereIsRudder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getWhereIsRudder() {
        return whereIsRudder;
    }

    public void setWhereIsRudder(String whereIsRudder) {
        this.whereIsRudder = whereIsRudder;
    }

    public void sayCarName() {
        System.out.println(getName());
    }

    public void changeCarName(String newCarName) {
        setName(newCarName);
    }

    public static int getCountOfRudder() {
        return countOfRudder;
    }
}
