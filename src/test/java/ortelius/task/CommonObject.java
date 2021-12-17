package ortelius.task;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class CommonObject {

    public static final Target iconHangOn =
            Target.the("Hang On Icon")
                    .located(By.cssSelector("div[class='blockUI blockMsg blockPage']"))
                    .waitingForNoMoreThan(Duration.ofSeconds(5));

}
