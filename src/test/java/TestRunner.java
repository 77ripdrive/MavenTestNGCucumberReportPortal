import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

import driver.DriverSingleton;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "test")
public class TestRunner {
    @Before

    @After
        public void stopBrowser()
    {       DriverSingleton.closeDriver();
    }
}





