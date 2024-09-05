package com.co.pruebatecnicaweb.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Accept implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = actor.abilityTo(BrowseTheWeb.class).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Esperar a que la alerta sea visible
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = Serenity.getDriver().switchTo().alert();
        // Aceptar (cerrar) la alerta
        alert.accept();
    }
    public static Accept theAlert() {
        return Tasks.instrumented(Accept.class);
    }
}
