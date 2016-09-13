package functional.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CreateProductPage extends BasicPage{
	
	@FindBy(id="code")
	WebElement codeInput;
	
	@FindBy(id="description")
	WebElement descriptionInput;
	
	@FindBy(css="body > form > label[for='Dilo Tu']")
	WebElement firstFactory;
	
	@FindBy(css="body > form > label[for='Remera']")
	WebElement remeraRadio;
	
	@FindBy(css="body > form > input[type='submit']")
	WebElement submit;

	public CreateProductPage(WebDriver driver) {
		super(driver);
		this.elements.put("code", codeInput);
		this.elements.put("description", descriptionInput);
		this.elements.put("factory", firstFactory);
		this.elements.put("remera", remeraRadio);
		this.elements.put("submit", submit);
	}
	
}