package parkinglot.model.vehicle;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleType == vehicle.vehicleType && Objects.equals(vehiclePlate, vehicle.vehiclePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, vehiclePlate);
    }
}
