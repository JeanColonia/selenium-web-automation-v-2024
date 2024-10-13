package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GreenKart {


    public static void main(String[] args) throws InterruptedException {

    WebDriver driver = new ChromeDriver();

       String[] requestProducts = {"Cucumber", "Brocolli", "Beetroot","Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        List<WebElement> productsToPick = driver.findElements(By.cssSelector("h4.product-name"));


        for(int i=0; i<productsToPick.size(); i++){
            String[] unformatedProduct = productsToPick.get(i).getText().split("-");
            String productName  = unformatedProduct[0].trim();
            List productList = Arrays.asList(requestProducts);
            if(productList.contains(productName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
               Thread.sleep(2500);

            }

        }


   driver.close();


    }
}
