package exercise;

import java.time.LocalDateTime;

import exercise.daytimes.Daytime;
import exercise.daytimes.Morning;
import exercise.daytimes.Day;
import exercise.daytimes.Evening;
import exercise.daytimes.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// BEGIN
@Configuration
public class MyApplicationConfig {

    @Bean
    public Daytime myDaytime() {

        Daytime daytime;
        int time = LocalDateTime.now().getHour();

        if (time >= 6 && time < 12) {
            daytime = new Morning();
        } else if (time >= 12 && time < 18) {
            daytime = new Day();
        } else if (time >= 18 && time < 23) {
            daytime = new Evening();
        } else {
            daytime = new Night();
        }

        return daytime;
    }
}
// END
