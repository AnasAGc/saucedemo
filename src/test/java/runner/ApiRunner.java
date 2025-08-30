package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/api",
    glue = "stepDefinitions",
    		   plugin = {
    			        "pretty",
    			        "html:target/cucumber-reports.html",
    			        "json:target/cucumber.json",
    			        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    			    },    monochrome = true , tags = "@Api"
)


public class ApiRunner extends AbstractTestNGCucumberTests{

}
