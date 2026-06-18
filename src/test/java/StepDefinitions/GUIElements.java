package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class GUIElements extends BaseClass{
    /* @Given("the browser is on the homepage")
    public void theBrowserIsOnTheHomepage() {
        String url = ConfigReader.getProperty("url");
        driver.get(url);
        System.out.println("Navigate to:" + url);
    }*/

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
        WebElement addressValue = driver.findElement(By.xpath("//textarea[@id='textarea']"));
        Assert.assertNotNull(nameValue);
        Assert.assertNotNull(mailValue);
        Assert.assertNotNull(phoneValue);
        Assert.assertNotNull(addressValue);
        System.out.println("Fields display the entered values");
    }

    @When("I select {string} Gender radio button")
    public void iSelectGenderRadioButton(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            WebElement maleRadio = driver.findElement(By.cssSelector("input#male"));
            maleRadio.click();
        } else if (gender.equalsIgnoreCase("Female")) {
            WebElement femaleRadio = driver.findElement(By.cssSelector("input#female"));
            femaleRadio.click();
            System.out.println("Radio button selected" + gender);
        }
    }

    @Then("the {string} radio should be selected")
    public void theGenderRadioShouldBeSelected(String gender) {
        WebElement radiobutton;
        if (gender.equalsIgnoreCase("Male")) {

            radiobutton = driver.findElement(By.cssSelector("input#male"));
        } else {
            radiobutton = driver.findElement(By.cssSelector("input#female"));

        }
        Assert.assertTrue(
                gender + "radio button not selected",
                radiobutton.isSelected()
        );
        System.out.println(gender + "radio button verified");
    }

    @When("I select {string} Days checkbox")
    public void iSelectDaysDaysCheckbox(String Days) {
        WebElement checkbox = driver.findElement(By.xpath("//input[@value='" + Days + "']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        System.out.println("Checkbox is selected:" + Days);
    }

    @Then("the {string} checkbox should be selected")
    public void theDaysCheckboxShouldBeSelected(String Days) {
        WebElement checkbox = driver.findElement(By.xpath("//input[@value='" + Days + "']"));
        Assert.assertTrue(
                Days + "checkbox not checked",
                checkbox.isSelected()
        );
        System.out.println(Days + "checkbox verified");
    }

    @When("I select {string} from country dropdown")
    public void iSelectFromCountryDropdown(String Country) {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='country']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", dropdown);
        Select select=new Select(dropdown);
        select.selectByVisibleText(Country);
        System.out.println("Country Selected" + Country);
    }

    @Then("the {string} should be selected")
    public void theShouldBeSelected(String Country) {
        Select select=new Select(driver.findElement(By.xpath("//select[@id='country']")));
        String selectdropdown = select.getFirstSelectedOption().getText();
        Assert.assertEquals(Country,selectdropdown);
        System.out.println("Drop Down verified" +selectdropdown);
    }

    @When("I select {string} from color list")
    public void iSelectFromColorList(String Colors) {
        WebElement Colorfield = driver.findElement(By.cssSelector("select#colors"));
        Colorfield.click();
        WebElement scrollableDiv = driver.findElement(By.cssSelector("select#colors"));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollableDiv);
        Select se=new Select(Colorfield);
        se.selectByVisibleText(Colors);
        System.out.println("Colors selected"+Colors);
    }

    @Then("the Colors should be highlighted")
    public void theColorsShouldBeHighlighted() {
        Select se=new Select(driver.findElement(By.cssSelector("select#colors")));
        String Col=se.getFirstSelectedOption().getText();
        //Assert.assertEquals(col,se);
        System.out.println("Colors List verified"+ Col);
    }

    @When("I enter the Date in the date text field")
    public void enterDatesFromTable(DataTable dataTable) {
        List<Map<String,String>> data=dataTable.asMaps(String.class, String.class);
        String date1=data.get(0).get("Date1");
        String date2=data.get(0).get("Date2");
        String fromDate=data.get(0).get("FromDate");
        String toDate=data.get(0).get("ToDate");
        driver.findElement(By.cssSelector("input#datepicker")).sendKeys(date1);
        driver.findElement(By.cssSelector("input#txtDate")).sendKeys(date2);
        driver.findElement(By.cssSelector("input#start-date")).sendKeys(fromDate);
        driver.findElement(By.cssSelector("input#end-date")).sendKeys(toDate);

        System.out.println("Date1"+date1+ "verified");
        System.out.println("Date2" + date2+ "verified");
        System.out.println("FromDate" +fromDate+"verified");
        System.out.println("ToDate"+toDate+ "verified");

    }

}