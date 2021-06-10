package edu.nyu.cs9053.midterm.hierarchy;
public abstract class Student extends UniversityAffiliate {	
	//isMatriculated which returns a Boolean
	private boolean matriculated = false;
	public void setMatriculated(boolean matriculated){
		this.matriculated = matriculated;
	}
	public boolean isMatriculated() {
		return this.matriculated;
	}
}