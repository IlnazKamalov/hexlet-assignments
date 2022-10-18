package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {

    public static Map<String, Integer> getWordCount(String sentence) {

        Map<String, Integer> map = new HashMap<>();

        if (sentence.length() == 0) {
            return map;
        }

        String[] words = sentence.split(" ");

        for (String word: words) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        return map;
    }
    public static String toString(Map<String, Integer> map) {

        if (map.isEmpty()) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder("{\n");

        for (String word: map.keySet()) {
            stringBuilder.append(String.format("  %s: %d\n", word, map.get(word)));
        }
        return stringBuilder.append("}").toString();
    }
}
//END
