package edu.nyu.cs9053.midterm.hierarchy;
public class Professor extends Faculty{	
	private String title = "assistant professor";
	public String getTitle() {
		return this.title;
	}	
	public Professor(){
		super();
	}	
	public Professor(String name, int age, boolean tenured, boolean adjunct){
		super();
		super.setName(name);
		super.setAge(age);
		super.setTenured(tenured);
		super.setAdjunct(adjunct);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old professor.\n" + "tenured: " + super.isTenured() + "\nadjunct: " + super.isAdjunct();
	}	
}