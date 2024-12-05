package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class JSExecutor {

    public static void main(String []args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        JavascriptExecutor js =  (JavascriptExecutor) driver;

        js.executeScript("window.scroll(0,500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=600");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum = 0;
        for (int i = 0; i < values.size(); i++) {

            sum += Integer.parseInt(values.get(i).getText());


        }


        int amount = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(sum, amount);


        // print all grids from a table

        String courseName = "Learn SQL in Practical + Database Testing from Scratch";
        WebElement table = driver.findElement(By.cssSelector("#product"));


        List<WebElement> grids = table.findElements(By.tagName("td"));

        WebElement secondRow = null;
        int numberOfColumns = table.findElements(By.cssSelector("tr:nth-child(1) th")).size();

        for (int i = 0; i < grids.size(); i++) {

            System.out.println(grids.get(i).getText());



            if(grids.get(i).getText().contains(courseName)){
                secondRow = table.findElement(By.cssSelector("tr:nth-child("+(i-1)+")"));

            }
        }

        System.out.println("2. Number of columns... "+numberOfColumns);
        System.out.println("3. Print second row from the table "+secondRow.getText());




        Thread.sleep(1500);
        driver.quit();
    }
}
