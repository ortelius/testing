package ortelius.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ortelius.task.applications.ApplicationHomePage;
import ortelius.task.CommonObject;
import ortelius.task.GeneralComponents;
import ortelius.task.Login;
import ortelius.utilities.ReusableMethod;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class Login_stepDefinition {

    @Given("{actor} is navigate to Login Page")
    public void user_is_navigate_to_login_page(Actor actor) {
        actor.attemptsTo(GeneralComponents.loginPage());
    }

    @When("{actor} is entered username in username text box")
    public void user_is_entered_username_in_username_text_box(Actor actor) {
        actor.attemptsTo(Login.fillUserName(ReusableMethod.getEnvironmentValue("app.username").trim()));
        Ensure.that(Login.txtUserName).text()
                .isEqualTo(ReusableMethod.getEnvironmentValue("app.username").trim());
    }

    @When("{actor} is entered password in password text box")
    public void user_is_entered_password_in_password_text_box(Actor actor) {
        actor.attemptsTo(Login.fillPassword(ReusableMethod.getEnvironmentValue("app.password").trim()));
        Ensure.that(Login.txtPasswrod).text()
                .isEqualTo(ReusableMethod.getEnvironmentValue("app.password").trim());
    }

    @And("{actor} click on login button")
    public void userClickOnLoginButton(Actor actor) {
        actor.attemptsTo(Login.clickOnLoginButton());
    }

    @Then("{actor} is able to view Home page")
    public void userIsAbleToViewHomePage(Actor actor) throws InterruptedException {

        WaitUntil.the(CommonObject.iconHangOn, isNotVisible())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("maxWait").trim()))
                .seconds();

        actor.should(seeThat(WebElementQuestion.the(ApplicationHomePage.tblDomain),
                WebElementStateMatchers.isNotEmpty()));
    }
}
