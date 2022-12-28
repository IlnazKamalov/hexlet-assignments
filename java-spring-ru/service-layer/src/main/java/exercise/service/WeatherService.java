package exercise.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import exercise.CityNotFoundException;
import exercise.HttpClient;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import exercise.repository.CityRepository;
import exercise.model.City;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class WeatherService {

    @Autowired
    CityRepository cityRepository;

    // Клиент
    HttpClient client;

    // При создании класса сервиса клиент передаётся снаружи
    // В теории это позволит заменить клиент без изменения самого сервиса
    WeatherService(HttpClient client) {
        this.client = client;
    }

    // BEGIN
    public Map<String, String> getWeather(City city) {

        String weather = client.get("http://weather/api/v2/cities/" + city.getName());

        Map<String, String> result;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            result = objectMapper.readValue(weather, Map.class);
        } catch (JsonProcessingException error) {
            throw new CityNotFoundException("City not found");
        }

        return result;
    }
    // END
}
