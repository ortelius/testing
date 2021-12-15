package ortelius.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Login {

    public static final By txtUserName = By.id("username");
    public static final By txtPasswrod = By.id("password");
    public static final By btnLogin = By.id("login");
    public static final By lnkLogout = By.cssSelector("[href='Logout']");

    public static Performable fillUserName(String userName) {

        return Task.where("{0} Enter user name }" + userName,
                WaitUntil.the(txtUserName, isEnabled())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                        .seconds(),
                Enter.theValue(userName).into(txtUserName));

    }

    public static Performable fillPassword(String password) {
        return Task.where("{0} Enter Password }" + password,
                Enter.theValue(password)
                        .into(txtPasswrod)
        );
    }

    public static Performable clickOnLoginButton() {
        return Task.where("Click on Login Button ",
                Click.on(Button.called("Login"))
        );
    }

    public static Performable verifyHomePage() {
       return Task.where(
               WaitUntil.the(btnLogin, isNotCurrentlyVisible())
                       .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                       .seconds()
       );
    }
}
