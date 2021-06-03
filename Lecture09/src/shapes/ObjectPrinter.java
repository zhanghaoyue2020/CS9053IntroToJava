package shapes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class ObjectPrinter<T extends GeometricObject> {
	private HashSet<T> objSet = new HashSet<T>();
	public void add(T t) {
		objSet.add(t);
	}
	public void printObjects() {
		for (T t : objSet) {
			System.out.println(t);
		}
	}
	public static ObjectPrinter<GeometricObject> appendList(ObjectPrinter<GeometricObject> origList, List<? extends GeometricObject> newItemList) {
		for (GeometricObject item : newItemList) {
			origList.add(item);
		}
		return origList;
	}
	public static ObjectPrinter<GeometricObject> appendCircleList(ObjectPrinter<GeometricObject> origList,List<Circle> newItemList) {
		for (Circle item : newItemList) {
			origList.add(item);
		}
		return origList;
	}
	public static ObjectPrinter<GeometricObject> appendList(ObjectPrinter<GeometricObject> origList, GeometricObject go) {
		origList.add(go);
		return origList;
	}
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Circle circle2 = new Circle(7);
		Rectangle rect = new Rectangle(4,5);
		Integer newInt = new Integer(5);
		ArrayList<Integer> al3 = new ArrayList<Integer>();
		al3.add(newInt);
		ObjectPrinter<GeometricObject> objectPrinter = new ObjectPrinter<GeometricObject>();
		objectPrinter.add(rect);
		objectPrinter.printObjects();
		ArrayList<Circle> al2 = new ArrayList<Circle>();
		al2.add(circle);
		al2.add(circle2);
		ObjectPrinter.appendList(objectPrinter, al2);
		objectPrinter.printObjects();
	//	objectPrinter.add(newInt);
	}
}