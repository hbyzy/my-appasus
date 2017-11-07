package com.mycompany.app.cucumber.testCase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "classpath:features",
            plugin = {"pretty", "html:target/cucumber-html-report",
                    "json:target/cucumber.json"},
            tags = "@topMenu"
    )
    public class runTest{

    }

