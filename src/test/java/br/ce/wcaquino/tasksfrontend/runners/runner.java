package br.ce.wcaquino.tasksfrontend.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = "br.ce.wcaquino.tasksfrontend.stepdefinitions",
		plugin = {"pretty", "html:target/report-html", "json:target/cucumber.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		)

public class runner {
	
	

}