package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class NestedFrames {

    public static void main(String []args){

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();

        WebElement nestedFramesLink = driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(nestedFramesLink).click().build().perform();


        WebElement frameTop = driver.findElement(By.cssSelector("frame[name='frame-top']"));
        driver.switchTo().frame(frameTop);

        driver.switchTo().frame(1);

        WebElement middleText = driver.findElement(By.id("content"));

        System.out.println(middleText.getText());

        driver.quit();

    }
}
