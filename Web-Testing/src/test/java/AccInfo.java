import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class AccInfo{
    WebDriver driver;
    By name = By.name("name");
    By emailSignUp = xpath("//input[@data-qa='signup-email']");
    By submitSignUpButton = By.cssSelector("[data-qa=\"signup-button\"]");
    By form = By.id("form");
    By radioMr = By.id("id_gender1");
    By radioMs = By.id("id_gender2");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company =By.id("company");
    By address1= By.id("address1");
    By address2= By.id("address2");
    By country = By.id("country");
    By state= By.id("state");
    By city= By.id("city");
    By zipcode= By.id("zipcode");
    By mobile= By.id("mobile_number");
    By CreateAccButton= By.cssSelector("[data-qa=\"create-account\"]");
    By CreateAccMsg = By.cssSelector("[class=\"title text-center\"]");
    By HomeButton = By.cssSelector("[class=\"fa fa-home\"]");
    By DeleteAccButton = By.cssSelector("[class=\"fa fa-trash-o\"]");
    By ContinueButton = By.cssSelector("[class=\"btn btn-primary\"]");




    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(emailSignUp).sendKeys("abanob.soror@gmail.com");
        driver.findElement(submitSignUpButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        Assert.assertTrue(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(form)
                ).isDisplayed()
        );

    }

    @Test
    public void validInfo(){
//        TC_11
    driver.findElement(radioMr).click();
    driver.findElement(password).sendKeys("123");
    new  Select(driver.findElement(days)).selectByValue("1");
    new Select(driver.findElement(months)).selectByValue("1");
    new Select(driver.findElement(years)).selectByValue("2002");
    driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(ContinueButton).isDisplayed());
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }


    @Test
    public void emptyTitle(){
//        TC_12
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .until(d -> driver.findElement(ContinueButton).isDisplayed());
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());

    }

    @Test
    public void emptyPassword(){
//        TC_13
        driver.findElement(radioMr).click();
        driver.findElement(name).sendKeys("Sorour");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(password).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
    }


    @Test
    public void emptyDateOfBirth(){
//        TC_14
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }
    @Test
    public void emptyFirstName(){
//        TC_15
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(firstName).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        //bug 23/5/2026
//        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());

    }


    @Test
    public void arabicFirstName(){
//        TC_16
        driver.findElement(radioMr).click();
        driver.findElement(name).sendKeys("Sorour");
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("أبانوب");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }


    @Test
    public void SpecialCharInFirstName(){
//        TC_17
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("@@@@");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());
    }


    @Test
    public void arabicLastName(){
//        TC_18
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("مسرور");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }


    @Test
    public void SpecialCharInLastName(){
//        TC_19
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("######");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());
    }

    @Test
    public void emptyLastName(){
//        TC_20
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(lastName).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());
    }

    @Test
    public void emptyCompany(){
//        TC_21
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }


    @Test
    public void emptyAddress1(){
//        TC_22
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(address1).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());    }

    @Test
    public void emptyAddress2(){
//        TC_23
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelector('iframe').remove();"
        );
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertTrue(driver.findElement(ContinueButton).isDisplayed());
    }

    @Test
    public void emptyState(){
//        TC_24
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(state).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());
    }

    @Test
    public void emptyCity(){
//        TC_25
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(city).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());
    }

    @Test
    public void emptyZipCode(){
//        TC_26
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(mobile).sendKeys("01270180191");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(zipcode).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());
    }
    @Test
    public void emptyMobile(){
//        TC_27
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(CreateAccButton).click();
        String validationMessage = driver.findElement(mobile).getAttribute("validationMessage");
        Assert.assertTrue(
                validationMessage.contains("Please fill"));
        Assert.assertTrue(driver.findElement(CreateAccButton).isDisplayed());
    }

    @Test
    public void alphaCharInMobileNumbers(){
//        TC_28
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("+012dfdf70180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());
    }

    @Test
    public void specialCharInMobileNumbers(){
//        TC_29
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("+2012#$@70180191");
        driver.findElement(CreateAccButton).click();
        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());
    }

    @Test
    public void spacesInMobileNumbers(){
//        TC_30
        driver.findElement(radioMr).click();
        driver.findElement(password).sendKeys("123");
        new  Select(driver.findElement(days)).selectByValue("1");
        new Select(driver.findElement(months)).selectByValue("1");
        new Select(driver.findElement(years)).selectByValue("2002");
        driver.findElement(firstName).sendKeys("Abanob");
        driver.findElement(lastName).sendKeys("Sorour");
        driver.findElement(company).sendKeys("ITI");
        driver.findElement(address1).sendKeys("Ain-Shams");
        driver.findElement(address2).sendKeys("El-Zaitoun");
        new Select(driver.findElement(country)).selectByValue("Canada");
        driver.findElement(state).sendKeys("Cairo");
        driver.findElement(city).sendKeys("Elmatrya");
        driver.findElement(zipcode).sendKeys("3753450");
        driver.findElement(mobile).sendKeys("+012 701   80    191");
        driver.findElement(CreateAccButton).click();
        Assert.assertFalse(driver.findElement(ContinueButton).isDisplayed());
    }


//    @AfterMethod
//    public void tearDown() {
//        driver.findElement(HomeButton).click();
//        driver.findElement(DeleteAccButton).click();
//        driver.quit();
//
//    }


}
