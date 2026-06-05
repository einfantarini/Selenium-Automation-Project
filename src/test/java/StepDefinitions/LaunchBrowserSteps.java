package StepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LaunchBrowserSteps {
    WebDriver driver = new ChromeDriver();

    @Given("I open the chrome browser")
    public void i_open_the_chrome_browser() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/src/test/Resources/chromedriver.exe");
        driver.manage().window().maximize();
        //throw new io.cucumber.java.PendingException();
    }

    @When("I navigate to the {string}")
    public void i_navigate_to_the(String url) {
        // Write code here that turns the phrase above into concrete actions
        driver.get(url);
        //throw new io.cucumber.java.PendingException();
    }

    @Then("the browser should display homepage")
    public void the_browser_should_display_homepage() {
        // Write code here that turns the phrase above into concrete actions
        String title = driver.getTitle();
        Assert.assertNotNull(title);
        driver.quit();
        //throw new io.cucumber.java.PendingException();
    }
}

