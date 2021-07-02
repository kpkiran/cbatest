package Utils;

import com.cucumber.cukesproj.CukesProj.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkUtils extends Base {

    public static WebElement waitForPresenceOfElement(By type, long timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(type));
    }
}
