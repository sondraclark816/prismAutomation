import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInWithGoogle {

    WebDriver driver;

    WebDriverWait wait;

    Actions action;

    LandingPage landingPage;

    @BeforeTest
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver ();
        driver.get("https://interapt.myprism.io/shoutouts");
        driver.manage().window().setSize(new Dimension (1000,1000));
        wait = new WebDriverWait(driver, 15);
        action = new Actions(driver);
    }

    @Test
    public void initiateLogin() {

        landingPage = new LandingPage (driver, wait, action);
        landingPage.clickLogIn ();

    }


}
