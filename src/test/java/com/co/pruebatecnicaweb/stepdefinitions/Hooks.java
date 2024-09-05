package com.co.pruebatecnicaweb.stepdefinitions;

import com.co.pruebatecnicaweb.models.BookDTO;
import com.co.pruebatecnicaweb.models.NewUserDTO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void close() {
        getDriver().close();
    }

    @DataTableType
    public NewUserDTO newUserDTO(Map<String, String> entry) {
        return new NewUserDTO(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("username"),
                entry.get("password")
        );
    }

    @DataTableType
    public BookDTO book(Map<String, String> entry) {
        return new BookDTO(
                entry.get("book")
        );
    }
}
