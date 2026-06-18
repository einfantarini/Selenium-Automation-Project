package StepDefinitions;

import Utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UploadFiles extends BaseClass {

    @When("the user uploads single file")
    public void theUserUploadSingleFile() {
        String filePath = ConfigReader.getProperty("filePath1");
        System.out.println("File Path" + filePath);

/*File file=new File(filePath);
if(file.exists()){
    System.out.println("File Found:" + filePath);
}else
{
    System.out.println("File NOT found:" + filePath);
}*/
        try {
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(10));
            WebElement file_Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit'][1]")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].scrollIntoView(true);", file_Input);
            file_Input.sendKeys(filePath);
            System.out.println("File Uploaded" + filePath);

        } catch (NoSuchElementException e) {
            System.out.println("Element not found" + e);
        }
    }

    @Then("the file should be uploaded successfully")
    public void theFileShouldBeUploadedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(10));
        WebElement file_Status=null;
        try {

            file_Status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='singleFileStatus']")));
            System.out.println("Found <p> tag");
        } catch (Exception e) {
            System.out.println("Not found by p tag");
        }
        if (file_Status != null) {
            String fileMessage = file_Status.getText();
            System.out.println("File status message" + fileMessage);
        } else {
            System.out.println("Status element not found");
        }
    }
    }


