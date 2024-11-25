package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class FrameWindows {

    public static void main(String[] args ) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));

        driver.switchTo().frame(frame);

        WebElement source = driver.findElement(By.id("draggable"));

        WebElement target = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        Thread.sleep(3000);

        action.dragAndDrop(source, target).build().perform();

        Thread.sleep(3000);

        driver.quit();
    }
}
