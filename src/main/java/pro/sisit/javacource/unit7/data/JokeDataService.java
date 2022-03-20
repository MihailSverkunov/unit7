package pro.sisit.javacource.unit7.data;

import java.util.List;

public interface JokeDataService {

    void save(String joke);
    List<String> findAll();
}
