package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class App {

    public static List<String> buildAppartmentsList(List<Home> appartments, int i) {
        List<String> list = new ArrayList<>();

        for (Home appartment : appartments) {
            list.add(appartment.toString());
            if (list.size() > i) {
                Collections.swap(list, 1, 2);
                list.remove(i);
            }
        }
        return list;
    }
}