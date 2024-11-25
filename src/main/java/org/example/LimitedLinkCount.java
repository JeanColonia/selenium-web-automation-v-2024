package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LimitedLinkCount {

    public static void main(String[]args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().window().maximize();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());

        WebElement footerContainer = driver.findElement(By.id("gf-BIG"));

        System.out.println(footerContainer.findElements(By.tagName("a")).size());

        driver.quit();
    }
}
