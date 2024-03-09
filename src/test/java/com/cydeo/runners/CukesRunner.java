package com.cydeo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "C:\\Users\\cihan\\IdeaProjects\\cydeo-cucumber-junit-project\\src\\test\\resources\\features",
        glue = "com/cydeo/step_definitons",
        dryRun = false,
        tags = "",
        publish = true // generating a report with public link
       // ,monochrome = true


)
public class CukesRunner { }
