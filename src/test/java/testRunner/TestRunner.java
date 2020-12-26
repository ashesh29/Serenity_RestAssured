package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@Test",
        plugin = {"json:target/Cucumber/Cucumber.json",
                "junit:target/Cucumber/Cucumber.xml"},
        monochrome = true)
public class TestRunner {

}
