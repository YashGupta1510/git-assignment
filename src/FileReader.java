
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FileReader {
	
	static Map<String, Long> wordMap;
	
	public static void read(String fileName) {
		
		try {
			File file = new File("resources/" + fileName);
			
			// Reading file
			StringBuilder contentBuilder = new StringBuilder();
			Scanner ob = new Scanner(file);
			while (ob.hasNextLine()) {
			    contentBuilder.append(ob.nextLine()).append(" ");
			}
			ob.close();
			
			//Converting it to lowercase to remove duplicacy with case sensitivity
			String content = contentBuilder.toString().toLowerCase();

			wordMap = Counter.generateMap(content);
			
			} catch (IOException e) {
	            System.err.println("Error reading the file: " + e.getMessage());
	        } 
		
	}
	
	public static void display() {
		// Print the word frequencies
		wordMap.forEach((word, count) -> System.out.println(word + ": " + count));
	}
	
}