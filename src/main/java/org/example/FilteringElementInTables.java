package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FilteringElementInTables {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        String[] productToSearch = {"Tomato", "37", "26"};
        WebElement topDealsOptions = driver.findElement(By.xpath("//a[text()='Top Deals']"));

        topDealsOptions.click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parent = it.next();
        String firstChild = it.next();

        driver.switchTo().window(firstChild);

        WebElement searchElement = driver.findElement(By.id("search-field"));

        searchElement.sendKeys(productToSearch[0]);

        List<WebElement> tableResults = driver.findElements(By.xpath("//tr/td"));

        List<String> foundProduct = new ArrayList<>();
        if(tableResults.size()<1){
            System.out.println("No se enontraron resultados...");
        }else{
        tableResults.stream().forEach(s-> foundProduct.add(s.getText()));
        }

        Assert.assertEquals(foundProduct.get(0), productToSearch[0]);
        Assert.assertEquals(foundProduct.get(1), productToSearch[1]);
        Assert.assertEquals(foundProduct.get(2), productToSearch[2]);

        driver.quit();

    }


}
