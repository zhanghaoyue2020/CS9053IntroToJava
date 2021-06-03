package shapes;
import java.util.ArrayList;
public class ListShapes {
	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		shapeList.add(new Rectangle(4,5));
		shapeList.add(new Circle(2));
		shapeList.add(new Circle(5));
	//	shapeList.sort((a, b) -> (a.compareTo(b)));
		shapeList.sort(new GeometricObjectComparator<GeometricObject>());
		for (int i = 0; i < shapeList.size();i++) {
			GeometricObject shape = shapeList.get(i);
			System.out.println(shape.toString());
		}
	}
}