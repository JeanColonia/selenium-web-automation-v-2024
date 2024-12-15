package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class IdentifyBrokenLinks {


    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for(WebElement link : links){

            HttpURLConnection  conn =  (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
            conn.setRequestMethod("HEAD");
            int statusCode = conn.getResponseCode();


            System.out.println(statusCode);
            if(statusCode>400){
                System.out.println("The link: "+link.getText()+" is broken with status code: "+statusCode + " and link: "+link.getAttribute("href"));
                Assert.assertTrue(false);
            }
        }


        driver.quit();

    }
}
