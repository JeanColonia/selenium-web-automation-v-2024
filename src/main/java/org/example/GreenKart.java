package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

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
       String promoSuccessMsg = "Code applied ..!";
       Integer promoDiscountValue = 10;

       String successOrderMsg = "Thank you, your order has been placed successfully";

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> productsToPick = driver.findElements(By.cssSelector("h4.product-name"));

        addProducts(driver, requestProducts,productsToPick);

        WebElement cartBtn = driver.findElement(By.cssSelector("img[alt='Cart']"));

        cartBtn.click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector("p.product-name"));

        WebElement processToCheckOut = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));

        processToCheckOut.click();

        WebElement promoCodeInput = driver.findElement(By.className("promoCode"));

        promoCodeInput.sendKeys("rahulshettyacademy");

        WebElement promoBtn = driver.findElement(By.className("promoBtn"));

        promoBtn.click();

        WebElement promoInfo = driver.findElement(By.className("promoInfo"));

        promoInfo.getText().contains(promoSuccessMsg);

        String[] discountPercentage = driver.findElement(By.className("discountPerc")).getText().split("%");

        Integer discountPercentageValue =  Integer.parseInt(discountPercentage[0]);


        if(discountPercentageValue == 10){
            WebElement orderBtn = driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]"));

            orderBtn.click();
        }
        else {
            System.out.println("DISCOUNT VALUE APPLIED ERROR");
        }

        Select countrySelect = new Select(driver.findElement(By.xpath("//option[text()='Select']/parent::select")));

        countrySelect.selectByValue("Peru");

        WebElement termsCheck = driver.findElement(By.className("chkAgree"));

        termsCheck.click();

        WebElement proceedBtn = driver.findElement(By.xpath("//button[text()='Proceed']"));

        proceedBtn.click();


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
            String[] unformatedProduct = productsToPick.get(i).getText().split("-");
            String productName  = unformatedProduct[0].trim();
            products.add(productName);
        }

        return products;
    }


    public static List unformattedProductName(List<WebElement> productsToPick){

        return null;
    }



}
