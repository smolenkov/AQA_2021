package Task1.plane.hierarchy;

import java.util.Comparator;

public class PlaneCompare implements Comparator<Plane> {

	@Override
	public int compare(Plane a1, Plane a2) {
		return Integer.compare(a1.getFlightRange(), a2.getFlightRange());
	}

}
