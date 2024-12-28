package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;

    private By shoppingCartItem = By.cssSelector(".inventory_item_name");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getInventoryItem() {
        return driver.findElement(shoppingCartItem).isDisplayed();
    }
}