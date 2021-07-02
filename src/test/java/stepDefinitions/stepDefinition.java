package stepDefinitions;

import Utils.FrameworkUtils;
import com.cucumber.cukesproj.CukesProj.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.HomePage;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
public class stepDefinition extends Base {

    public WebDriver driver = null;
    public HomePage homePage;

    @Given("^User is on the landing page$")
    public void user_is_on_the_landing_page() throws Throwable {
        driver =  Base.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^User searched for (.+)$")
    public void User_searched_for(String places) throws InterruptedException {
            homePage = new HomePage(driver);

            Assert.assertTrue(homePage.getSearch().isDisplayed());
            Assert.assertTrue(homePage.getSearchButton().isDisplayed());

            homePage.getSearch().sendKeys(places);
            homePage.getSearchButton().click();
    }

    @Then("^(.+) results are displayed$")
    public void results_are_displayed(String places) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(homePage.getSearchResults().isDisplayed());
    }

    @When("^the user clicks on search button$")
    public void the_user_clicks_on_search_button()  {
        homePage = new HomePage(driver);
        homePage.getSearchButton().click();
        FrameworkUtils.waitForPresenceOfElement(HomePage.searchError, 30);
    }

    @Then("^an error message should be displayed$")
    public void an_error_message_should_be_displayed() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HomePage.searchError));

        String errMsg = homePage.getSearchError().getText();
        Assert.assertEquals("Provide some query", errMsg);
    }
}
