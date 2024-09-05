package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.userinterfaces.MenuPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.CurrentVisibility;

@AllArgsConstructor
public class ModuleApp implements Task {
    private String section;
    private String option;

    @Override
    @Subject("{0} : Nos dirigimos a la sección #section y a la opción #option")
    public <T extends Actor> void performAs(T actor) {
        if (!actor.asksFor(CurrentVisibility.of(MenuPage.optionLink(option)))) {
            actor.attemptsTo(
                    Click.on(MenuPage.sectionLink(section))
            );
        }
        actor.attemptsTo(
                Scroll.to(MenuPage.optionLink(option)).andAlignToTop(),
                Click.on(MenuPage.optionLink(option))
        );
    }

    public static ModuleApp goTo(String section, String option) {
        return Tasks.instrumented(ModuleApp.class, section, option);
    }
}
