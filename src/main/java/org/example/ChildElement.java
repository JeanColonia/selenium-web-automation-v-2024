package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ChildElement {


    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();

        String mainUrl = "https://rahulshettyacademy.com/loginpagePractise/#";
        driver.get(mainUrl);

        WebElement childElement = driver.findElement(By.cssSelector("a[class='blinkingText']"));

        Actions action = new Actions(driver);

        action.moveToElement(childElement).contextClick().keyDown(Keys.ARROW_DOWN).click().build().perform();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId  = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        WebElement email = driver.findElement(By.xpath("//p[@class='im-para red']/child::strong"));

        String emailValue = email.getText();

        driver.close();
        driver.switchTo().window(parentId);

        //FORM

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("rahulshettyacademy");

        WebElement passInput = driver.findElement(By.id("password"));

        passInput.sendKeys("learning");

        WebElement userRadioBtn = driver.findElement(By.cssSelector("input[value='user']"));

        userRadioBtn.click();

        WebElement okayBtn = driver.findElement(By.id("okayBtn"));
        wait.until(e -> okayBtn.isDisplayed());
        okayBtn.click();

        WebElement userRoleSelect = driver.findElement(By.xpath("//div[@class='form-group']/select"));
        Select userRole = new Select(userRoleSelect);
        userRole.selectByValue("teach");


        WebElement termsBtn = driver.findElement(By.id("terms"));

        termsBtn.click();

        WebElement signInBtn = driver.findElement(By.id("signInBtn"));

        signInBtn.click();

        Thread.sleep(5000);

        driver.close();

    }
}
