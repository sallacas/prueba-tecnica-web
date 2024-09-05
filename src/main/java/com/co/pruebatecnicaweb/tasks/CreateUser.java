package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.userinterfaces.DemoQAPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class CreateUser implements Task {
    private String firstname;
    private String lastname;
    private String username;
    private String password;

    @Override
    @Subject("{0} Creamos un nuevo usuario con los siguientes datos: nombre #firstname ,apellido #lastname ,usuario #username ,contraseña #password")
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(DemoQAPage.BTN_NEW_USER),
                    WaitUntil.the(DemoQAPage.REGISTER_TITLE, isVisible()).forNoMoreThan(10).seconds(),
                    Enter.theValue(firstname).into(DemoQAPage.TXT_FIRST_NAME),
                    Enter.theValue(lastname).into(DemoQAPage.TXT_LAST_NAME),
                    Enter.theValue(username).into(DemoQAPage.TXT_USERNAME),
                    Enter.theValue(password).into(DemoQAPage.TXT_PASSWORD)
            );
            WebElement locator = Serenity.getDriver().findElement(DemoQAPage.IFRAME_CAPTCHA);
            actor.attemptsTo(
                    Switch.toFrame(locator),
                    Scroll.to(DemoQAPage.BTN_CAPTCHA).andAlignToTop(),
                    Click.on(DemoQAPage.BTN_CAPTCHA)
            );
            Thread.sleep(5000);
            actor.attemptsTo(
                    Click.on(DemoQAPage.BTN_REGISTER),
                    WaitUntil.the(ExpectedConditions.alertIsPresent()).forNoMoreThan(Duration.ofSeconds(13L))
            );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static CreateUser with(String firstname, String lastname, String username, String password) {
        return Tasks.instrumented(CreateUser.class, firstname, lastname, username, password);
    }
}
