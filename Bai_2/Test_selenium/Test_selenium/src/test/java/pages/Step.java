package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Step extends BasePage {

    public By userName = By.name("email");
    public By passWord = By.name("password");
    public By signIn_Button = By.xpath("(//*[@type='submit'])[1]");
    public By text_hi_demo = By.xpath("//*[contains(text(),'Hi, ')]");
    public By radio_buttton_remember = By.xpath("//*[contains(text(),'Remember Me')]");

    public Step(WebDriver driver) {
        super(driver);
    }

    public void gotToUrl() {
        driver.navigate().to("https://www.phptravels.net/login");
    }

    public void isenable(By element) throws InterruptedException {
        WebElement radio_button = driver.findElement(element);
        radio_button.click();
        boolean enabled_status = radio_button.isEnabled();
        System.out.println("radio button is Enabled >>" + enabled_status);
    }

    public void login() {
        WebElement user_name = wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
        user_name.sendKeys("user@phptravels.com");
        WebElement pass_word = wait.until(ExpectedConditions.visibilityOfElementLocated(passWord));
        pass_word.sendKeys("demouser");
        // WebElement login =
        // wait.until(ExpectedConditions.visibilityOfElementLocated(signIn_Button));
        // login.click();
    }

    public void display(By element) {
        try {
            boolean d = wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
            System.out.println("This display is: " + d);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickElement(By element) {
        WebElement elementWated = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        elementWated.click();
    }

    public void verifyText(By element, String text) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(element).getText().contains(text), true);
    }

}
