package edu.nyu.cs9053.midterm.hierarchy;
public class AssociateProfessor extends Faculty{
	private String title = "associate professor";
	public String getTitle() {
		return this.title;
	}	
	public AssociateProfessor(){
		super();
	}	
	public AssociateProfessor(String name, int age, boolean tenured, boolean adjunct){
		super();
		super.setName(name);
		super.setAge(age);
		super.setTenured(tenured);
		super.setAdjunct(adjunct);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old associate professor.\n" +"tenured: " + super.isTenured() + "\nadjunct: " + super.isAdjunct();
	}
}