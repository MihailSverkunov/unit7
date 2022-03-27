package pro.sisit.javacource.unit7.shell;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import pro.sisit.javacource.unit7.data.WeatherDataService;
import pro.sisit.javacource.unit7.web.WeatherService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@ShellComponent
public class WeatherShellCommands {
    public final WeatherService weatherService;
    private final WeatherDataService weatherDataService;
    private TemplateWeatherModel lastWeather;

    public WeatherShellCommands(WeatherService weatherService, WeatherDataService jokeDataService) {
        this.weatherService = weatherService;
        this.weatherDataService = jokeDataService;
        lastWeather = new TemplateWeatherModel();
    }


    @ShellMethod("Get Weather")
    public String weather(@ShellOption(defaultValue = "Красноярск") String city) {
        lastWeather.setDate(LocalDate.now());
        lastWeather.setTemp(weatherService.getWeather(city));
        lastWeather.setCity(city);

        return lastWeather.getFullInformation();

    }

    @ShellMethod("Save weather")
    public String save() {
        if (Objects.isNull(lastWeather)) {
            return "Сначала загрузите погоду";
        }
        weatherDataService.save(lastWeather.getFullInformation());
        return "Weather saved";

    }

    @ShellMethod("Show all weather")
    public String show() {
        return weatherDataService.findAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
