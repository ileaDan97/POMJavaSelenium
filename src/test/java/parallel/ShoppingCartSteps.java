package parallel;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private ShoppingCartPage shoppingCartPage;

    @Then("Verify that the product is displayed on the shopping cart")
    public void checkItemInShoppingCart() {
        shoppingCartPage = homePage.clickOnTheShoppingCartIcon();
        Assert.assertTrue("The shopping cart item is not displayed", shoppingCartPage.getInventoryItem());
    }
}