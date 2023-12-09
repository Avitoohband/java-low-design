package parkinglot.model.vehicle;

import java.util.UUID;

public class Vehicle {

    private final VehicleType vehicleType;
    private final String vehiclePlate;

    public static Vehicle ofType(VehicleType vehicleType) {
        return new Vehicle(vehicleType, generateRandomPlate());
    }

    private static String generateRandomPlate() {
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 8);
    }

    private Vehicle(VehicleType vehicleType, String vehiclePlate) {
        this.vehicleType = vehicleType;
        this.vehiclePlate = vehiclePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }
}
