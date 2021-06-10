package edu.nyu.cs9053.midterm.hierarchy;
public class AssistantProfessor extends Faculty{	
	private String title = "assistant professor";
	public String getTitle() {
		return this.title;
	}	
	public AssistantProfessor(){
		super();
	}	
	public AssistantProfessor(String name, int age, boolean tenured, boolean adjunct){
		super();
		super.setName(name);
		super.setAge(age);
		super.setTenured(tenured);
		super.setAdjunct(adjunct);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old assistant professor.\n" + "tenured: " + super.isTenured() + "\nadjunct: " + super.isAdjunct();
	}
}