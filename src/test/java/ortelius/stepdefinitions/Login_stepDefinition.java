package ortelius.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.ensure.web.ElementLocated;
import ortelius.task.GeneralComponents;
import ortelius.task.Login;

import java.time.Duration;

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
      actor.attemptsTo(Login.verifyHomePage());
    }
}
