package StepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class contactStepDefination {
    WebDriver webdriver;

    @Given("user already in login Page")
    public void user_already_in_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wahid\\Documents\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.get("https://freecrm.com/");
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/nav[1]/div[1]/div[1]/a[1]")).click();
    }

    @Then("user enters details <{string}> and <{string}>")
    public void user_enters_details_amrin01_gmail_com_and_amrin7890(String arg0,String arg1) {
        WebElement email = webdriver.findElement(By.name("email"));

        email.sendKeys(arg0);
        webdriver.findElement(By.name("password")).sendKeys(arg1);


    }
    @Then("user click to login Button")
    public void user_click_to_login_button() {
        WebElement loginBt = webdriver.findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click();", loginBt);
    }
    @Then("user is on Home Page")
    public void user_is_on_home_page() {
        Assert.assertEquals("CRMPRO", webdriver.getTitle());
    }
    @Then("user moves to new contact page")
    public void user_moves_to_new_contact_page() {
        Actions actions = new Actions(webdriver);
        actions.moveToElement(webdriver.findElement(By.xpath("//div[@id='main-nav']/div[3]/a"))).build().perform();
        webdriver.findElement(By.xpath("//div[@id='main-nav']/div[3]/button")).click();
    }
    @Then("user enters details <{string}> and <{string}> and <{string}>")
    public void user_enters_details_amrin_and_nargis_and_manager(String firstName ,String lastName,String position) {
        webdriver.findElement(By.id("first_name")).sendKeys(firstName);
        webdriver.findElement(By.id("surname")).sendKeys(lastName);
        webdriver.findElement(By.id("company_position")).sendKeys(position);
        webdriver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
    }
    @Then("close the browser finally")
    public void close_the_browser_finally() {
        webdriver.quit();
    }



    @When("title of login page is Cogmento CRM")
    public void titleOfLoginPageIsCogmentoCRM() {
        System.out.println(webdriver.getTitle());
    }



}