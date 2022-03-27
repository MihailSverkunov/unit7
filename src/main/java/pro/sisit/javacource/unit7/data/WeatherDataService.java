package pro.sisit.javacource.unit7.data;

import java.util.List;

public interface WeatherDataService {

    void save(String weather);
    List<String> findAll();
}
