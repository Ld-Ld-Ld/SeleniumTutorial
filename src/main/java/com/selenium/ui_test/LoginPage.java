package com.selenium.ui_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.security.PublicKey;

public class LoginPage {

    private  static WebDriver driver;

    //ispolizuem By ctobi on nahodil polea email, pass i sign in:
    public final By emailField = By.id("user_email_login");
    public final By passField = By.id("user_password");
    public final By signInBtn = By.id("user_submit");

    //konstruktor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //nahodim po elementam na stranitze i loginimsea
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passField).sendKeys(password);
        driver.findElement(signInBtn).click();

    }
}
