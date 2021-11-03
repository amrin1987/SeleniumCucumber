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

    @When("^title of login page is (.+)$")
    public void title_of_login_page_is(String title) {
        String actualTitle = webdriver.getTitle();
        Assert.assertEquals(title, actualTitle);
        System.out.println(actualTitle);
    }

    @Then("user enters <{string}> and <{string}>")
    public void userEntersAnd(String username, String password) {
        WebElement email = webdriver.findElement(By.name("email"));

        email.sendKeys(username);
        webdriver.findElement(By.name("password")).sendKeys(password);
    }

    @Then("^user click to login Button$")
    public void userClickToLoginButton() {
        WebElement loginBt = webdriver.findElement(By.xpath("//input[@type='text']"));
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click();", loginBt);

    }

    @Then("^user is on Home Page$")
    public void user_is_on_home_page() {
        Assert.assertEquals("CRMPRO", webdriver.getTitle());
    }

    @Then("^user moves to new contact page$")
    public void user_moves_to_new_contact_page() {
        Actions actions = new Actions(webdriver);
        actions.moveToElement(webdriver.findElement(By.xpath("//div[@id='main-nav']/div[3]/a"))).build().perform();
        webdriver.findElement(By.xpath("//div[@id='main-nav']/div[3]/button")).click();
    }

    @Then("^user enters details(.+) and (.+) and (.+)$")
    public void user_enters_details_and_and(String firstname, String lastname, String position) {
        webdriver.findElement(By.id("first_name")).sendKeys(firstname);
        webdriver.findElement(By.id("surname")).sendKeys(lastname);
        webdriver.findElement(By.id("company_position")).sendKeys(position);
        webdriver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
    }

    @Then("^close the browser$")
    public void close_the_browser() {
        webdriver.quit();
    }


}