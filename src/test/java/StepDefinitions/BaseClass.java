package StepDefinitions;

import Utilities.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static void launchBrowser() {
        System.out.println(">>> SETUP CALLED <<<");
        String url = ConfigReader.getProperty("url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(url);
        System.out.println("Navigate to:" + url);

    }
    public static void closeBrowser()
    {
        if (driver != null) {
            driver.quit();
            driver=null;
            System.out.println("Browser closed");

        }
    }
}
