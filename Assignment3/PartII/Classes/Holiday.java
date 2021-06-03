package Classes;
public class Holiday {	
	private String name;
	private int day;
	private String month;	
	public Holiday(String name, int day,String month) {
		this.name = name;
		this.day = day;
		this.month = month;
	}	
	public static boolean inSameMonth(Holiday h1,Holiday h2) {
		return (h1.month == h2.month);
	}	
	public static double avgDate(Holiday[] holidays) {
		double sum = 0;
		for(int i=0; i < holidays.length; i++) {
			sum = holidays[i].day + sum;
		}
		return (sum /holidays.length);
	}	
	public String getName() {
		return this.name;
	}	
	public void setName(String name) {
		this.name =name;
	}
	public int getDay() {
		return this.day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getMonth() {
		return this.month;
	}
	public void setMonth(String month) {
		this.month =month;
	}
	public String toString() {
		return this.name + ": " + this.month + " " + this.day;
	}
	public static void main(String[] args) {		
		Holiday[] holidays = new Holiday[5];
		holidays[0] = new Holiday("May Day", 1, "May");
		holidays[1] = new Holiday("",1,"");
		holidays[2] = new Holiday("",1,"");
		holidays[3] = new Holiday("",1,"");
		holidays[4] = new Holiday("",1,"");		
		holidays[1].setName("Independence Day");
		holidays[1].setDay(4);
		holidays[1].setMonth("July");		
		System.out.println(holidays[0].toString());
		System.out.println(holidays[1].toString());
		System.out.println();
		System.out.println(holidays[1].getName());
		System.out.println(holidays[1].getMonth());
		System.out.println(holidays[1].getDay());
		System.out.println();
		System.out.println("The two holidays are in same month. \n" + Holiday.inSameMonth(holidays[0],holidays[1]));
		System.out.println("The average day of " + holidays.length + " holidays is " +Holiday.avgDate(holidays));
	}	
}