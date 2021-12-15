package ortelius.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

// Custom WebDriver is using to configure Proxy Setting for WebDriver Manager
public class MyChromeDriver implements DriverSource {
    //public class MyChromeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {

            String proxyDetail = ReusableMethod.getEnvironmentValue("proxy.config.http").trim() + ":" +
                        ReusableMethod.getEnvironmentValue("proxy.config.http_port").trim();

            // Refer Proxy config details in serenity properties file
           if((ReusableMethod.getEnvironmentValue("proxy.config.webdrivermanager")).trim()
                   .equalsIgnoreCase("true"))
               WebDriverManager.chromedriver().proxy(proxyDetail).setup();
           else
                WebDriverManager.chromedriver().setup();

            return new ChromeDriver(ChromeDriverService.createDefaultService());
        }
        catch (Exception e) {
            throw new Error(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
