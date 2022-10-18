package exercise;

import java.util.Arrays;
import java.util.stream.Stream;


// BEGIN
public class App {

    public static String[][] enlargeArrayImage(String[][] arrayImage) {

        return Arrays.stream(arrayImage)
                .flatMap(elements -> Stream.of(elements, elements))
                .map(elements -> Arrays.stream(elements)
                        .flatMap(str -> Stream.of(str, str))
                        .toArray(String[]::new))
                        .toArray(String[][]::new);
    }
}
// END
