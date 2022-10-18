package exercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();// переменная для возврата результата
        Set<String> keySet = new TreeSet<>();// переменная для сортировки и вхождения ключей
        keySet.addAll(data1.keySet());
        keySet.addAll(data2.keySet());

        for (var key: keySet) {// перебираем значения
            if (!data1.containsKey(key)) {// если отсутствует в первом массиве
            result.put(key, "added");
            } else if (!data2.containsKey(key)) {// если отсутствует во втром массиве
                result.put(key, "deleted");
            } else if (data1.get(key).equals(data2.get(key))) {// если значения одинаковые(сравниваем)
                result.put(key, "unchanged");
            } else {// иначе не равны
                result.put(key, "changed");
            }
        }
        return result;
    }
}
//END
