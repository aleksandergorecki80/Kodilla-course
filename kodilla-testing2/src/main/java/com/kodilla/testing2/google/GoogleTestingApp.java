package com.kodilla.testing2.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class GoogleTestingApp {

    public static void main(String[] args) {
        WebDriver driver = WebDriverManager.firefoxdriver().create();
        driver.get("https://www.google.com");
    }
}