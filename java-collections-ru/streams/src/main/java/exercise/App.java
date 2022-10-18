package exercise;


import java.util.List;
//import java.util.stream.IntStream;

// BEGIN
public class App {

    private static final List<String> FREE_DOMAINS = List.of("gmail.com", "yandex.ru", "hotmail.com");

    public static int getCountOfFreeEmails(List<String> emailsList) {

        long countInt = emailsList.stream()
                .filter(email -> FREE_DOMAINS.contains(email.split("@")[1]))
                .count();

        return (int) countInt;
    }
}
// END
/*Long count = emailsList.stream().filter(StringUtils::isNotBlank)
                .filter(email -> StringUtils.contains(email, "@gmail.com") ||
                        StringUtils.contains(email, "@yandex.ru") ||
                        StringUtils.contains(email, "@hotmail.com"))
                .count();
                2 возможно работает
                emailsList.stream()
                .filter(email -> FREE_DOMAINS.stream().anyMatch(i -> email.endsWith(i)))
                .count();
                3 возможно работает
                countInt = IntStream.range(0, emailsList.size())
                .filter(i -> FREE_DOMAINS.contains(emailsList.get(i)))
                .count();
*/