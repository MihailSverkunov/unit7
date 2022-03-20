package pro.sisit.javacource.unit7.shell;


import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import pro.sisit.javacource.unit7.data.JokeDataService;
import pro.sisit.javacource.unit7.web.JokeService;

import java.util.Objects;
import java.util.stream.Collectors;

@ShellComponent
public class JokeShellCommands {

    public final JokeService jokeService;
    private final JokeDataService jokeDataService;
    private String lastJoke;

    public JokeShellCommands(JokeService jokeService, JokeDataService jokeDataService) {
        this.jokeService = jokeService;
        this.jokeDataService = jokeDataService;
    }

    @ShellMethod("Get joke")
    public String joke(){
        lastJoke = jokeService.getJoke();

        return lastJoke;
    }

    @ShellMethod("Save joke")
    public String save(){
        if (Objects.isNull(lastJoke)){
            return "Сначала загрузите шутку";
        }
        jokeDataService.save(lastJoke);
        return "Joke saved";

    }

    @ShellMethod("Show all jokes")
    public String show(){
        return jokeDataService.findAll().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
