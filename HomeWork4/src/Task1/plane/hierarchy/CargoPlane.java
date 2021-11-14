package Task1.plane.hierarchy;

public abstract class CargoPlane extends Plane {
	private final Integer cargoCapacity;
	
	public CargoPlane(int cargoCapacity,
					  int flightRange,
					  int fuelConsumption,
					  String aircraftManufacturer,
					  String aircraftModel) {
		super(	flightRange,
				fuelConsumption,
				aircraftManufacturer,
				aircraftModel);
		
		this.cargoCapacity = cargoCapacity;
	}

	@Override
	public int getCargoCapacity() {
		return cargoCapacity;
	}
	
	@Override
	public int getSeatingCapacity() {
		return 0;
	}
}
