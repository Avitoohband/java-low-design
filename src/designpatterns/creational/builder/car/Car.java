package designpatterns.creational.builder.car;

public class Car {
    private String model;
    private String make;
    private Integer year;
    private String carPlate;
    private String color;
    private Integer mm;

    private Car() {
    }

    ;

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public String getColor() {
        return color;
    }

    public Integer getMm() {
        return mm;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                ", carPlate='" + carPlate + '\'' +
                ", color='" + color + '\'' +
                ", mm=" + mm +
                '}';
    }

    public static class Builder {
        private Car car;

        public Builder() {
            car = new Car();
        }

        public Builder withModel(String model) {
            car.model = model;
            return this;
        }

        public Builder withMake(String make) {
            car.make = make;
            return this;
        }

        public Builder withCarPlate(String carPlate) {
            car.carPlate = carPlate;
            return this;
        }

        public Builder withColor(String color) {
            car.color = color;
            return this;
        }

        public Builder withMm(Integer mm) {
            car.mm = mm;
            return this;
        }

        public Builder withYear(Integer year) {
            car.year = year;
            return this;
        }

        public Car build() {
            return car;
        }


    }
}
