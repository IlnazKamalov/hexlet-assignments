package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


class AppTest {

    @Test
    void testBuildAppartmentsList1() {
        List<Home> appartments = new ArrayList<>(List.of(
            new Flat(41, 3, 10),
            new Cottage(125.5, 2),
            new Flat(80, 10, 2),
            new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "Квартира площадью 44.0 метров на 10 этаже",
            "Квартира площадью 90.0 метров на 2 этаже",
            "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildAppartmentsList(appartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildAppartmentsList2() {
        List<Home> appartments = new ArrayList<>(List.of(
            new Cottage(100, 1),
            new Flat(190, 10, 2),
            new Flat(180, 30, 5),
            new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "1 этажный коттедж площадью 100.0 метров",
            "Квартира площадью 200.0 метров на 2 этаже",
            "Квартира площадью 210.0 метров на 5 этаже",
            "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildAppartmentsList(appartments, 4);
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void testBuildAppartmentsList3() {
        List<Home> appartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildAppartmentsList(appartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    void testReversedSequenceFromToString() {
        String reverse = "abcdef";
        CharSequence text = new ReversedSequence(reverse);
        CharSequence expected = "fedcba";
        assertThat(text.toString()).isEqualTo(expected);
    }

    @Test
    void testReversedSequenceCharAt() {
        CharSequence text = new ReversedSequence("321");
        char expected = '2';
        assertThat(text.charAt(1)).isEqualTo(expected);
    }

    @Test
    void testReversedSequenceFromLength() {
        CharSequence text = new ReversedSequence("1");
        CharSequence expected = "1";
        assertThat(text.length()).isEqualTo(expected.length());
    }

    @Test
    void testReversedSequence() {
        CharSequence text = new ReversedSequence("mnbvcxz");
        String expected = "xcvb";
        assertThat(text.subSequence(1, 5)).isEqualTo(expected);
    }
    // END
}
