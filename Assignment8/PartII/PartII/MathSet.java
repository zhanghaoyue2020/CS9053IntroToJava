package PartII;
import java.util.HashSet;
import java.util.Set;
public class MathSet<E> extends HashSet<E> {	
	public Set<E> intersection(Set<E> s2) {
		Set<E> intersectionSet = new MathSet<E>();
		for(E elements2: s2) {
			for (E elements1: this) {
				if (elements1 == elements2)
					intersectionSet.add(elements2);
			}
		}
		return intersectionSet;
	}	
	public Set<E> union(Set<E> s2) {
		Set<E> unionSet = new MathSet<E>();
		for (E elements2: s2)
			unionSet.add(elements2);
		for (E elements1: this) 
			unionSet.add(elements1);
		return unionSet;
	}	
	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E,T>> cartesianPeoductPair = new MathSet<Pair<E,T>>();
		for(E elements1: this) {
			for (T elements2: s2) {
					cartesianPeoductPair.add(new Pair(elements1,elements2));
			}
		}
		return cartesianPeoductPair;
	}	
	public static void main(String[] args) {
		Set<String> cities = new MathSet<>();
		cities.add("New York");
		cities.add("Washington");
		Set<String> bookes = new MathSet<>();
		bookes.add("Washington");
		bookes.add("Bible");
		Set<Double> price = new MathSet<>();
		price.add(32.5);
		price.add(69.8);
		price.add(22.2);
		System.out.println("Set 1 : " + cities);
		System.out.println("Set 2 : " + bookes);
		System.out.println("Set 3 : " + price);
		System.out.println();
		System.out.println("The intersection of set 1 and set 2 : \n" + ((MathSet<String>) cities).intersection(bookes));
		System.out.println("The union of set 1 and set 2 : \n" + ((MathSet<String>) cities).union(bookes));
		System.out.println("The cartesian product of set 3 and set 2 : \n" + ((MathSet<Double>) price).cartesianProduct(bookes));
	}
}