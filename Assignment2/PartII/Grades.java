public class Grades {
	public static String letterGrade(float score) {
		if ((90 <= score)&& (score <= 100))
			return "A";
		if ((80 <= score)&&(score <= 89))
			return "B";
		if ((70 <= score)&&(score <= 79))
			return "C";
		if ((60 <= score)&&(score <= 69))
			return "D";
		if ((0 <= score)&&(score <= 59))
			return "F";
		return null;
	}
	public static void main(String[] args) {
		/* you probably want to use user input for the
		 * score using Scanner because you will have to convert
		 * a command line argument to a float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "score" variable
		 * to whatever you want in the code, and that's fine too
		 */
		float score = 91;
		String grade = letterGrade(score);
		// if the grade is not null print this out:
		if (grade!=null)
		System.out.println("The grade for a score of " + score + " is " + grade);
		// if the grade is null, print this out:
		if (grade==null)
		System.out.println("invalid score");
	}
}