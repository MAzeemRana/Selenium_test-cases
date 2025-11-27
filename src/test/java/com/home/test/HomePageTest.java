package com.home.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
public class HomePageTest extends BaseTest {
    @Test
    public void homePageValidation() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        takeScreenshot("home-01-after-login");

        String header = driver.findElement(By.tagName("h2")).getText();
        Assertions.assertEquals("Secure Area", header);

        takeScreenshot("home-02-validated");
    }
}
