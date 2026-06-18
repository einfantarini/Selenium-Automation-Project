package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass{
    @Before
    public void setup(){
        launchBrowser();
    }

    @After
    public void teardown() {
        closeBrowser();
    }

}
