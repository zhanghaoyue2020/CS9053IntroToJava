package edu.nyu.cs9053.midterm.hierarchy;
public abstract class UniversityAffiliate {		
	/*getName returns a name for the person as a String. 
	 * This value is per object and not defined by the class 
	 * it should not be used for equality.
	 */
	private String name = null; 	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	/*getAge returns the age of the person as an int. 
	 * This value is per object and not defined by the class 
	 * it should be used for equality.
	 */
	private int age = 0;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	public abstract String toString();	
}