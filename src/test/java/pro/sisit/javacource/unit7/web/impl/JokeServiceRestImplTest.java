package pro.sisit.javacource.unit7.web.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.shell.jline.ScriptShellApplicationRunner;
import pro.sisit.javacource.unit7.web.JokeService;

@SpringBootTest( properties = {
        InteractiveShellApplicationRunner
                .SPRING_SHELL_INTERACTIVE_ENABLED + "=false",
        ScriptShellApplicationRunner
                .SPRING_SHELL_SCRIPT_ENABLED + "=false"
})
class JokeServiceRestImplTest {

    @Autowired
    private JokeService restTemplate;

    @Test
    void getJoke() {
        String joke = restTemplate.getJoke();
        Assertions.assertNotNull(joke);
        Assertions.assertTrue(joke.contains("Chuck Norris"));

        System.out.println(joke);

    }
}