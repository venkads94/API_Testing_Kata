package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "com.booking.stepdefinitions", publish = true, tags = "@positive or @negative")
public class TestRunner extends AbstractTestNGCucumberTests {

}
