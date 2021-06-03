package PartII;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
public class Pair<S, T> {
	private S a;
	private T b;
	public Pair(S a, T b) {
		this.a = a;
		this.b = b;
	}	
	public S getA() {
		return this.a;
	}	
	public T getB() {
		return this.b;
	}	
	public void setA(S a) {
		this.a = a;
	}
	public void setB(T b) {
		this.b = b;
	}
	public String toString() {
		return "[Pair: " + this.a.toString() + ", " + this.b.toString() + "]";
	}
	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<String> ();
		Set<String> treeSet = new TreeSet<String> ();
		hashSet.add("xiaohua");
		hashSet.add("wuxie");
		hashSet.add("xiaoge");
		treeSet.add("xieyuchen");
		treeSet.add("guangen");
		System.out.println(new Pair(hashSet,treeSet));
	}
}
