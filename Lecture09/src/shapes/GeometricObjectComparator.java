package shapes;

import java.util.Comparator;
public class GeometricObjectComparator<T extends GeometricObject> implements Comparator<T> {
	public int compare(T o1, T o2) {
		if (o1.getArea() > o2.getArea()) {
			return 1;
		} else if (o1.getArea().floatValue() == o2.getArea().floatValue()) {
			return 0;
		} else {
			return -1;
		}
	}
}