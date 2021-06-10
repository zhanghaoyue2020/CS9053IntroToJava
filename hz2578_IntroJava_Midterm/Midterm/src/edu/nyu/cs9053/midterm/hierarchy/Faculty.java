package edu.nyu.cs9053.midterm.hierarchy;
public abstract class Faculty extends UniversityAffiliate{
	//isTenured which returns a boolean
	private boolean tenured = false;
	public void setTenured(boolean tenured) {
		this.tenured = tenured;
	}
	public boolean isTenured() {
		return this.tenured;
	}	
	//isAdjunct which returns a boolean
	private boolean adjunct = false;
	public void setAdjunct(boolean adjunct) {
		this.adjunct = adjunct;
	}
	public boolean isAdjunct() {
		return this.adjunct;
	}	
	/*There should be an equals() method to show 
	 * if two faculty objects have the same values 
	 * (other than name, which can be different)
	 */
	public boolean equals(UniversityAffiliate o) {
		if(o instanceof Faculty)
			return  (isTenured() == ((Faculty)o).isTenured()) &&
					(isAdjunct() == ((Faculty)o).isAdjunct()) &&
					(getAge() == ((Faculty)o).getAge()) &&
					(getTitle() == ((Faculty)o).getTitle());
		else return false;
	}	
	public abstract String getTitle();
}
