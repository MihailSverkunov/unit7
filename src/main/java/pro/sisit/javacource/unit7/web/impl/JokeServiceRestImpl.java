package pro.sisit.javacource.unit7.web.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pro.sisit.javacource.unit7.dto.JokeDTO;
import pro.sisit.javacource.unit7.web.JokeService;

@Service
public class JokeServiceRestImpl implements JokeService {

    private RestTemplate restTemplate;
    private static String URL = "http://api.icndb.com/jokes/random";

    public JokeServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getJoke() {
        ResponseEntity<JokeDTO> responseEntity = restTemplate.getForEntity(URL, JokeDTO.class);

        return responseEntity.getBody().getValue().getJoke();
    }
}
