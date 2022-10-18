package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.Objects;

// BEGIN
public class Sorter {

    public static List<String> takeOldestMans(List<Map<String, String>>  oldestMans) {
        //открываем поток
        return oldestMans.stream()
                .filter(gender -> Objects.equals(gender.get("gender"), "male"))
                .sorted(Comparator.comparing(time -> LocalDate.parse(time.get("birthday"))))
                .map(userName -> userName.get("name"))
                .toList();
    }
}
// END
