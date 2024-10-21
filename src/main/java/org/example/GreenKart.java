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
        List<WebElement> productsToPick = driver.findElements(By.cssSelector("h4.product-name"));

        addProducts(driver, requestProducts,productsToPick);

        WebElement cartBtn = driver.findElement(By.cssSelector("img[alt='Cart']"));

        cartBtn.click();

        List<WebElement> cartProductNames = driver.findElements(By.cssSelector("p.product-name"));

        List products = Arrays.asList(requestProducts);
        for(int i=0; i<products.size();i++){

            String product = cartProductNames.get(i).getText();
        int count=0;
            if(cartProductNames.contains(products.get(i))){
                count++;
            }

            System.out.println(count +"----" + products.size());
        }



     Thread.sleep(3000);
        driver.quit();


    }

    public static void addProducts(WebDriver driver, String[] requestProducts, List<WebElement> productsToPick) throws InterruptedException {


        int j=0;

        for(int i=0; i<productsToPick.size(); i++){
            j++;
            List products = formatProductName(productsToPick);
            List productList = Arrays.asList(requestProducts);
            if(productList.contains(products.get(i))){
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                Thread.sleep(2500);

            }

            if(j==4){
                break;
            }

        }


    }
    public static List formatProductName (List<WebElement> productsToPick){
        List products = new ArrayList();
        for(int i=0; i<productsToPick.size();i++){
            String[] unformatedProduct = productsToPick.get(i).getText().split("-");         String productName  = unformatedProduct[0].trim();
            products.add(productName);
        }

        return products;
    }



}
