package com.workshop.pages;

import com.workshop.components.DetailedProduct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private  DetailedProduct detailedProduct;

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        detailedProduct = new DetailedProduct(driver);
    }
//stranitza scitaetsea zagrujennoi esli imea produkta zagruzilosi
    public boolean isPageLoaded() {
        return !detailedProduct.getName().isEmpty();
    }
//s etoi stranitzi mi budem brati nash detailedProduct
    public DetailedProduct getProduct() {
        return detailedProduct;
    }
}
