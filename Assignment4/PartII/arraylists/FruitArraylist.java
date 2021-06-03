package arraylists;
import java.util.ArrayList;
import fruit.*;
public class FruitArraylist {
	public static void main(String[] args) {		
		// this ArrayList MUST be parameterized
		ArrayList <Fruit> fruitArrayList = new ArrayList <Fruit> ();
		/*
1 non-rotten red Apple with a crisp texture and sweet taste
2 rotten green Apple objects with a soft texture and tart taste
3 non-rotten Lemon objects with a sour taste. ¡°sourness¡± should be a random integer from 0-100 for each object
2 rotten Orange objects of type ¡°mandarin¡± with a sweet taste.
		*/		
		fruitArrayList.add(new Apple("sweet","crisp","red",false));
		fruitArrayList.add(new Apple("tart","soft","green",true));		
		fruitArrayList.add(new Apple("tart","soft","green",true));		
		fruitArrayList.add(new Lemon((int)(Math.random()*100),"sour",false));
		fruitArrayList.add(new Lemon((int)(Math.random()*100),"sour",false));
		fruitArrayList.add(new Lemon((int)(Math.random()*100),"sour",false));
		fruitArrayList.add(new Orange("mandarin","sweet",true));
		fruitArrayList.add(new Orange("mandarin","sweet",true));
		for (int i = 0; i < fruitArrayList.size(); i++) {
			System.out.println(fruitArrayList.get(i).toString());
		}		 
		/*
b.Print out the average sourness of all the Lemon objects in the Arraylist. 
You have to do this by looping through the array list, 
finding the Lemon objects, and their sourness.
		 */		
		System.out.println();		
		int sum = 0;
		int num = 0;		
		for (int i = 0; i < fruitArrayList.size(); i++) {
			if (fruitArrayList.get(i) instanceof Lemon) {
				sum = sum + ((Lemon)fruitArrayList.get(i)).getSourness();
				num++;
				System.out.println(fruitArrayList.get(i).toString());
			}
			else
				continue;
		}				
		System.out.println("The average sourness of all the lemons is " + (double)sum/num);
		/*
c.Remove the matching objects: Retain the 1st rotten green Apple object in an Apple variable. 
The goal is ultimately to remove all of the Apple objects in the Arraylist that match this variable:
To start: Loop through the Arraylist and print out (using toString) which objects in the Apple object 
is equal (in value) to the Apple object in your variable. 
Also print out which object in the Arraylist is the same object as the one in your variable.
You must figure out how to remove all the matching objects from the Arraylist. 
There is no one correct way to do this. But there are incorrect ways.
		 */		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		System.out.println();		
		Apple rottenGreenApple1 = new Apple(((Apple)fruitArrayList.get(1)).getTaste(),((Apple)fruitArrayList.get(1)).getTexture(),((Apple)fruitArrayList.get(1)).getColor(),((Apple)fruitArrayList.get(1)).isRotten());
		System.out.printf( "This is the Apple we want to delete:\n" + rottenGreenApple1.toString() + "\n");
		System.out.printf( "This are all the Apples in the list:\n");
		for (int i = 0; i < fruitArrayList.size(); i++){
			if (fruitArrayList.get(i) instanceof Apple) {
				System.out.printf(fruitArrayList.get(i).toString());
				if (fruitArrayList.get(i).equals(rottenGreenApple1)) {
					System.out.printf("       This Apple will be delete.\n");
					fruitArrayList.remove(i); i--;
				}
				else
					System.out.printf("\n");
			}
			else
				continue;
		}		
		System.out.println();	
		for (int i = 0; i < fruitArrayList.size(); i++) {
			System.out.println(fruitArrayList.get(i).toString());
		}
	}
}