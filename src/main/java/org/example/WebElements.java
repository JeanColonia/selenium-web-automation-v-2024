package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {


    public static void main(String[ ] args){

    String text = "Jean Colonia";
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement alertBtn = driver.findElement(By.cssSelector("[id='alertbtn']"));

        nameInput.sendKeys(text);

        alertBtn.click();

        // switching to alert window

        String message  = driver.switchTo().alert().getText();



        driver.switchTo().alert().accept();


        System.out.println(message);




    }
}
