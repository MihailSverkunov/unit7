package pro.sisit.javacource.unit7.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JokeDataServiceJDBCImpl implements JokeDataService {

    private final JdbcTemplate jdbcTemplate;

    public JokeDataServiceJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String joke) {
        jdbcTemplate.update("INSERT INTO jokes (joke) VALUES (?)", joke);

    }

    @Override
    public List<String> findAll() {
        return jdbcTemplate.query("SELECT * FROM jokes", (rs, rowNum) -> rs.getString("joke"));

    }
}
