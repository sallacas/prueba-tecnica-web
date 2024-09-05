package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.models.PracticeFormDTO;
import com.co.pruebatecnicaweb.userinterfaces.PracticeFormPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ui.Button;
import net.serenitybdd.screenplay.ui.Checkbox;
import net.serenitybdd.screenplay.ui.RadioButton;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.file.Paths;

@Slf4j
@AllArgsConstructor
public class PracticeForm implements Task {

    private PracticeFormDTO data;
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement locator = Serenity.getDriver().findElement(PracticeFormPage.TITLE_PAGE);
        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.visibilityOf(locator))
        );
        String[] dateOfBirth = data.getDateOfBirth().split("/");
        String year = dateOfBirth[2];
        String month = String.valueOf(Integer.parseInt(dateOfBirth[1]) - 1);
        String day = dateOfBirth[0];
        actor.attemptsTo(
                Enter.theValue(data.getFirstname()).into(PracticeFormPage.TXT_FIRSTNAME),
                Enter.theValue(data.getLastname()).into(PracticeFormPage.TXT_LASTNAME),
                Enter.theValue(data.getEmail()).into(PracticeFormPage.TXT_EMAIL),
                JavaScriptClick.on(RadioButton.withValue(data.getGender())),
                Enter.theValue(data.getMobile()).into(PracticeFormPage.NUMBER_MOBILE),
                Click.on(PracticeFormPage.TXT_DATE),
                SelectFromOptions.byValue(year).from(PracticeFormPage.SELECT_YEAR_DATE),
                SelectFromOptions.byValue(month).from(PracticeFormPage.SELECT_MONTH_DATE),
                Click.on(PracticeFormPage.optionDay(day)),
                Enter.theValue(data.getSubject()).into(PracticeFormPage.TXT_SUBJECT),
                JavaScriptClick.on(Checkbox.withLabel(data.getHobbies())),
                Upload.theFile(Paths.get("src/test/resources/datadriven/imagen_test.jpeg")).to(PracticeFormPage.BTN_UPLOAD  ),
                Enter.theValue(data.getCurrentAddress()).into(PracticeFormPage.TXT_CURRENT_ADDRESS),
                SendKeys.of(data.getState()).into(PracticeFormPage.TXT_STATE).thenHit(Keys.ENTER),
                SendKeys.of(data.getCity()).into(PracticeFormPage.TXT_CITY).thenHit(Keys.ENTER),
                Scroll.to(Button.withNameOrId("submit")),
                Click.on(Button.withNameOrId("submit")),
                Click.on(Button.withNameOrId("closeLargeModal"))
        );
    }
    public static PracticeForm fillWith (PracticeFormDTO data) {
        return Tasks.instrumented(PracticeForm.class, data);
    }
}
