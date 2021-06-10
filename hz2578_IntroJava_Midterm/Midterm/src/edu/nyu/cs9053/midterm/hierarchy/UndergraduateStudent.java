package edu.nyu.cs9053.midterm.hierarchy;
public class UndergraduateStudent extends Student{	
	public UndergraduateStudent() {
		super();
	}	
	public UndergraduateStudent(String name, int age, boolean matriculated) {
		super();
		super.setName(name);
		super.setAge(age);
		super.setMatriculated(matriculated);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old undergraduate student.\n" + super.isMatriculated();
	}	
}