package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

       // System.setProperty("webdriver.chrome.driver", "C:/Users/jcolonia/Documents/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/locatorspractice/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         WebElement usernameInput = driver.findElement(By.id("inputUsername"));

         WebElement passwordInput = driver.findElement(By.name("inputPassword"));

         WebElement loginBtn = driver.findElement(By.className("signInBtn"));


         usernameInput.sendKeys("jean");
         passwordInput.sendKeys("pass123");
         loginBtn.click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

    }
}