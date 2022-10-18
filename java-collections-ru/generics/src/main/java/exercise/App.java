package exercise;


import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> words) {

        List<Map<String, String>> result = new ArrayList<>();// лист для вывода результата

        for (var items: books) {
            boolean checkEntry = true;
            for (var entry: words.entrySet()) {
                if(!words.getOrDefault(entry.getKey(), "").equals(items.getOrDefault(entry.getKey(), ""))) {
                    checkEntry = false;
                    break;
                }
            }
            if (checkEntry) {
                result.add(items);
            }
        }
        return result;
    }
}
//END
