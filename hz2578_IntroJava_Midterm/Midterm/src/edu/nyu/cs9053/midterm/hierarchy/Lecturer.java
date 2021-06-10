package edu.nyu.cs9053.midterm.hierarchy;
public class Lecturer extends Faculty{	
	private String title = "lecturer";
	public String getTitle() {
		return this.title;
	}	
	public Lecturer(){
		super();
	}	
	public Lecturer(String name, int age, boolean tenured, boolean adjunct){
		super();
		super.setName(name);
		super.setAge(age);
		super.setTenured(tenured);
		super.setAdjunct(adjunct);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old lecturer.\n" +	"tenured: " + super.isTenured() + "\nadjunct: " + super.isAdjunct();
	}	
}