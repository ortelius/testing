package ortelius.task.login;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import ortelius.task.CommonObject;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;


public class Login {

    public static final Target txtUserName = Target.the("Username").located(By.id("username"));
    public static final Target txtPasswrod = Target.the("password").located(By.id("password"));
    public static final Target btnLogin = Target.the("Login").located(By.id("login"));
    public static final Target lnkLogout = Target.the("Logout").located(By.cssSelector("[href='Logout']"));

        public static Performable fillUserName(String userName) {

        return Task.where("Enter user name : *****",

                WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                        .seconds(),

                WaitUntil.the(txtUserName, isClickable())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                        .seconds(),

                Enter.theValue(userName).into(txtUserName));

    }

    public static Performable fillPassword(String password) {
        return Task.where("{0} Enter Password : *****",

                WaitUntil.the(txtPasswrod, isClickable())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                        .seconds(),

                Enter.theValue(password)
                        .into(txtPasswrod)
        );
    }

    public static Performable clickOnLoginButton() {
        return Task.where("Click on Login Button ",

                WaitUntil.the(Button.called("Login"), isClickable())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                        .seconds(),

                Click.on(Button.called("Login"))
        );
    }
}
