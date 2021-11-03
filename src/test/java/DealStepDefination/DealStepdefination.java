package DealStepDefination;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DealStepdefination {
    WebDriver webdriver;

    @Given("user already present in login Page")
    public void user_already_present_in_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\wahid\\Documents\\chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.get("https://freecrm.com/");
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webdriver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/nav[1]/div[1]/div[1]/a[1]")).click();
    }
    @When("tile page is Cogmento CRM")
    public void tile_page_is_Cogmento_CRM() {
        System.out.println(webdriver.getTitle());
    }
    @Then("user enter username and password")
    public void user_enter_username_and_password(DataTable credential) {
        List<Map<String, String>> datarows = credential.asMaps();
        for (Map<String,String> column:datarows){
        webdriver.findElement(By.name("email")).sendKeys(column.get("username"));

        webdriver.findElement(By.name("password")).sendKeys(column.get("password"));
        }
    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button() {
        WebElement loginBt = webdriver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
        JavascriptExecutor js = (JavascriptExecutor) webdriver;
        js.executeScript("arguments[0].click();",loginBt);
    }
    @Then("user is on home page")
    public void user_is_on_home_page() {

    }
    @Then("user moves to new deal page")
    public void user_moves_to_new_deal_page() {
        System.out.println(webdriver.getTitle());

    }
    @Then("user enters deal details")
    public void user_enters_deal_details(DataTable dealDetails)  {
        Actions actions=new Actions(webdriver);
        actions.moveToElement(webdriver.findElement(By.xpath("//div[@id='main-nav']/div[5]"))).build().perform();
        webdriver.findElement(By.xpath("//div[@id='main-nav']/div[5]/button")).click();
        List<Map<String, String>> dealsDetail = dealDetails.asMaps();
        for (Map<String, String> column:dealsDetail){
            webdriver.findElement(By.name("title")).sendKeys(column.get("title"));
            webdriver.findElement(By.name("amount")).sendKeys(column.get("amount"));
            webdriver.findElement(By.name("commission")).sendKeys(column.get("commison"));
            webdriver.findElement(By.name("probability")).sendKeys("probability");
            webdriver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
        }
    }
    @Then("Close the browsers")
    public void close_the_browsers() throws InterruptedException {
        Thread.sleep(2000);
       webdriver.quit();
    }
}
