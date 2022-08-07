package com.selenium.ui_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagefactoryLoginPage {

    private final WebDriver driver;
    private  final By AuthorizationForm = By.className("auth-form-tablet88");

     // eto anotatzia FindBY ot By:
    @FindBy(id ="user_email_login" )
    //posvoleaet iskati elementi iz Cache
    @CacheLookup
    private WebElement emailField;

    @FindBy(id ="user_password" )
    private WebElement passField;

    @FindBy(id ="user_submit" )
    private WebElement signInBtn;

//konstruktor, kot prinimaet driver
    public PagefactoryLoginPage(WebDriver driver){
        this.driver = driver;
        new PageLoader(driver).isElementPresent(AuthorizationForm);
        PageFactory.initElements(this.driver, this);
    }
    public  void login(String email, String pass){
        emailField.sendKeys(email);
        passField.sendKeys(pass);
        signInBtn.click();
    }
}
