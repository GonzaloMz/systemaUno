package functional.pageObjects;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPage{

	private WebDriver driver;

	HashMap<String, WebElement> elements;
	
	@FindBy(id = "p") WebElement titulo;
	
	public BasicPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		elements = new HashMap<String, WebElement>();
		elements.put("titulo", this.titulo);
	}
	
	/**
	 * Retorna el valor correspondiente del hashmap elementos
	 */
	public WebElement getElement(String key){
		return elements.get(key);
	}
}
