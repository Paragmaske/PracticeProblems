package Parking;

public class ParkingLot {

	VehicleType vehicleType;
	boolean isEmpty;
	int vehicleNumberParked;
    int locationCounter;
    int inTime;
    int outTime;
    int rate;
	public ParkingLot(VehicleType vehicleType,int locationCounter) {
		this.vehicleType = vehicleType;
		this.isEmpty = true;
		this.locationCounter=locationCounter;
	}
}
