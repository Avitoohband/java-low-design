package parkinglot.vehicle.VehicleType;

public enum VehicleType {

    TWO_WHEEL(2, "two_wheels"), FOUR_WHEEL(4, "four_wheels");

    private final int wheels;
    private final String type;

    VehicleType(int wheels, String type) {
        this.wheels = wheels;
        this.type = type;
    }
    public int getWheels(){
        return wheels;
    }

    public String getType(){
        return this.type;
    }
}
