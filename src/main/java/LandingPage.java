import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    @FindBy(id = "#root > div > div:nth-child(1) > div > div.left-background > div > div")
    WebElement prismLogo;

    @FindBy(id = "#root > div > div:nth-child(1) > div > div.right-background > div > div.children-container > div > div.login-methods > div")
    WebElement signInButton;

    public LandingPage(WebDriver driver, WebDriverWait wait, Actions action) { super(); }

    public void clickLogIn() {
        signInButton.click ();

    }
}
