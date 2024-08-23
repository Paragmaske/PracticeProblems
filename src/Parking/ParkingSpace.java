package Parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpace {
	int xuvslots;
	int hatchbackslots;
	List<ParkingLot> slotForParking;
	int remainingSlots;
	int capacityForXUV;
	int capacityForHatchBack;

	public ParkingSpace(int xuvslots, int hatchbackslots) {
		int totalSlots = xuvslots + hatchbackslots;
		this.slotForParking = new ArrayList<ParkingLot>(totalSlots);
		this.xuvslots = xuvslots;
		this.hatchbackslots = hatchbackslots;
		int counter = 1;
		for (int i = 0; i < xuvslots; i++) {
			slotForParking.add(new ParkingLot(VehicleType.XUV, counter++));
		}

		for (int i = 0; i < hatchbackslots; i++) {
			slotForParking.add(new ParkingLot(VehicleType.HATCHBACK, counter++));
		}

	}

	void parkVehicle(String userName, VehicleType VehicleType, int vehicleNumber, int time) {
		boolean flag = false;
		for (ParkingLot p : slotForParking) {
			if (p.isEmpty && p.vehicleType == VehicleType) {
				flag = true;
				p.isEmpty = false;
				p.vehicleNumberParked = vehicleNumber;
				p.inTime = time;
				p.rate = (VehicleType == VehicleType.HATCHBACK) ? new HATCHBACKPrice().priceAccToVehicleType()
						: new XUVPrice().priceAccToVehicleType();
				System.out.println(userName + "your vehicle" + vehicleNumber + "is parked at " + p.locationCounter);
				return;
			}
		}
		if (!flag) {
			if (VehicleType == VehicleType.XUV) {
				System.out.println("sorry the parking slot is full");
				return;
			} else {
				if (VehicleType == VehicleType.HATCHBACK) {
					for (ParkingLot p : slotForParking) {
						if (p.isEmpty && p.vehicleType == VehicleType.XUV) {
							flag = true;
							p.isEmpty = false;
							p.vehicleNumberParked = vehicleNumber;
							p.inTime = time;
							p.rate = new HATCHBACKPrice().priceAccToVehicleType();
							System.out.println(userName + "your vehicle" + vehicleNumber + "is parked at "
									+ p.locationCounter + " on Xuv slot as other slots are full");
							return;
						}
					}
				}
			}
		}
		if (!flag)
			System.out.println("sorry the parking slot is full");

	}

	void unparkVehicle(String userName, VehicleType VehicleType, int vehicleNumber, int outTime) {
		boolean flag = false;
		for (ParkingLot p : slotForParking) {
			if (p.vehicleNumberParked == vehicleNumber && p.isEmpty == false) {
				flag = true;
				p.isEmpty = true;
				System.out.println("your vehicle " + vehicleNumber + " is unparked");
				System.out.println("please pay" + (outTime - p.inTime) * p.rate);
			}
		}
		if (!flag)
			System.out.println("no vehicle tto unpark");
	}

}
