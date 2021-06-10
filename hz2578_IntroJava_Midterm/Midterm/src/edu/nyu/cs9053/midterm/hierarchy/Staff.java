package edu.nyu.cs9053.midterm.hierarchy;
public class Staff extends Employee{
	private String title = "staff";
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}	
	public Staff(){
		super();
	}	
	public Staff(String name, int age, double salary, String title){
		super();
		super.setName(name);
		super.setAge(age);
		super.setSalary(salary);
		this.setTitle(title);
	}	
	public String toString() {
		return super.getName() + " is a " + super.getAge() + " years old staff.\n" + "salary: " + super.getSalary() + "\ntitle: " + this.title;
	}	
}