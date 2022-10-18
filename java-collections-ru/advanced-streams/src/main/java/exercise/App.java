package exercise;

import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String configFile) {

        return Stream.of(configFile.split("\n"))
                .filter(str -> str.startsWith("environment"))
                .flatMap(str -> Stream.of(str.split("\"")))
                .flatMap(str -> Stream.of(str.split(",")))
                .filter(str -> str.contains("X_FORWARDED_"))
                .flatMap(str -> Stream.of(str.replaceAll("X_FORWARDED_", "")))
                .collect(Collectors.joining(","));

    }
}
//END

/*Returns:
    true if the character sequence represented by the argument is a prefix
     of the character sequence represented by this string;

     */
