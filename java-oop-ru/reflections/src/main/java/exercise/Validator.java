package exercise;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public static List<String> validate(Address address) {
        List<Field> fields = List.of(address.getClass().getDeclaredFields());
        return fields.stream()
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .filter(field -> {
                    Object value;
                    try {
                        field.setAccessible(true);
                        value = field.get(address);
                        field.setAccessible(false);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    return value == null;
                })
                .map(Field::getName)
                .collect(Collectors.toList());
    }
}
