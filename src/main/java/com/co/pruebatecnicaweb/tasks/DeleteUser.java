package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.userinterfaces.ProfilePage;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
@Slf4j
@NoArgsConstructor
public class DeleteUser implements Task {
    @Override
    @Subject("{0}: Eliminar el usuario actual")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(ProfilePage.BTN_DELETE_ACCOUNT).andAlignToTop(),
                Click.on(ProfilePage.BTN_DELETE_ACCOUNT),
                Click.on(ProfilePage.BTN_OK),
                WaitUntil.the(ExpectedConditions.alertIsPresent()).forNoMoreThan(Duration.ofSeconds(13L))
        );
        log.info("Usuario eliminado");
    }

    public static DeleteUser fromTheSite() {
        return Tasks.instrumented(DeleteUser.class);
    }
}
