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
    public void SearchTheProductThatMatchesInDrowdown(String prodName){
        mainPage.fillSearchField1ByCharacter(prodName)
                .clickTheSmartsearchItem(1)
                .checkThatOpenedProductPageCorrespodToTheWordInSearch(prodName);
    }

    //check that opened product correspond to the words
    @FileParameters("src/test/resources/FullProductsNames.csv")
    public void SearchTheProductThatMatches100percent(String firstWord, String secondWord, String thirdWord){
        mainPage.fillSearchField1ByCharacter(firstWord + " " + secondWord + " " + thirdWord)
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
