package StepDefination;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class loginStepdefs {
    WebDriver webdriver;
    WebDriverWait wait;

    @Given("^User already available in login Page$")
    public void userAlreadyAvailableInLoginPage() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\wahid\\Documents\\chromedriver.exe");
        webdriver=new ChromeDriver();
        webdriver.get("https://freecrm.com/");
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
    }

    @When("^Title of log in Page is \"([^\"]*)\"$")
    public void titleOfLogInPageIs(String title) throws Throwable {
     String actualTitle=webdriver.getTitle();
        Assert.assertEquals(title,actualTitle);
    }

    @Then("user enter {string} and {string}")
    public void userEnterAnd(String userName, String password) {
        WebElement email = webdriver.findElement(By.name("email"));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        email.sendKeys(userName);
        webdriver.findElement(By.name("password")).sendKeys(password);
    }



    @Then("^user clicks to login Button$")
    public void userClicksToLoginButton() {
       WebElement loginBt=webdriver.findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor js=  (JavascriptExecutor)webdriver;
        js.executeScript("arguments[0].click();",loginBt);

    }

    @And("^user is in Home Page$")
    public void userIsInHomePage() {
        Assert.assertEquals("Cogmento CRM",webdriver.getTitle());

    }


    @And("close the browser")
    public void closeTheBrowser() {
        webdriver.quit();
    }


}
