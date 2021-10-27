package com.melon.CucumberAPITestingFramework.cuke.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


// 2 plugins for reports (Maven Cucumber Reporting and Extent reporting)
// Maven Cucumber reporting 
@CucumberOptions(features= {"src/test/resources/features"},
                 glue="com.melon.CucumberAPITestingFramework.cuke.steps",
                 plugin = {"pretty","html:reports/cucumber-html-report","json:reports/cucumber-reports/cucumber.json","junit:reports/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunCuke extends AbstractTestNGCucumberTests {

}
