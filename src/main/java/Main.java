public class Main {

    public static void main(String[] args) {

        Car bmw = new Car("Ласточка", 1998, "Слева");
        Car mazda = new Car("Bird", 2021, "Right");

        bmw.sayCarName();
        bmw.changeCarName("Не ласточка");
        bmw.sayCarName();

        mazda.sayCarName();
        
        System.out.println(Car.getCountOfRudder());
    }
}
