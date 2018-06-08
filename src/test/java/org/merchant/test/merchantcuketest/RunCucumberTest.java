package org.merchant.test.merchantcuketest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json"}, glue = { "org.merchant.test.steps"})
public class RunCucumberTest {
}
