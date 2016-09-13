package functional.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GetProductsPage extends BasicPage{
	
	@FindBy(id="products")
	WebElement productsTable;

	public GetProductsPage(WebDriver driver) {
		super(driver);
		this.elements.put("productsTable", productsTable);
		// TODO Auto-generated constructor stub
	}
	
}