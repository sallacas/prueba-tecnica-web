package com.co.pruebatecnicaweb.tasks;


import com.co.pruebatecnicaweb.userinterfaces.NestedFramesPage;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Slf4j
@NoArgsConstructor
public class NestedFrames implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElement locator = Serenity.getDriver().findElement(NestedFramesPage.TITLE_PAGE);
        actor.attemptsTo(
                WaitUntil.the(ExpectedConditions.visibilityOf(locator))
        );
        WebElement iframeParent = Serenity.getDriver().findElement(NestedFramesPage.FRAME_PARENT);
        actor.attemptsTo(
                Switch.toFrame(iframeParent)
        );
        String textIframeParent = actor.asksFor(TextContent.of(NestedFramesPage.BODY));
        Serenity.recordReportData().withTitle("TextIframeParent").andContents(textIframeParent);
        WebElement iframeChild = Serenity.getDriver().findElement(NestedFramesPage.FRAME_CHILD);
        actor.attemptsTo(
                Switch.toFrame(iframeChild)
        );
        String textIframeChild = actor.asksFor(TextContent.of(NestedFramesPage.BODY_CHILD));
        Serenity.recordReportData().withTitle("TextIframeChild").andContents(textIframeChild);
        actor.attemptsTo(
                Switch.toDefaultContext()
        );
    }
    public static NestedFrames getData() {
        return Tasks.instrumented(NestedFrames.class);
    }
}
