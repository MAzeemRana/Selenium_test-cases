package com.home.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class LoginTest extends BaseTest {
    @Test
    public void loginFunctionalityTest() {
        driver.get("https://the-internet.herokuapp.com/login");
        takeScreenshot("01-login-page");
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        username.sendKeys("tomsmith");
        takeScreenshot("02-username-entered");
        password.sendKeys("SuperSecretPassword!");
        takeScreenshot("03-password-entered");
        loginBtn.click();
        takeScreenshot("04-login-clicked");
        WebElement message = driver.findElement(By.id("flash"));
        Assertions.assertTrue(message.getText().contains("You logged into a secure area"));
        takeScreenshot("05-login-success");
    }
}
