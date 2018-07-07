package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaggedHooksStepDefinition {

	//Global hooks i.e @Before
	@Before(order=0) //import from cucumber package
	//This method will be executed before scenario execution, when there are multiple scenarios in feature file, then @Before will be
	//executed before each scenario
	public void setUp()
	{
		System.out.println("set up");		
	}
	
	//Global hook @After
	@After(order=0)//this method will be executed after each and every scenario execution
	public void tearDown()
	{
		System.out.println("tear down");
	}
	
	@Before(order=1)
	public void setUpOrder()
	{
		System.out.println("set up");		
	}
	@After(order=1)//this method will be executed after each and every scenario execution
	public void tearDownOrder()
	{
		System.out.println("tear down");
	}
	
	//Local hook @Before for @First
	@Before("@First")
	public void setUpFirst()
	{
		System.out.println("set up first");		
	}
	
	//Local hook @After for @First
	@After("@First")   //this method will be executed after each and every scenario execution
	public void tearDownFirst()
	{
		System.out.println("tear down first");
	}
	
	@Given("^user is on deal page$")
	public void user_is_on_deal_page()  {

	    
	}

	@When("^user fills deal form$")
	public void user_fills_deal_form()  {

	    
	}

	@Then("^deal is created$")
	public void deal_is_created()  {

	    
	}
}