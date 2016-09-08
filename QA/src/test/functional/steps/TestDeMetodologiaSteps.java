package functional.steps;


import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import functional.pageObjects.*;


public class TestDeMetodologiaSteps {
	
	public static WebDriver driver;
	
	//url del html de prueba
	private String url=System.getProperty("test.url");
	
	BasicPage pageObject;
	
	@Before
	public void setUp() throws Exception {
		pageObject = new BasicPage(driver);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Given("^se ingresa$")
	public void se_ingresa_en() throws Throwable {
		driver.get(url);
	}

	@Then("^se verifica texto \"([^\"]*)\" en \"([^\"]*)\"$")
	public void se_verifica_texto_en(String texto, String elementKey) throws Throwable {
		assertTrue("Comparando el texto del elemento "+elementKey+" con " + texto
				, pageObject.getElement(elementKey).getText().contains(texto)
				|| texto.contains(pageObject.getElement(elementKey).getText()));
	}

}
