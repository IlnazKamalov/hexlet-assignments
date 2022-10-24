package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.Value;

@Value
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    @SneakyThrows
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    @SneakyThrows
    public static Car unserialize(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Car.class);
    }
}
