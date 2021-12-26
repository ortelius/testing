package ortelius.task;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class CommonObject {
    public static final Target iconHangOn =
            Target.the("Hang On Icon")
                    .located(By.cssSelector("[src='css/images/cowandspaceship-animated.gif']"))
                    .waitingForNoMoreThan(Duration.ofSeconds(2));

}
