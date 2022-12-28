package exercise.controller;
import exercise.CityNotFoundException;
import exercise.model.City;
import exercise.repository.CityRepository;
import exercise.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private WeatherService weatherService;

    // BEGIN
    @GetMapping(path = "/cities/{id}")
    public Map<String, String> getWeatherCity(@PathVariable long id) {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not found"));

        return weatherService.getWeather(city);
    }

    @GetMapping(path = "/search")
    public List<Map<String, String>> getWeatherCities(@RequestParam(required = false,
            defaultValue = "") String name) {

        List<City> cities = cityRepository.findByNameStartsWithIgnoreCase(name);

        return cities
                .stream()
                .map(cityWeather -> weatherService.getWeather(cityWeather))
                .peek(cityParameters -> {
                    cityParameters.remove("cloudy");
                    cityParameters.remove("humidity");
                    cityParameters.remove("wind");
                })
                .sorted(Comparator.comparing(citySorted -> citySorted.get("name")))
                .collect(Collectors.toList());
    }
    // END
}

