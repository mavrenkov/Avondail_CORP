package com.conduit.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/com.conduit.step_definitions",
        features = "@target/rerun.txt",
        plugin = {
                "html:target/failed-default-report",
                "json:target/failed_report.json",
        }

)
public class FailedRunner {
}
