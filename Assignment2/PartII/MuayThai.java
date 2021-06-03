import java.util.Scanner;
public class MuayThai {
	public static int getMinWeight(int weight) {
		// this takes a weight and returns the "min weight" for the
		// weight class
		if ((0 <= weight)&&(weight <112))
			return 0;		
		else if ((112 <= weight)&&(weight < 115))
			return 112;	
		else if ((115 <= weight)&&(weight < 118))
			return 115;
		else if ((118 <= weight)&&(weight < 122))
			return 118;	
		else if ((122 <= weight)&&(weight < 126))
			return 122;
		else if ((126 <= weight)&&(weight < 130))
			return 126;
		else if ((130 <= weight)&&(weight < 135))
			return 130;
		else if ((135 <= weight)&&(weight < 140))
			return 135;
		else if ((140 <= weight)&&(weight < 147))
			return 140;
		else if ((147 <= weight)&&(weight < 154))
			return 147;
		else if ((154 <= weight)&&(weight < 160))
			return 154;
		else if ((160 <= weight)&&(weight < 167))
			return 160;
		else if ((167 <= weight)&&(weight < 175))
			return 167;
		else if ((175 <= weight)&&(weight < 183))
			return 175;	
		else if ((183 <= weight)&&(weight < 190))
			return 183;
		else if ((190 <= weight)&&(weight < 220))
			return 190;
		else if (220 <= weight)
			return 220;
		return -1;
	}
	public static String getWeightClass(int weight) {
		String weightClass = null;
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		switch (weight) {
		case (0): weightClass = "Flyweight";break;
		case (112): weightClass = "Super flyweight";break;
		case (115): weightClass = "Bantamweight";break;
		case (118): weightClass = "Super bantamweight";break;
		case (122): weightClass = "Featherweight";break;
		case (126): weightClass = "Super featherweight";break;
		case (130): weightClass = "Lightweight";break;
		case (135): weightClass = "Super lightweight";break;
		case (140): weightClass = "Welterweight";break;
		case (147): weightClass = "Super welterweight";break;
		case (154): weightClass = "Middleweight";break;
		case (160): weightClass = "Super Middleweight";break;
		case (167): weightClass = "Light heavyweight";break;
		case (175): weightClass = "Super light heavyweight";break;
		case (183): weightClass = "Cruiserweight";break;
		case (190): weightClass = "Heavyweight";break;
		case (220): weightClass = "Super Heavyweight";break;
		}
		return weightClass;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();
		int minPounds = getMinWeight(pounds);
		String weightClass = getWeightClass(minPounds);
		// if pounds is greater than zero
		if (minPounds >= 0) 
			System.out.println("Weight class for " + pounds + " is " + weightClass );
		// if for some reason you put in a negative number of pounds:
		if (minPounds == -1)
			System.out.println("Invalid weight value");
	}
}