package parallel;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import util.Constants;

import java.util.List;

public class HomePageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;

    @When("User is already logged in to the application")
    public void userIsAlreadyLoggedInToTheApplication() {
        DriverFactory.getDriver().get(Constants.URL);
        homePage = loginPage.doLogin();
    }

    @Then("Verify that the user is on homepage")
    public void verify_that_the_user_is_on_homepage() {
        Assert.assertTrue("The title is not displayed", homePage.checkTitleOfHomePage());
    }

    @When("Number of products from HomePage should be {int}")
    public void getNumberOfProductsFromHomePage(int number) {
        homePage.getNumberOfProductsOnHomePage();
        Assert.assertEquals("The number of products is not the same", number, homePage.getNumberOfProductsOnHomePage());
    }

    @Then("Check items are displayed on HomePage")
    public void checkItemsAreDisplayed(DataTable sectionTable) {
        List<String> expectedSectionList = sectionTable.asList();
        List<String> actualSectionList = homePage.checkItemsAreDisplayedOnHomePage();
        Assert.assertTrue(expectedSectionList.containsAll(actualSectionList));
    }

    @Given("Click on the add to cart button on Home Page")
    public void clickOnTheAddToCartButtonOnHomePage() {
        homePage.clickOnAddToCartButton();
    }

    @When("Click on the shopping cart icon")
    public void clickOnTheShoppingCartIcon() {
        homePage.clickOnTheShoppingCartIcon();
    }
}