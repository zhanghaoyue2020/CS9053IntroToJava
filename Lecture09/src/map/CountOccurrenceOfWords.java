package map;
import java.util.Map;
import java.util.TreeMap;
public class CountOccurrenceOfWords {
	public static void main(String[] args) {    
		// Set text in a string
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun! Hope you have a good time. ";
		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new TreeMap<>();
		String[] words = text.split("[\\s+\\p{P}]");
		System.out.println("length of text:  " + words.length);
		for (String word:words) {
			word = word.toLowerCase();
			if (word.length() > 0) {
				if (!map.containsKey(word)) {
					map.put(word, 1);
				}
				else {
					int value = map.get(word);
					value++;
					map.put(word, value);
				}
			}
		}
		// Display key and value for each entry
		map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
}