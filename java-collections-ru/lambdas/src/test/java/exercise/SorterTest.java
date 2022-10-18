package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class SorterTest {

    @Test

    void testTakeOldestMan1 () {

        List<Map<String, String>> oneMan = List.of(
                Map.of("name", "Valentina Puchkova", "birthday", "1991-01-01"),
                Map.of("name", "May Bibi", "birthday", "1876-11-21"),
                Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                Map.of("name", "Aylin Shamshutdin", "birthday", "2021-12-27"),
                Map.of("name", "Maria Kish", "birthday", "1975-04-01"),
                Map.of("name", "Olga Pupkina", "birthday", "2000-02-02")
        );

        List<String> men1 = List.of("John Smith");
        assertThat(Sorter.takeOldestMans(oneMan)).containsExactlyElementsOf(men1);
    }

        @Test
        void testTakeOldestMan2 () {

            List<Map<String, String>> users = List.of(
                    Map.of("name", "Vladimir Nikolaev", "birthday", "1990-12-27", "gender", "male"),
                    Map.of("name", "Andrey Petrov", "birthday", "1989-11-23", "gender", "male"),
                    Map.of("name", "Anna Sidorova", "birthday", "1996-09-09", "gender", "female"),
                    Map.of("name", "John Smith", "birthday", "1989-03-11", "gender", "male"),
                    Map.of("name", "Vanessa Vulf", "birthday", "1985-11-16", "gender", "female"),
                    Map.of("name", "Alice Lucas", "birthday", "1986-01-01", "gender", "female"),
                    Map.of("name", "Elsa Oscar", "birthday", "1970-03-10", "gender", "female")
            );

            List<String> men = List.of("John Smith", "Andrey Petrov", "Vladimir Nikolaev");
            assertThat(Sorter.takeOldestMans(users)).containsExactlyElementsOf(men);
        }

        @Test
        void testTakeOldestMan3 () {

        List<Map<String, String>> usersFemale = List.of(
                Map.of("name", "Valentina Puchkova", "birthday", "1991-01-01"),
                Map.of("name", "May Bibi", "birthday", "19876-11-21"),
                Map.of("name", "Aylin Shamshutdin", "birthday", "2021-12-27"),
                Map.of("name", "Maria Kish", "birthday", "1975-04-01"),
                Map.of("name", "Olga Pupkina", "birthday", "2000-02-02")
        );

        assertThat(Sorter.takeOldestMans(usersFemale)).isEmpty();
    }
}
// END


