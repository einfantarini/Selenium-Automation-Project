package StepDefinitions;

import Utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GUIElements {

    WebDriver driver;

    @Before
    public void setup() {
        System.out.println(">>> SETUP CALLED <<<");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Given("the browser is on the homepage")
    public void theBrowserIsOnTheHomepage() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        System.out.println("Navigate to:" + url);
    }

    @When("I enter {string} in Name field")              // ✅ (.*) not {string}
    public void iEnterNameInNameField(String name) {
        WebElement namefield = driver.findElement(By.id("name"));
        namefield.clear();
        namefield.sendKeys(name);
        System.out.println("Entered Name:" + name);
    }

    @When("I enter {string} in the Email field")          // ✅ (.*) not {string}
    public void iEnterEmailField(String mailId) {
        WebElement emailfield = driver.findElement(By.id("email"));
        emailfield.clear();
        emailfield.sendKeys(mailId);
        System.out.println("Entered Email:" + mailId);
    }

    @When("I enter {string} in the phone number field")   // ✅ (.*) not {int}
    public void iEnterPhoneNumber(String phoneNumber) {
        WebElement phonefield = driver.findElement(By.id("phone"));
        phonefield.clear();
        phonefield.sendKeys(phoneNumber);
        System.out.println("Entered Phone:" + phoneNumber);
    }

    @When("I enter {string} in the address field")        // ✅ (.*) not {string}
    public void iEnterAddress(String address) {
        WebElement addressfield = driver.findElement(By.xpath("//textarea[@id='textarea']"));
        addressfield.clear();
        addressfield.sendKeys(address);
        System.out.println("Entered Address:" + address);
    }

    @Then("the fields should display the entered values")
    public void theFieldsShouldDisplayEnteredValues() {
        String nameValue = driver.findElement(By.id("name")).getAttribute("value");
        String mailValue = driver.findElement(By.id("email")).getAttribute("value");
        String phoneValue = driver.findElement(By.id("phone")).getAttribute("value");
        WebElement addressValue=driver.findElement(By.xpath("//textarea[@id='textarea']"));
        Assert.assertNotNull(nameValue);
        Assert.assertNotNull(mailValue);
        Assert.assertNotNull(phoneValue);
        Assert.assertNotNull(addressValue);
        System.out.println("Fields display the entered values");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}