package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tables {

    public static void main(String[]args){


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        WebElement topDealsOptions = driver.findElement(By.xpath("//a[text()='Top Deals']"));

        topDealsOptions.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parent = it.next();
        String firstChild = it.next();

        driver.switchTo().window(firstChild);

        WebElement sortElementsOption = driver.findElement(By.xpath("//tr/th[1]"));

        sortElementsOption.click();

        List<WebElement> tableResults = driver.findElements(By.xpath("//tr/td[1]"));


        List<String> itemValues = tableResults.stream().map(s-> s.getText()).collect(Collectors.toList());






       List<String>  sortedList = tableResults.stream().map(s-> s.getText()).sorted().collect(Collectors.toList());

        Assert.assertTrue(itemValues.equals(sortedList));

        driver.quit();

    }
}
