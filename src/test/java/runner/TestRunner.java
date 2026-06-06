package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions (

        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        dryRun = false,
        plugin = {"pretty",
                "html:target/cucumber-reports/cucucmber-html-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber-json-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failedRerun.txt"
        },
        monochrome = true   //makes console output clean and readable

)

public class TestRunner {
}
