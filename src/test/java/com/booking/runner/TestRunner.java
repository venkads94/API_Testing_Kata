package com.booking.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = {"com.booking.stepdefinitions","com.booking.config"}, publish = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
