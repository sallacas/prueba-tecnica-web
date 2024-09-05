package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.models.UserLoombokData;
import com.co.pruebatecnicaweb.userinterfaces.DemoQAPage;
import com.co.pruebatecnicaweb.utils.Constantes;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class Login implements Task {

    private String username;
    private String password;

    @Override
    @Subject("{0} Ingresamos con el usuario: #username y la contraseña: #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constantes.URL),
                Enter.theValue(username).into(DemoQAPage.TXT_USERNAME),
                Enter.theValue(password).into(DemoQAPage.TXT_PASSWORD),
                JavaScriptClick.on(DemoQAPage.BTN_LOGIN)
        );
    }

    public static Login onTheSite(String username, String password) {
        return Instrumented.instanceOf(Login.class).withProperties(username, password);
    }
}
