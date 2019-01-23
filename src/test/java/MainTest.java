import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import pages.AbstractPage;

import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features")
public class MainTest {

    @BeforeClass
    public static void openMainPage() {
        AbstractPage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.getDriver().manage().window().maximize();
    }

    @AfterClass
    public static void quit() {
        AbstractPage.getDriver().quit();
    }

}
