package ortelius.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ortelius.task.Applications.ApplicationHomePage;
import ortelius.task.GeneralComponents;
import ortelius.task.Login;
import ortelius.utilities.ReusableMethod;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Login_stepDefinition {

    @Given("{actor} is navigate to Login Page")
    public void user_is_navigate_to_login_page(Actor actor) {
        actor.attemptsTo(GeneralComponents.loginPage());
    }

    @When("{actor} is entered {string} username in username text box")
    public void user_is_entered_username_in_username_text_box(Actor actor, String username) {
        actor.attemptsTo(Login.fillUserName(username));
    }

    @When("{actor} is entered {string} password in password text box")
    public void user_is_entered_password_in_password_text_box(Actor actor, String password) {
        actor.attemptsTo(Login.fillPassword(password));
    }

    @And("{actor} click on login button")
    public void userClickOnLoginButton(Actor actor) {
        actor.attemptsTo(Login.clickOnLoginButton());
    }

    @Then("{actor} is able to view Home page")
    public void userIsAbleToViewHomePage(Actor actor) {

      //  BrowseTheWeb.as(actor).getDriver().navigate().refresh();

        WaitUntil.the(ApplicationHomePage.tblDomain, isEnabled())
                .forNoMoreThan(Integer.valueOf(ReusableMethod.getEnvironmentValue("minWait").trim()))
                .seconds();

        actor.should(seeThat(WebElementQuestion.the(ApplicationHomePage.tblDomain),
                WebElementStateMatchers.isEnabled()));
    }
}
