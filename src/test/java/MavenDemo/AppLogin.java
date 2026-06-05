package MavenDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;


import java.io.File;
import java.time.Duration;
import java.util.Set;

public class AppLogin {

    WebDriver driver=new ChromeDriver();
    @BeforeTest
    public void launch(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }

@AfterTest
 public void Home() throws IOException {
     driver.findElement(By.id("name")).sendKeys("Rini");
     driver.findElement(By.id("email")).sendKeys("e.rini@gmail.com");
     driver.findElement(By.id("phone")).sendKeys("9932123345");
     driver.findElement(By.id("textarea")).sendKeys("AGS COlony, Velachery");
     TakesScreenshot ts=(TakesScreenshot) driver;
     File screenshotAs=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotAs,new File("C://Users//Rini2//IdeaProjects//MavenProject//src//test//Resources//Screenshots//homepage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
public void Button() {

        try {
            Actions start = new Actions(driver);
            WebElement st = driver.findElement(By.name("start"));
            start.moveToElement(st).perform();
            st.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement stop = driver.findElement(By.name("stop"));
            if (stop.isDisplayed()) {
                System.out.println("Element found and action completed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found");
        }
    }
    @Test(priority = 0)
      public void WindHandle(){
          String pid=driver.getWindowHandle();
          Set<String> aid=driver.getWindowHandles();
          for(String s:aid){
              if(!pid.equals(s)){
                  driver.switchTo().window(s);
                  System.out.println(s);
              }
        }
}
}
