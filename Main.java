import java.util.HashMap;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String banned[] = {"Hit"};
		mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit", banned);
	}
	
	public static String mostCommonWord(String paragraph, String[] banned) {
		HashSet<String> bannedWords = new HashSet<>();
		for (String word: banned) {
			bannedWords.add(word);
		}
		
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		for (String word : paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
			if(!bannedWords.contains(word))
			counts.put(word, counts.getOrDefault(word, 0)+ 1);
		}
		System.out.println(counts);
		String result = "";
		for (String key: counts.keySet()){
			if(result.equals("") || counts.get(key) > counts.get(result)){
				result = key;
			}
		}
		System.out.println(result);
		return result;
		
	}

}
