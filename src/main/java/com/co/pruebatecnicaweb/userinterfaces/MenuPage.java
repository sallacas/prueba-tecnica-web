package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuPage {
    public static Target optionLink (String option) {
        return Target.the(option).located(By.xpath("//span[normalize-space()='" + option + "']"));
    }
    public static Target sectionLink (String section) {
        return Target.the(section).located(By.xpath("//div[normalize-space()='" + section + "']"));
    }
}
