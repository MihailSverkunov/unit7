package pro.sisit.javacource.unit7.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataServiceJDBCImpl implements WeatherDataService {

    private final JdbcTemplate jdbcTemplate;

    public WeatherDataServiceJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String weather) {
        jdbcTemplate.update("INSERT INTO all_weather (weather) VALUES (?)", weather);

    }

    @Override
    public List<String> findAll() {
        return jdbcTemplate.query("SELECT * FROM all_weather", (rs, rowNum) -> rs.getString("weather"));

    }
}
