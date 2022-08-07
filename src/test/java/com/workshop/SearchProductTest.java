package com.workshop;

import com.workshop.components.CatalogProduct;
import com.workshop.components.DetailedProduct;
import com.workshop.components.Product;
import com.workshop.pages.CatalogPage;
import com.workshop.pages.MainPage;
import com.workshop.pages.ProductPage;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchProductTest extends  BaseTest{
//   1 navigate to main page
//   2 check page loaded
//   3 search a product
//   4 check the list of results contains the search item
//   5 save the product data
//   6 open the product
//   7 check the data  is the same as on search page

    private MainPage mainPage;
    private CatalogPage catalogPage;
    private ProductPage productPage;

    @Before
    public void seUpPages(){
        mainPage = new MainPage(BaseTest.getDriver());
        catalogPage = new CatalogPage(BaseTest.getDriver());
        productPage= new ProductPage(BaseTest.getDriver());
    }


    @Test
    public void searchProductTest(){
        //prerequisites will navigate to main page
        final String searchTerm = "HF-N94";

        assertTrue("the main page is not loaded", mainPage.isPageLoaded());
        mainPage.search(searchTerm);

        List<CatalogProduct> productList = catalogPage.getProductList();

        assertTrue("the list is empty", productList.size() > 0);

        for (Product product : productList) {
            assertTrue("the product doesn't contain " + searchTerm, product.getName().contains(searchTerm));
        }
        final CatalogProduct firstProduct = productList.get(0);
        final String firstProductName = firstProduct.getName();
        final int firstProductPrice = firstProduct.getPrice();

        catalogPage.openItem(0);
        assertTrue("the product page is not loaded", productPage.isPageLoaded());

        final DetailedProduct actualProduct = productPage.getProduct();

        final String actualProductName = actualProduct.getName();
        final int  actualProductPrice = actualProduct.getPrice();

        assertTrue("the name on the product page is different from the name on catalog page", firstProductName.equals(actualProductName));
        assertTrue("the price on the product page is different from the price on catalog page", firstProductPrice==actualProductPrice);

    }
}
