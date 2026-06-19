package StepDefinitions;

import Utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class UploadFiles extends BaseClass {

    @When("the user uploads single file")
    public void theUserUploadSingleFile() {
        String filePath = ConfigReader.getProperty("filePath1");
        System.out.println("File Path" + filePath);
       /* File file=new File(filePath);
if(file.exists()){
    System.out.println("File Found:" + filePath);
}else
{
    System.out.println("File NOT found:" + filePath);
}*/
        try {
            WebDriverWait wait = new WebDriverWait(
                    driver, Duration.ofSeconds(10));
            WebElement file_Input = wait.until(visibilityOfElementLocated(cssSelector("input#singleFileInput")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "arguments[0].scrollIntoView(true);", file_Input);
            file_Input.sendKeys(filePath);
            System.out.println("File Uploaded" + filePath);
            WebElement UpldBtn = driver.findElement(cssSelector("#singleFileForm button[type='submit']"));
            UpldBtn.click();
            System.out.println("Upload Button clicked");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Element not found" + e);
        }
    }

    @Then("the file should be uploaded successfully")
    public void theFileShouldBeUploadedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(
                driver, Duration.ofSeconds(20));

        try {
            boolean file_Status = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p#singleFileStatus"), "Single file selected"));
            if (file_Status) {
                String fileMessage = driver.findElement(By.id("singleFileStatus")).getText();
                System.out.println("File status message: " + fileMessage);
            }

        } catch (Exception e) {
            System.out.println("Status message did not appear:" + e.getMessage());
        }
    }

    @When("the user uploads multiple file")
    public void theUserUploadsMultipleFile() {
        String filepath1 = ConfigReader.getProperty("filePath1");
        String filepath2 = ConfigReader.getProperty("filePath2");
        System.out.println("FilePath1" + filepath1);
        System.out.println("FilePath2" + filepath2);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement mltplfilepath = driver.findElement(By.cssSelector("input#multipleFilesInput"));
            JavascriptExecutor jser = (JavascriptExecutor) driver;
            jser.executeScript("arguments[0].scrollIntoView(true);", mltplfilepath);
            mltplfilepath.sendKeys(filepath1 + "\n" + filepath2);
            WebElement upldmtplfile = driver.findElement(By.xpath("//button[text()='Upload Multiple Files']"));
            upldmtplfile.click();
            System.out.println("Multiple File Upload button clicked");
            Thread.sleep(1000);
        } catch (NoSuchElementException | InterruptedException e) {
            System.out.println("Element not found" + e);
        }
    }

    @Then("the files should be uploaded successfully")
    public void theFilesShouldBeUploadedSuccessfully() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        try
        {
        boolean mtplFileStatus=wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("p#multipleFilesStatus"),"Multiple files selected"));
        if(mtplFileStatus)
        {
            String mtplFileStatusmsg=driver.findElement(By.cssSelector("p#multipleFilesStatus")).getText();
            System.out.println("Multiple File Status message" + mtplFileStatusmsg);
        }
    }
        catch(Exception e)
        {
            System.out.println("Status message did not appear" + e.getMessage());
        }

}
}


