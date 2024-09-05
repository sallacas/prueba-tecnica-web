package com.co.pruebatecnicaweb.questions;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

@Slf4j
@AllArgsConstructor
public class ValidateText implements Question<String> {

    private final Target element;

    @Override
    public String answeredBy(Actor actor) {
        String text = element.resolveFor(actor).getText();
        log.info("Texto de la etiqueta: {}", text);
        return text;
    }

    public static ValidateText of(Target element){
        return Instrumented.instanceOf(ValidateText.class).withProperties(element);
    }
}
