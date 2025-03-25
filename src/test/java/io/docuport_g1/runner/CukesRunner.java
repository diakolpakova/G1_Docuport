package io.docuport_g1.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "io.docuport_g1.step_definitions",
        plugin = {
                "pretty",
                "html:target/cucumber-html-report",
                "json:target/json-reports/json-report.json"
        },
        dryRun = false,
        tags = "@smoke"
)
public class CukesRunner {}
