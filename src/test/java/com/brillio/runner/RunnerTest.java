package com.brillio.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/Feature/Login.feature"},
                 glue = {"com.brillio.stepdefinitions"},
                 plugin = {"html:target/cucumber-report.html", "pretty", "json:target/cucumber-report.json" },
                 dryRun = false)

@RunWith(Cucumber.class)
public class RunnerTest {

}
