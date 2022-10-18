package exercise;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List<Integer> elementsNumber = new ArrayList<>();

    @BeforeEach
    /*Аннотация @BeforeEach используется для обозначения того, что аннотированный метод
    должен выполняться перед каждым методом
    @Test, @RepeatedTest, @ParameterizedTest, или @TestFactory в текущем классе
    не статический метод!
     */
    void testTake() {
        this.elementsNumber = new ArrayList<>();
        elementsNumber.add(1);
        elementsNumber.add(2);
        elementsNumber.add(3);
        elementsNumber.add(4);
        elementsNumber.add(5);
        elementsNumber.add(6);
        elementsNumber.add(7);
        elementsNumber.add(8);
        elementsNumber.add(9);
        elementsNumber.add(10);
    }

    @Test
    void testWrong1() {
        //isNull - требует null, тогда как в коде []
        assertThat(App.take(elementsNumber, 0)).isEqualTo(new ArrayList<>());
    }

    @Test
    void testWrong2() {
        /*asList Возвращает список фиксированного размера, поддерживаемый указанным массивом.
        (Изменения в возвращаемом списке «записываются» в массив.) Этот метод действует как мост между
        API-интерфейсами на основе массива и на основе коллекции в сочетании с Collection.toArray()
         */
        assertThat(App.take(elementsNumber, 5)).isEqualTo(Arrays.asList(1, 2, 3 , 4, 5));
    }

    @Test
    void testWrong3() {
        //isEmpty возвращает true, если этот список не содержит элементов
        assertThat(App.take(elementsNumber, -1)).isEqualTo(new ArrayList<>(List.of()));
    }
}
