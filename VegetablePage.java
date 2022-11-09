package PageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ScreenShots;
import Utilities.WaitHelper;

public class VegetablePage {
	public WebDriver ldriver;
	WaitHelper helper;
	ScreenShots screenShot;
	public String item;
	public String colData;

	public VegetablePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		helper = new WaitHelper(ldriver);
		screenShot = new ScreenShots();
	}

	@FindBy(xpath = "//input[@placeholder='Search for Vegetables and Fruits']")
	@CacheLookup
	WebElement searchVegetable;
	@FindBy(xpath = "//h4[text()='Tomato - 1 Kg']")
	@CacheLookup
	WebElement product;
	@FindBy(xpath = "//a[text()='Top Deals']")
	@CacheLookup
	WebElement link;
	@FindBy(xpath = "//input[@id='search-field']")
	@CacheLookup
	WebElement search;
	@FindBy(xpath = "//table[@class='table table-bordered']/tbody/tr/td[1]")
	@CacheLookup
	WebElement tableData;

	public void searchVegetable(String sname) {
		searchVegetable.clear();
		searchVegetable.sendKeys(sname);
		ScreenShots.captureScreenshot(ldriver, "searchVegetable");
	}

	public void searchProduct() {

		String text = product.getText();
		String[] prod = text.split("-");
		item = prod[0].trim();
		String price = prod[1].trim();
		ScreenShots.captureScreenshot(ldriver, "searchProduct");
	}

public void links() {
	String tab = Keys.chord(Keys.CONTROL,Keys.ENTER);
	link.sendKeys(tab);
	ScreenShots.captureScreenshot(ldriver, "links");
	String parentWindow = ldriver.getWindowHandle();
	Set<String> windows = ldriver.getWindowHandles();
	for(String windowHandles : windows) {
		if(!windowHandles.equals(parentWindow)) {
			ldriver.switchTo().window(windowHandles);
		}
	}
}

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void searchVegi(String searname) {
		search.clear();
		search.sendKeys(searname);
		ScreenShots.captureScreenshot(ldriver, "searchVegi");
		colData = tableData.getText();
	}
}
