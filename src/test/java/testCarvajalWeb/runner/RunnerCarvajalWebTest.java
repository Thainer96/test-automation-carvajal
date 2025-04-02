package testCarvajalWeb.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"testCarvajalWeb.stepDefinitions","testCarvajalWeb.hooks"},
        tags = "@Employee",
        plugin= {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class RunnerCarvajalWebTest {
}
