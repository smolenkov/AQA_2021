package Task1.plane.hierarchy;

public class LightPassengerPlane extends Plane {
	private final Integer seatingCapacity;

	public LightPassengerPlane(int seatingCapacity,
							   int flightRange,
							   int fuelConsumption,
							   String aircraftManufacturer,
							   String aircraftModel) {
		super(	flightRange,
				fuelConsumption,
				aircraftManufacturer,
				aircraftModel);
		this.seatingCapacity = seatingCapacity;
	}

	@Override
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	@Override
	public int getCargoCapacity() {
		return 0;
	}
}
