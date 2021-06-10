package edu.nyu.cs9053.midterm.hierarchy;
public abstract class Employee extends UniversityAffiliate{
	//getSalary which returns a salary as a double
	private double salary = 0;
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return this.salary;
	}	
	/* Staff and Administrator classes should have the method getTitle 
	 * which returns a String indicating their job title
	 */
	public abstract String getTitle();
}