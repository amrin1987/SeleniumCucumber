package TestRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\wahid\\IdeaProjects\\untitled\\SeleniumCucumber\\src\\test\\java\\Features\\contact.feature"
        ,glue = {"StepDefination"},publish = true,
        dryRun = false,//to chk themapping betwwn step defination and features
        monochrome = true,//display console output readable
        plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml" }

)
public class testRunner {
}
