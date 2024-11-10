package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ElementInteractions {

    public static void main(String[]args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        driver.navigate().to(driver.getCurrentUrl());

        Actions action = new Actions(driver);

        WebElement accountAndList = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        action.moveToElement(accountAndList).build().perform();

        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));

        action.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();

        action.moveToElement(accountAndList).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

        driver.navigate().to(driver.getCurrentUrl());
        Thread.sleep(3500);

        driver.quit();

    }
}
