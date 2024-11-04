package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPagePractise {


    public static void main(String[] args) throws InterruptedException {


        // setting driver
        WebDriver driver = new ChromeDriver();

        // browser configs
        driver.manage().window().maximize();

        // Request data:

        String[] requestProducts = {"iphone", "Samsung", "Nokia"};

        //setting implict and explicit waits
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        WebElement usernameInput = driver.findElement(By.id("username"));

        usernameInput.sendKeys("rahulshettyacademy");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("learning");


        WebElement userOption = driver.findElement(By.xpath("//input[@value='user']//following::span[1]"));

        userOption.click();

        WebElement okayBtn = driver.findElement(By.id("okayBtn"));

        wait.until(e-> okayBtn.isDisplayed());

        okayBtn.click();


        Select userType = new Select(driver.findElement(By.xpath("//option[text()='Student']/parent::select")));

        userType.selectByVisibleText("Consultant");

        WebElement terms = driver.findElement(By.id("terms"));

        terms.click();

        WebElement signInBtn = driver.findElement(By.id("signInBtn"));

        signInBtn.click();

        WebElement homeTitle = driver.findElement(By.xpath("//a[contains(text(), 'ProtoCommerce Home')]"));

        wait.until(e -> homeTitle.isDisplayed());

        List<WebElement> homeProducts = driver.findElements(By.className("card-title"));

        List productList = Arrays.asList(requestProducts);


        List existingProducts = listOfProducts(homeProducts);

        for (int i=0; i<productList.size(); i++){

            if(productList.contains(existingProducts.get(i))) {

                driver.findElements(By.xpath("//button[contains(text(), 'Add')]")).get(i).click();
            }
        }


        WebElement checkOutBtn = driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]"));

        checkOutBtn.click();

        Thread.sleep(4000);
        driver.quit();

    }




    private static List listOfProducts(List<WebElement> homeProducts){
        List products = new ArrayList();

        for (int i=0; i<homeProducts.size(); i++){

            String[] productNamesArray = homeProducts.get(i).getText().split(" ");
            String productName = productNamesArray[0].trim();

            products.add(productName);
        }
        return products;
    }
}
