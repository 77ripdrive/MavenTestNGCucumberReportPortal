package test;

import cucumber.api.CucumberOptions;


import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src\\test\\resources\\features\\Cloud.feature",
        strict = true,
        plugin = {
                "pretty", "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests{

}





