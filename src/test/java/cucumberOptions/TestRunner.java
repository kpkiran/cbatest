package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/search.feature",
        glue = "stepDefinitions",
        tags = "@testRegression", monochrome = false,
        plugin = {"pretty", "html:target/cucumber.html", "junit:target/cucumber.json", "junit:target/cukes.xml"})
public class TestRunner {
}
