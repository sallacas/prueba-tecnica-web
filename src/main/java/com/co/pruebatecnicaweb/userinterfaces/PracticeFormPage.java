package com.co.pruebatecnicaweb.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PracticeFormPage {
    public static final By TITLE_PAGE = By.xpath("//h1[@class='text-center' and contains(text(),'Practice Form')]");
    public static final Target TXT_FIRSTNAME = Target.the("Firstname").located(By.id("firstName"));
    public static final Target TXT_LASTNAME = Target.the("Lastname").located(By.id("lastName"));
    public static final Target TXT_EMAIL = Target.the("Email").located(By.id("userEmail"));
    public static final Target NUMBER_MOBILE = Target.the("Mobile").located(By.id("userNumber"));

    public static final Target TXT_DATE = Target.the("Date").located(By.id("dateOfBirthInput"));
    public static final Target SELECT_YEAR_DATE = Target.the("Year").located(By.cssSelector("select.react-datepicker__year-select"));
    public static final Target SELECT_MONTH_DATE = Target.the("Month").located(By.cssSelector("select.react-datepicker__month-select"));
    public static Target optionDay (String day) {
        return Target.the(day).located(By.xpath("//div[@role='option' and contains(text(),'" + day + "')]"));
    }
    public static final Target BTN_UPLOAD = Target.the("Upload").located(By.id("uploadPicture"));
    public static final Target TXT_SUBJECT = Target.the("Subject").located(By.id("subjectsInput"));
    public static final Target TXT_CURRENT_ADDRESS = Target.the("Current Address").located(By.id("currentAddress"));
    public static final Target TXT_STATE = Target.the("State").located(By.id("react-select-3-input"));
    public static final Target TXT_CITY = Target.the("City").located(By.id("react-select-4-input"));
}
