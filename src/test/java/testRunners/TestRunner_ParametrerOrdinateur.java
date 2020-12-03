package testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/ParametrerOrdinateur.feature", glue = "appareils")
public class TestRunner_ParametrerOrdinateur {

}
