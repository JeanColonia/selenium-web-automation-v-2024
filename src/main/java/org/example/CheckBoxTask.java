package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CheckBoxTask {


    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();


        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2500));

       List<WebElement> checkBoxList = driver.findElements(By.cssSelector("input[type='checkbox']"));
        WebElement firstCheckBox = driver.findElement(By.id("checkBoxOption1"));


        System.out.println(checkBoxList.size());
        firstCheckBox.click();
        Assert.assertTrue(firstCheckBox.isSelected());

        firstCheckBox.click();
        Assert.assertFalse(firstCheckBox.isSelected());


        // recorriendo array de checkbox






        driver.quit();

    }
}
