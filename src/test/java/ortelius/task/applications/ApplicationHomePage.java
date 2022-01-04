package ortelius.task.applications;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ApplicationHomePage {

    public static Target btnRefresh = Target.the("Refresh Button")
            .located(By.xpath("//div[@id='applist_pane']//button[text()='Refresh']"));

    public static Target tblDomain = Target.the("Domain Detail Table")
            .located(By.cssSelector("table[id='applist']"));

    public static By tblDetail = By.id("summ");
    public static By tblAllCheckbox = By.id("applist_checkall");
    public static String chkSpecificVersion = "//table[@id='applist']/descendant::td[text()='<VERSION>']/ancestor::tr[1]/td[1]";
    public static String chkSpecificRow = "//table[@id='applist']/descendant::td[text()='<VERSION>']/ancestor::tr[1]";


}
