import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class SignUp {
    WebDriver driver;
    By name = By.name("name");
    By emailSignUp = xpath("//input[@data-qa='signup-email']");
    By submitSignUpButton = By.cssSelector("[data-qa=\"signup-button\"]");
    By form = By.id("form");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://automationexercise.com/login");
    }

    @Test
    public void validSignUp() {
//        TC_01
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(emailSignUp).sendKeys("abanob.soror@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertTrue(driver.findElement(form).isDisplayed());
    }

    @Test
//    bug
    public void emptyName() {
//        TC_02
        driver.findElement(emailSignUp).sendKeys("abanob.soror@gmail.com");
        driver.findElement(submitSignUpButton).click();
        String validationMessage = driver.findElement(name).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
    System.out.println(validationMessage);
    }


    @Test
    public void emptyEmail() {
//        TC_03
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(submitSignUpButton).click();
        String validationMessage =
                driver.findElement(emailSignUp).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill")
        );
    }

    @Test
    public void invalidEmail() {
//        TC_04
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(emailSignUp).sendKeys("abanob.sororgmail.com");
        driver.findElement(submitSignUpButton).click();
        String validationMessage = driver.findElement(emailSignUp).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("is missing an '@'")
        );
        System.out.println(validationMessage);
    }

    @Test
    public void spacesInEmail() {
//        TC_05
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(emailSignUp).sendKeys("abanob         soror@gmail.com");
        driver.findElement(submitSignUpButton).click();
        String validationMessage = driver.findElement(emailSignUp).getAttribute("validationMessage");
        System.out.println(validationMessage);
        Assert.assertTrue(
                validationMessage.contains("should not contain the symbol ' '")
        );
        System.out.println(validationMessage);

    }

    @Test
    public void numbersInEmails() {
//        TC_06
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(emailSignUp).sendKeys("abanobsoror2017@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertTrue(driver.findElement(form).isDisplayed());
    }


    @Test
    public void spacesInName() {
//        TC_07
        driver.findElement(name).sendKeys("            ");
        driver.findElement(emailSignUp).sendKeys("abanobsoror2017@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertFalse(driver.findElement(form).isDisplayed());
    }

    @Test
    public void numbersInName() {
//        TC_08
        driver.findElement(name).sendKeys("Sorour123");
        driver.findElement(emailSignUp).sendKeys("abanobsoror2017@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertTrue(driver.findElement(form).isDisplayed());
    }

    @Test
    public void specialCharInName() {
//        TC_09
        driver.findElement(name).sendKeys("@@@@@");
        driver.findElement(emailSignUp).sendKeys("abanobsoror2017@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertFalse(driver.findElement(form).isDisplayed());
    }

    @Test
    public void arabicCharInName() {
//        TC_10
        driver.findElement(name).sendKeys("أبانوب");
        driver.findElement(emailSignUp).sendKeys("abanobsoror2017@gmail.com");
        driver.findElement(submitSignUpButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(form).isDisplayed());
        Assert.assertTrue(driver.findElement(form).isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}