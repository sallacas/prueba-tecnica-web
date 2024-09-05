package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BookStorePage {
    public static final Target TXT_SEARCH_BOOK = Target.the("Textbox Search Book").located(By.id("searchBox"));
    public static Target bookOption(String book) {
        return Target.the(book).located(By.xpath("//span[contains(@id,'see-book-"+book+"')]"));
    }
}
