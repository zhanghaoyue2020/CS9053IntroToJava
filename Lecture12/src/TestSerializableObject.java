import java.io.Serializable;
import java.util.Arrays;
public class TestSerializableObject implements Serializable {
	private String name;
	private Integer id;
	private Integer[]  allInts = {5,7,1748,398,12};
	public static final long serialVersionUID = -8557234467976812143L;
	public TestSerializableObject(String name, Integer id) {		
		this.name = name;
		this.id = id;;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String toString() {
		return "TestSerializableObject [name=" + name + ", id=" + id + ", allInts=" + Arrays.toString(allInts)+", " +serialVersionUID+"]";
	}	
	public static void main(String[] args) {
		TestSerializableObject a = new TestSerializableObject("Dean", 1234567);
		System.out.println(a.toString());
	}
}