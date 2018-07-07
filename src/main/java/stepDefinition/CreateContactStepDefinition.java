package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CreateContactStepDefinition {
	
	WebDriver driver;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page()  
	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");	    
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	
	@Given("^user is on home page for second scenario$")
	public void user_is_on_home_page_for_second_scenario()  {
		String homepagetitle = LoginStepDefinition.driver.getTitle();
		System.out.println("2nd Scenario title : "+homepagetitle);
		Assert.assertEquals("CRMPRO", homepagetitle);
	}

	
	@When("^user mouseover on contacts link$")
	public void user_mouseover_on_contacts_link() 
	{
		
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		
		action.moveToElement((WebElement) By.xpath("//a[contains(text(),'Contacts')]")).build().perform();
			    
	}

	@Then("^user clicks on new conatct link$")
	public void user_clicks_on_new_conatct_link() 
	{
		driver.findElement(By.xpath("//a[contains(text(),'New Contact')]")).click();
	}

	@Then("^user enters conatact details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_conatact_details_and_and(String arg1, String arg2, String arg3) 
	{
		driver.findElement(By.id("first_name")).sendKeys(arg1);
		driver.findElement(By.id("surname")).sendKeys(arg2);
		driver.findElement(By.id("company_position")).sendKeys(arg3);		
	}
	
	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() 
	{
		driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
	}

	@Then("^verify new conact created$")
	public void verify_new_conact_created() 
	{

	    
	}

}
