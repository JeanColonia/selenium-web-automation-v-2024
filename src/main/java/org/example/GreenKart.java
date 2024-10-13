package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GreenKart {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        driver.manage().window().maximize();

        List<WebElement> elementsToPick = driver.findElements(By.cssSelector("h4.product-name"));


        for(int i=0; i<elementsToPick.size();i++){


            String productName = elementsToPick.get(i).getText();
            if(productName.contains("Cucumber")){

                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

                Thread.sleep(2000);
                break;
            }
        }

        driver.quit();
    }
}
