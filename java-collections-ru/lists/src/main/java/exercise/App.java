package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        String[] arraySymbol = symbols.toLowerCase().split("");
        String[] arrayWord = word.toLowerCase().split("");
        List<String> listSymbol = new ArrayList<>(Arrays.asList(arraySymbol));

        for (String str: arrayWord) {
            if (listSymbol.toString().contains(str)) {
                listSymbol.remove(str);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
