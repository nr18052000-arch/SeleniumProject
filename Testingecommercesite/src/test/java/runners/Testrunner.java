package runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
    features = "src/test/java/features",   // path to your .feature files
    glue = "stepdefinitions",              // package with step definitions
    plugin = {
        "pretty", 
        "html:target/cucumber-report.html", 
        "json:target/cucumber-report.json"
    },
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
