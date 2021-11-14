package Task1.main;

import Task1.plane.instances.*;
import Task1.plane.hierarchy.Plane;
import Task1.airline.Airline;

public class Main {
	public static void main(String[] args) {
		Plane planeAirbusA380A = new PlaneAirbusA380();
		Plane planeAirbusA380B = new PlaneAirbusA380();
		Plane planeDouglas = new PlaneDouglasMD11F();
		Plane planeCessna = new PlaneCessna172();
		Plane planeBoeing = new PlaneBoeing737();
		
		Airline LEVEL = new Airline("LEVEL");
		LEVEL.addPlane(planeAirbusA380A);
		LEVEL.addPlane(planeAirbusA380B);
		LEVEL.addPlane(planeDouglas);
		LEVEL.addPlane(planeCessna);
		LEVEL.addPlane(planeBoeing);
		
		LEVEL.showAirlinePlanes();

		System.out.println();
		System.out.println("Planes sorted by flight range:");
		LEVEL.sortPlanesByFlightRange();
		LEVEL.showAirlinePlanes();
		System.out.println();
		
		LEVEL.filterAircraftsByFuelConsumption(2000, 3000, true);
		System.out.println();
		
		LEVEL.calculateTotalCargoPassengerCapacity();
	}
}
