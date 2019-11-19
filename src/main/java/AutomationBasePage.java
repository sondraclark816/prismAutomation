import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.PAGE_DOWN;

public abstract class AutomationBasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public AutomationBasePage(WebDriver driver, WebDriverWait wait, Actions action) {
        PageFactory.initElements(new AjaxElementLocatorFactory (driver, 20), this);
        this.driver = driver;
        this.wait = wait;
        this.action = action;

    }

    public void waitForPageLoad(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitXTime(Integer integer) {
        try {
            Thread.sleep(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scrollDown(WebElement element) {
        int times = 30;
        while (!element.isEnabled() && times > 0) {
            action.click();
            action.sendKeys(PAGE_DOWN).perform();
            times--;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

}
