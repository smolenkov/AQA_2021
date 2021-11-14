package Task1.plane.hierarchy;

public abstract class CommercialPassengerPlane extends Plane {
	private final Integer seatingCapacity;
	private final Integer cargoCapacity;
	
	public CommercialPassengerPlane(int seatingCapacity,
									int cargoCapacity,
									int flightRange,
									int fuelConsumption,
									String aircraftManufacturer,
									String aircraftModel) {
		super(	flightRange,
				fuelConsumption,
				aircraftManufacturer,
				aircraftModel);
		this.seatingCapacity = seatingCapacity;
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	@Override
	public int getCargoCapacity() {
		return cargoCapacity;
	}
}
