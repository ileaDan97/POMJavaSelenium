package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    private By homePageListItems = By.cssSelector(".inventory_item_name");
    private By homePageTitle = By.cssSelector(".app_logo");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartIcon = By.cssSelector(".shopping_cart_link");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public boolean checkTitleOfHomePage() {
        return driver.findElement(homePageTitle).isDisplayed();
    }

    public int getNumberOfProductsOnHomePage(){
        return driver.findElements(homePageListItems).size();
    }

    public List<String> checkItemsAreDisplayedOnHomePage() {
        List<WebElement> homePageItemList = driver.findElements(homePageListItems);
        List<String> homePageItems = new ArrayList<>();
        for (WebElement e : homePageItemList){
            String text = e.getText();
            homePageItems.add(text);
        }
        return homePageItems;
    }

    public void clickOnAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public ShoppingCartPage clickOnTheShoppingCartIcon() {
        driver.findElement(shoppingCartIcon).click();
        return new ShoppingCartPage(driver);
    }
}