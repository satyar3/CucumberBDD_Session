package stepDefinition;

import java.io.File;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HooksStepDefinition {

	//Global hooks i.e @Before
	@Before //import from cucumber package
	//This method will be executed before scenario execution, when there are multiple scenarios in feature file, then @Before will be
	//executed before each scenario
	public void setUp()
	{
		System.out.println("set up");		
	}
	
	//Global hook @After
	@After//this method will be executed after each and every scenario execution
	public void tearDown()
	{
		System.out.println("tear down");
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
	
	/*public void deleteClassFile() {
		try {

			File file = new File("\\C:\\Back Up\\Project Work\\Learning Stuffs\\Eclipse Oxygen\\CucumberBDD_Session\\target\\classes\\stepDefinition\\*.class");

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}*/
}
