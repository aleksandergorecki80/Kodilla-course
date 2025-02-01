package com.kodilla.testing2.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GoogleTestingApp {
    public static final String SEARCHFIELD = "q";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverManager.firefoxdriver().create();
        driver.get("https://www.google.com");

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();

        WebElement searchField = driver.findElement(By.name(SEARCHFIELD));
        searchField.sendKeys("Kodilla");
        searchField.submit();
    }
}