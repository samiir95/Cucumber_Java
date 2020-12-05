package com.tau.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(glue = { "com.tau.steps" }, features = "src/test/resources", plugin = { "pretty",
		"html:target/site/cucumber-pretty", "json:target/cucumber.json" })

public class RunCucumberTests extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
