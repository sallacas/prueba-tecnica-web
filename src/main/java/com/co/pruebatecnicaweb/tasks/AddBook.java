package com.co.pruebatecnicaweb.tasks;

import com.co.pruebatecnicaweb.models.BookDTO;
import com.co.pruebatecnicaweb.userinterfaces.BookStorePage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

@AllArgsConstructor
public class AddBook implements Task {
    private final List<BookDTO> book;
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (BookDTO book : book) {
            actor.attemptsTo(
                    Click.on(BookStorePage.TXT_SEARCH_BOOK),
                    Enter.theValue(book.getBook()).into(BookStorePage.TXT_SEARCH_BOOK)
                    //Click.on(BookStorePage.bookOption(book.getBook()))
            );
        }
    }
    public static AddBook toCollection(List<BookDTO> book) {
        return Tasks.instrumented(AddBook.class, book);
    }
}
