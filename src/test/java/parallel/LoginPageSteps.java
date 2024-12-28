package parallel;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import util.Constants;

public class LoginPageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("The user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        DriverFactory.getDriver().get(Constants.URL);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("Provide the login credentials for standard user")
    public void provide_the_login_credentials() {
        loginPage.insertUsernameAndPassword();
    }

    @When("Click on the login button")
    public void click_on_the_login_button() {
        loginPage.clickOnLoginButton();
    }
}