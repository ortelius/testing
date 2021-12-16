package ortelius.task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ortelius.utilities.ReusableMethod;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;


public class Login {

    public static final Target txtUserName = Target.the("Username").located(By.id("username"));
    public static final Target txtPasswrod = Target.the("password").located(By.id("password"));
    public static final Target btnLogin = Target.the("Login").located(By.id("login"));
    public static final Target lnkLogout = Target.the("Logout").located(By.cssSelector("[href='Logout']"));

        public static Performable fillUserName(String userName) {

        return Task.where("{0} Enter user name }" + userName,

                WaitUntil.the(txtUserName, isClickable())
                        .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                        .seconds(),

                Enter.theValue(userName).into(txtUserName));

    }

    public static Performable fillPassword(String password) {
        return Task.where("{0} Enter Password }" + password,

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

                 Click.on(Button.called("Login")),

                 WaitUntil.the(CommonObject.iconHangOn, isEmpty())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                .seconds()

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