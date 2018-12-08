package stepDefinition;

import java.util.List;
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

public class DealsStepDefinition 
{

	public static WebDriver driver;
	
	@Given("^user is on login page o Free CRM$")
	public void user_is_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	}
		
	@When("^the title of the page is Free CRM$")
	public void the_title_of_the_page_is_Free_CRM() 
	{
		String currentpagetitle = driver.getTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", currentpagetitle);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password(DataTable credentials) 
	{

		List<List<String>> data = credentials.raw();
		
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));

	}

	@Then("^user clicks on log in button$")
	public void user_clicks_on_log_in_button() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("^user mouseover on deals link$")
	public void user_mouseover_on_deals_link() 
	{
		
		driver.switchTo().frame("mainpanel");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@title='Deals']"))).build().perform();
		

	}

	@Then("^user clicks on new deal link$")
	public void user_clicks_on_new_deal_link() 
	{
		
		driver.findElement(By.xpath("//a[@title='New Deal']")).click();		
	}

	@Then("^user enters deal details$")
	public void user_enters_deal_details(DataTable arg1) 
	{
		
		List<List<String>> data = arg1.raw();
		driver.findElement(By.name("contact_lookup")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("amount")).sendKeys(data.get(0).get(1));
		driver.findElement(By.name("probability")).sendKeys(data.get(0).get(2));
		driver.findElement(By.name("commission")).sendKeys(data.get(0).get(3));

		driver.findElement(By.xpath("//input[@name='addmore']//preceding-sibling::input")).click();
	}

	@Then("^close the browser$")
	public void close_the_browser() 
	{
		
		driver.quit();

	}

}
