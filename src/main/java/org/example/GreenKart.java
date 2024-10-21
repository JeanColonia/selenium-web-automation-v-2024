package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GreenKart {


    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origin=*");
    WebDriver driver = new ChromeDriver(chromeOptions);

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       String[] requestProducts = {"Cucumber", "Brocolli", "Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addProducts(driver, requestProducts);



        driver.quit();


    }

    public static void addProducts(WebDriver driver, String[] requestProducts) throws InterruptedException {
        int j=0;

        List<WebElement> productsToPick = driver.findElements(By.cssSelector("h4.product-name"));
        for(int i=0; i<productsToPick.size(); i++){
            j++;
            String[] unformatedProduct = productsToPick.get(i).getText().split("-");
            String productName  = unformatedProduct[0].trim();
            List productList = Arrays.asList(requestProducts);
            if(productList.contains(productName)){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                Thread.sleep(2500);

            }

            if(j==4){
                break;
            }

        }
    }
}
