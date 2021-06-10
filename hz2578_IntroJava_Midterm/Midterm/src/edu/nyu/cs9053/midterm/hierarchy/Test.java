package edu.nyu.cs9053.midterm.hierarchy;
import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		ArrayList <UniversityAffiliate> universityAffiliate = new ArrayList <UniversityAffiliate>();
		universityAffiliate.add(new Administrator("a",32,4000,"ogs"));
		universityAffiliate.add(new AssistantProfessor("b",33,false,false));
		universityAffiliate.add(new AssociateProfessor("c",34,true,false));
		universityAffiliate.add(new GraduateStudent("d",35,true));
		universityAffiliate.add(new Lecturer("e",36,true,true));
		universityAffiliate.add(new Professor());
		universityAffiliate.add(new Staff("g",38,4000,"heath care"));
		universityAffiliate.add(new UndergraduateStudent());		
		for(int i = 0; i < universityAffiliate.size(); i ++) {
			//universityAffiliate.get(i).setAge(60);
			//universityAffiliate.get(i).setName("blarblar");
			System.out.println(universityAffiliate.get(i).toString());
			System.out.println(new Lecturer("i",36,true,true).equals(universityAffiliate.get(i)));
			System.out.println();
		}		
	}
}