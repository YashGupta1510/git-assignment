import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Counter {
	public static Map<String, Long> generateMap(String data) {
		
		//Converting to stream of words 
		//(\\W+) splits into words and ignores all non word characters such as spaces, punctuation, etc.
		Stream<String> dataStream = Arrays.stream(data.split("\\W+"));
		
        // Process the content to count word frequencies 
		Map<String, Long> wordMap = dataStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
		return wordMap;
	}
}
