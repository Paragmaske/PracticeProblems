package Parking;

public class Manager {
	public static void main(String[] args) {
		ParkingSpace p = new ParkingSpace(1, 1);
		//p.parkVehicle("parag", VehicleType.XUV, 1, 1);
		//p.parkVehicle("chirag", VehicleType.XUV, 2, 2);
		p.parkVehicle("sham", VehicleType.HATCHBACK, 3, 3);
		p.parkVehicle("ram", VehicleType.HATCHBACK, 4, 4);

	//	p.unparkVehicle("parag", VehicleType.XUV, 1, 5);
//		p.unparkVehicle("chirag", VehicleType.XUV, 2, 6);
//		p.unparkVehicle("sham", VehicleType.HATCHBACK, 3, 7);
		p.unparkVehicle("ram", VehicleType.HATCHBACK, 4, 8);
	}
}
