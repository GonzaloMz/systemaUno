package functional;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import functional.steps.TestDeMetodologiaSteps;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/functional/features", plugin={"json:reporte.json"}, glue="", tags={"@Run"})
public class TestDeMetodologia {

	
	@BeforeClass
	public static void before(){
		System.setProperty("webdriver.firefox.marionette", "false");
		System.setProperty("test.url","http://127.0.0.1:3000/");
		TestDeMetodologiaSteps.driver=new FirefoxDriver();
	}
	
	@AfterClass
	public static void after(){
		TestDeMetodologiaSteps.driver.quit();
	}
}
