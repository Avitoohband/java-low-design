package designpatterns.creational.builder.car;

public class CarBuilderDemo {
    public static void main(String[] args) {
        Car car = new Car.Builder().
                withCarPlate("558452")
                .withColor("Blue")
                .withMm(1600)
                .withMake("Hyundai")
                .withYear(2024)
                .withModel("Kona Turbo").build();
        System.out.println(car);
    }
}
