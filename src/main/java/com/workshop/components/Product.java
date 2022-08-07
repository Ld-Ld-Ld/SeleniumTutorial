package com.workshop.components;

import org.openqa.selenium.WebElement;

import static com.workshop.utils.Parser.parseInteger;

public abstract class Product {

    protected abstract WebElement getNameEl();
    protected abstract WebElement getPriceEl();

    public  String getName(){
        return getNameEl().getText();
    }

    public  int getPrice(){
        return parseInteger(getPriceEl().getText());
    }

}
