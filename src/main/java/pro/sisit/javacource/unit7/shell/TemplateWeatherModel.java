package pro.sisit.javacource.unit7.shell;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TemplateWeatherModel {

    private LocalDate date;
    private String city;
    private String temp;

    public String getFullInformation() {
        return String.join(" ", date.toString(), city, temp);
    }
}
