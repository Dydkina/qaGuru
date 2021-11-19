public class Main {

    public static void main(String[] args) {

        Car bmw = new Car("Ласточка", 1998, "Слева");

        bmw.sayCarName();
        bmw.changeCarName("Не ласточка");
        bmw.sayCarName();

        System.out.println(Car.getCountOfRudder());
    }
}
