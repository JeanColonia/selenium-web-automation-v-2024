package org.example;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutor {

    public static void main(String []args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js =  (JavascriptExecutor) driver;

        js.executeScript("window.scroll(0,500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=600");

        Thread.sleep(1500);
        driver.quit();
    }
}
