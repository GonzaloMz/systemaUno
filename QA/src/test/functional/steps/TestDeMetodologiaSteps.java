package functional.steps;


import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functional.pageObjects.*;


public class TestDeMetodologiaSteps {
	
	public static WebDriver driver;
	
	//url del html de prueba
	private String url=System.getProperty("test.url");
	
	private String random="";
	
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
	
	@Given("^se ingresa en \"([^\"]*)\"$")
	public void se_ingresa_en(String arg1) throws Throwable {
		driver.get(url+arg1);
		if(arg1.equals("createProduct"))
			pageObject=new CreateProductPage(driver);			
		if(arg1.equals("getProducts"))
			pageObject=new GetProductsPage(driver);			
	}

	@When("^se ingresa texto \"([^\"]*)\" en \"([^\"]*)\"$")
	public void se_ingresa_texto_en(String texto, String elemento) throws Throwable {
	    if (texto.equals("random")){
	    	Double aux=Math.floor(Math.random()*10000);
	    	texto=aux.toString();
	    	random=texto;
	    }
	    pageObject.getElement(elemento).sendKeys(texto);
	}

	@When("^click en \"([^\"]*)\"$")
	public void click_en(String elemento) throws Throwable {
		pageObject.getElement(elemento).click();
	}


	@Then("^se verifica texto \"([^\"]*)\" en \"([^\"]*)\"$")
	public void se_verifica_texto_en(String texto, String elementKey) throws Throwable {
		if  (texto.equals("random"))
			texto = random;
		assertTrue("Comparando el texto del elemento "+elementKey+" con " + texto
				, pageObject.getElement(elementKey).getText().contains(texto)
				|| texto.contains(pageObject.getElement(elementKey).getText()));
	}

}
