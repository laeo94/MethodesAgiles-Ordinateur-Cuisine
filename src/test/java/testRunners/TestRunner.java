package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/cuisiner.feature", glue = { "cuisine" }, monochrome = true, plugin = {
		"pretty", "html:target/HtmlReports" })

public class TestRunner {

}