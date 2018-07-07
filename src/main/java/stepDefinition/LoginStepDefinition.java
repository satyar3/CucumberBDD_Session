package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

//Also known as test class

public class LoginStepDefinition {

	public static WebDriver driver;
	
	@Given("^User is already is on Login Page$")
	public void user_already_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver", "src\\main\\java\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	}
	
	@When("^title of Login Page is Free CRM$")
	public void title_of_Login_Page_is_FreeCRM()
	{
		
		String title = driver.getTitle();
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	 }
	
	//@Then("^user enters username and user enters password$")
	@Then("^user enters \"(.*)\" and user enters \"(.*)\"$") //Using regular expression
	public void user_enters_username_and_user_enters_password(String username, String password) 
	{
	   
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^user clicks on Login button$")
	public void user_clicks_on_Login_button() 
	{
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	}

	@Then("^user is on home page for first scenario$")
	public void user_is_on_home_page_first_scenario()
	{
	    
		String title = driver.getTitle();
		System.out.println("Title for 1st scenario : "+title);
		Assert.assertEquals("CRMPRO", title);
	}
	
	/*@Then("^close the browser$")
	public void close_the_browser() 
	{
		
		driver.quit();
	    
	}*/
	
}
