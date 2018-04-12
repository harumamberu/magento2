package com.headcovers.tests.selenium.smoke;

import com.headcovers.tests.selenium.BaseTest;
import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class SearchTest extends BaseTest{

    @Test
    @FileParameters("src/test/resources/ProductsNameForTestSearchDropdown.csv")
    public void SearchTheProductThatMatchesInDrowdown(String prodName, String secondChar, String thirdChar){
        mainPage.fillSField(prodName)
                .fillSField(secondChar)
                .fillSField(thirdChar)
                .clickTheSmartsearchItem(1)
                .checkThatOpenedProductPageCorrespodToTheWordInSearch(prodName);
    }

    @Test
    public void SearchTheProductThatMatches100percent(){
        mainPage.searchProductThatMatchs100percent("");
    }

    @Test
    public void SearchTheProductThatMatchesAsCatalog(){

    }

    @Test
    public void SearchNegativeTest(){

        //min lenght 3
        //random chars
    }

}