package StepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomerPage;
import PageObjects.DynamicTable;
import PageObjects.VegetablePage;
import PageObjects.SearchCustomer;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class VegetableTest extends BaseClass {

	@Before
	public void setUp() throws IOException {
		configprop = new Properties();
		FileInputStream configpropfile = new FileInputStream("config.properties");
		configprop.load(configpropfile);
		logger = Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		String br = configprop.getProperty("browser");
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
	}

	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {
		logger.info("Launching Browser");
		vp = new VegetablePage(driver);
	}

	@When("URL is Entered")
	public void url_is_Entered() {
		logger.info("Opening URL");
		driver.get(configprop.getProperty("URL"));
		driver.manage().window().maximize();
	}

	@When("User searches {string} then Tomato should be displayed")
	public void user_searches_then_Tomato_should_be_displayed(String string) {
		logger.info("Searching Product");
		vp.searchVegetable(string);
		vp.searchProduct();
	}

	@When("click on top deals link")
	public void click_on_top_deals_link() {
		logger.info("Click on Link");
		vp.links();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		logger.info("Verifying Title");
		Assert.assertEquals(string, vp.getPageTitle());
	}

	@When("user enters {string} in search field")
	public void user_enters_in_search_field(String string) {
		logger.info("Searching Product");
		vp.searchVegi(string);
		logger.info("Asserting Product");
		Assert.assertEquals(vp.item, vp.colData);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("Closing Browser");
		driver.quit();
	}

}
