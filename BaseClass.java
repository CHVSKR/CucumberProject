package StepDefinitions;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.DynamicTable;
import PageObjects.VegetablePage;
import PageObjects.SearchCustomer;

public class BaseClass {
	public WebDriver driver;
	public VegetablePage vp;
	public AddCustomerPage addCust;
	public SearchCustomer searchCustomer;
	public Logger logger;
	public Properties configprop;
	public DynamicTable dynamicTable;
	
	public static String randomeString() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}
}
