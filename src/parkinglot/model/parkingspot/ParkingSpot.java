package parkinglot.model.parkingspot;

import parkinglot.Constants;
import parkinglot.model.vehicle.Vehicle;
import parkinglot.model.vehicle.VehicleType;

public abstract class ParkingSpot {

    public static int parkingAmount = 0;

    private final int parkingNumber;
    private final VehicleType suitableVehicleType;
    private Vehicle occupiedBy;
    private boolean isEmpty;

        {
        parkingAmount++;
    }

    protected ParkingSpot(VehicleType vehicleType) {
        this.parkingNumber = parkingAmount;
        this.suitableVehicleType = vehicleType;
        this.isEmpty = Constants.EMPTY;
    }

    public static ParkingSpot ofVehicleType(VehicleType vehicleType) {
        if (VehicleType.TWO_WHEEL.equals(vehicleType)) {
            return new ParkingSpotTwoWheels();
        }
        return new ParkingSpotFourWheels();
    }

    public VehicleType getSuitableVehicleType() {
        return suitableVehicleType;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }


    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Vehicle getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(Vehicle occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public void park(Vehicle vehicle){
        setOccupiedBy(vehicle);
        setIsEmpty(false);

    }

    public void vacate(){
        setIsEmpty(true);
        setOccupiedBy(null);
    }
}
