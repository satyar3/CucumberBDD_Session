package Myrunner.packg;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions; 
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\main\\java\\features\\contact.feature" //path of the feature file
		,glue = {"stepDefinition"} //location where all the step definitions are available i.e package name
		,format = {"pretty","html:test-output", "json:json_output/cucumber.json" ,"junit:junit_xml/cucumber.xml"} //Format is used to generate different types of reporting
		,monochrome = true //display the console output in a proper readable format
		,strict = true //It'll check if any of the step is not defined, then it'll fail the execution
		,dryRun = false//it'll test the mapping between feature file and step definition file if dryRun = true
		//,tags = {"@SmokeTest"} //single only a single test type
		//,tags = {"@SmokeTest , @RegressionTest"} //"," stands for OR, here either SmokeTest or Regression will be executed
		//,tags = {"@SmokeTest" , "@RegressionTest"} //"," stands for And where both are separately defined, here either SmokeTest and Regression will be executed
		//,tags = {"~@SmokeTest" , "~@RegressionTest" ,"@End2End"} //"~" is used to skip test cases
		)

	

public class TestRunner {

}
