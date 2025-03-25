package io.docuport_g1.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/json-reports/json-report.json",
                "html:target/cucumber-html-report"
        },
        features = "src/test/resources/features",
        glue = "io.docuport_g1.step_definitions",
        dryRun = false,
        monochrome = true,
        tags = "" // or remove if you want all features to run
)
public class CukesRunner {
}
