package Task1.airline;

import java.util.ArrayList;
import java.util.List;

import Task1.plane.hierarchy.Plane;
import Task1.plane.hierarchy.PlaneCompare;

public class Airline {
    private final String airlineName;
    private final List<Plane> planes = new ArrayList<>();

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void addPlane(Plane plane) {
        planes.add(plane);
    }

    public void calculateTotalCargoPassengerCapacity() {
        int totalPassengerCapacity = 0;
        int totalCargoCapacity = 0;
        for (Plane plane : planes) {
            totalPassengerCapacity += plane.getSeatingCapacity();
            totalCargoCapacity += plane.getCargoCapacity();
        }

        System.out.println("Total passenger capacity " + totalPassengerCapacity);
        System.out.println("Total cargo capacity " + totalCargoCapacity);
    }


    public void sortPlanesByFlightRange() {
        this.planes.sort(new PlaneCompare());
    }

    public ArrayList<Plane> filterAircraftsByFuelConsumption(int min, int max, boolean showResult) {
        ArrayList<Plane> resultList = new ArrayList<>();
        for (Plane plane : this.planes) {
            int planeConsumption = plane.getFuelConsumption();
            if (planeConsumption >= min && planeConsumption <= max) {
                resultList.add(plane);
            }
        }

        if (showResult) {
            System.out.println("Min Fuel Consumption: " + min + ",  Max Fuel Consumption: " +max);
            showPlaneList(resultList);
        }

        return resultList;
    }

    public void showAirlinePlanes() {
        showPlaneList(this.planes);
    }

    private void showPlaneList(List<Plane> al) {
        System.out.println("----- Airline '" + this.getAirlineName() + "' -----");
        for (Plane plane : al) {
            System.out.println(plane);
        }
    }
}