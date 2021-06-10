package edu.nyu.cs9053.midterm.hierarchy;
public class GraduateStudent extends Student{
	public GraduateStudent() {
		super();
	}	
	public GraduateStudent(String name, int age, boolean matriculated) {
		super();
		super.setName(name);
		super.setAge(age);
		super.setMatriculated(matriculated);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old graduate student.\n" + super.isMatriculated();
	}
}