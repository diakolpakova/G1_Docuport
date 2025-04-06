package io.docuport_g1.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:target/cucumber.json",         // ✅ This generates the JSON report
                "html:target/cucumber-html-report"   // Optional, generates HTML report
        },
        features = "src/test/resources/features",
        glue = "io.docuport_g1.step_definitions",
        monochrome = true,
        dryRun = false,
        tags = "@smoke"
)

public class CukesTest {}
