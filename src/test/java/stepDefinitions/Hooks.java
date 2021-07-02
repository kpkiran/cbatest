package stepDefinitions;

import com.cucumber.cukesproj.CukesProj.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base {
    @After("@testRegression")
    public void afterWebValidation() {
        driver.close();
    }
}
