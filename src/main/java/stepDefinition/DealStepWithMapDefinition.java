package stepDefinition;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DealStepWithMapDefinition {

	// data table with maps : for parameterization of test cases

	public static WebDriver driver;

	@Given("^user is on login page of Free CRM$")
	public void user_is_on_login_page_of_Free_CRM() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	}

	@When("^the title of the page is Free CRM$")
	public void the_title_of_the_page_is_Free_CRM() throws Throwable {
		String currentpagetitle = driver.getTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", currentpagetitle);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) throws Throwable {
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {
			driver.findElement(By.name("username")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}
	}

	@Then("^user clicks on log in button$")
	public void user_clicks_on_log_in_button() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("^user mouseover on deals link$")
	public void user_mouseover_on_deals_link() throws Throwable {
		driver.switchTo().frame("mainpanel");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Deals']"))).build().perform();
	}

	@Then("^user clicks on new deal link$")
	public void user_clicks_on_new_deal_link() throws Throwable {
		driver.findElement(By.xpath("//a[@title='New Deal']")).click();
	}

	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable dealData) throws Throwable {
		for (Map<String, String> data2 : dealData.asMaps(String.class, String.class)) {
			driver.findElement(By.name("contact_lookup")).sendKeys(data2.get("title"));
			driver.findElement(By.name("amount")).sendKeys(data2.get("amount"));
			driver.findElement(By.name("probability")).sendKeys(data2.get("probablity"));
			driver.findElement(By.name("commission")).sendKeys(data2.get("comission"));

			driver.findElement(By.xpath("//input[@name='addmore']//preceding-sibling::input")).click();

			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[@title='Deals']"))).build().perform();
			driver.findElement(By.xpath("//a[@title='New Deal']")).click();
		}
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}
}
