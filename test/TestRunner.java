import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "testRunner",
        features = "./features",
        dryRun=false
)
public class TestRunner {
    //Run this from Maven or as JUnit
}