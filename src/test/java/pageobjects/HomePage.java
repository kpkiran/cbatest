package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public static final By searchQuery = By.xpath("//input[@id='search-input']");
    public static final By searchButton = By.xpath("//button[@id='search-button']");
    public static final By searchResults = By.xpath("//ul[@id='search-results']");
    public static final By searchError = By.xpath("//div[@id='error-empty-query']");


    public WebElement getSearch() {
        return driver.findElement(searchQuery);
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    public WebElement getSearchResults() {
        return driver.findElement(searchResults);
    }

    public WebElement getSearchError() {
        return driver.findElement(searchError);
    }
}
