package ortelius.task;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonObject {

    public static final Target iconHangOn =
            Target.the("Hang On Icon")
                    .located(By.cssSelector("div[class='blockUI blockMsg blockPage']"));

  //  public static final By iconHangOn = By.cssSelector("div[class='blockUI blockMsg blockPage']");
}
