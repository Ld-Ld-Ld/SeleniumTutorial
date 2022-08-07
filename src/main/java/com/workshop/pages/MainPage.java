package com.workshop.pages;

import com.workshop.components.SearchComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    //opredeleaem logo na glavnoi stranitze:
    @FindBy(id="logo")
    private WebElement logo;



    private final SearchComponent searchComponent;

    //konstruktor:
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        searchComponent = new SearchComponent(driver);
    }

    public boolean isPageLoaded() {
        return  logo.isDisplayed();
    }

    public void search(String searchTerm){
        searchComponent.search(searchTerm);
//        searchInput.sendKeys(searchTerm);
//        searchButton.click();
    }
}
