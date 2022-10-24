package exercise;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static exercise.Car.unserialize;

public class App {

    @SneakyThrows
    public static void save(Path tempPath, Car car) {
        String jsonSerialize = car.serialize();
        Files.writeString(tempPath, jsonSerialize, StandardCharsets.UTF_8);
    }

    @SneakyThrows
    public static Car extract(Path tempPath) {
        String jsonPresentation = Files.readString(tempPath);
        Car instanceCar = unserialize(jsonPresentation);
        return instanceCar;
    }
}
