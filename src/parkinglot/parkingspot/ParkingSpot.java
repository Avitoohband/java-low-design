package parkinglot.parkingspot;

import parkinglot.vehicle.VehicleType.VehicleType;

public abstract class ParkingSpot {
    private final VehicleType vehicleType;
    private boolean isEmpty;
    private VehicleType occupiedBy;
    private int vehicleCount;


    public ParkingSpot(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        this.isEmpty = Constants.EMPTY;
        this.vehicleCount = Constants.NO_VEHICLES;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public VehicleType getOccupiedBy(){
        return this.occupiedBy;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public void setOccupiedBy(VehicleType vehicleType){
        this.occupiedBy = vehicleType;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public void park(VehicleType vehicleType){
        switch (vehicleType){
            case FOUR_WHEEL -> {
                if (!getIsEmpty()){
                    throw new ParkingSpotIsOccupiedException(
                            "Parking spot is already occupied!");
                }
                if(!this.vehicleType.equals(vehicleType)){
                    throw new ParkingSpotUnsuitableException(
                            "This parking spot is for: " + this.vehicleType.getType());
                }

                setVehicleCount(1);
                setOccupiedBy(vehicleType);
                setIsEmpty(false);
            }
            case TWO_WHEEL -> {

            }
        }
    }
}
