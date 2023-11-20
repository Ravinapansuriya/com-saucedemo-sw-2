package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //Enter Password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();
        //Verify the Products text
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //Enter Password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //Click on login button
        driver.findElement(By.id("login-button")).click();
        //Verify that six products are displayed on  page
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        System.out.println("Total images are: " + products.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
