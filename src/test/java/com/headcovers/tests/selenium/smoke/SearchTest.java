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
        mainPage.fillSearchField1by1characters(prodName)
                .fillSearchField1by1characters(secondChar)
                .fillSearchField1by1characters(thirdChar)
                .clickTheSmartsearchItem(1)
                .checkThatOpenedProductPageCorrespodToTheWordInSearch(prodName);
    }

    @Test
    @FileParameters("src/test/resources/FullProductsNames.csv")
    public void SearchTheProductThatMatches100percent(String firstWord, String secondWord, String thirdWord){
        mainPage.fillSearchField(firstWord + " " + secondWord + " " + thirdWord)
                .clickButtonSearch()
                .checkThatOpenedProductPageCorrespodToTheWordInSearch(firstWord)
                .checkThatOpenedProductPageCorrespodToTheWordInSearch(secondWord);
    }

    public void SearchTheProductThatMatchesAsCatalog(){
    }

    public void SearchNegativeTest(){
        //min lenght 3
        //random chars
    }

}
