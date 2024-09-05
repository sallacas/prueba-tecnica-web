package com.co.pruebatecnicaweb.stepdefinitions;

import com.co.pruebatecnicaweb.models.BookDTO;
import com.co.pruebatecnicaweb.models.NewUserDTO;
import com.co.pruebatecnicaweb.questions.ValidateText;
import com.co.pruebatecnicaweb.tasks.*;
import com.co.pruebatecnicaweb.userinterfaces.DemoQAPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;

import java.util.List;

import static com.co.pruebatecnicaweb.utils.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class DemoQAStepDefinitions {


    @Given("El usuario navega a la pagina de demoqa")
    public void elUsuarioNavegaALaPaginaDeDemoQA() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }


    @When("El usuario selecciona la opción New User y registra un nuevo usuario con la siguiente información:")
    public void elUsuarioSeleccionaLaOpcionYRegistraUnNuevoUsuarioConLaSiguienteInformación(DataTable table) {
        NewUserDTO data = table.asList(NewUserDTO.class).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                CreateUser.with(data.getFirstname(), data.getLastname(), data.getUsername(), data.getPassword())
        );
    }

    @And("nos logeamos con la cuenta {string} y la contraseña {string}")
    public void loginInThePageWithTheUsernameAndThePassword(String user, String password) {
        OnStage.theActorInTheSpotlight().wasAbleTo(Login.onTheSite(user, password));
    }

    @When("el usuario ingresa a {string} y selecciona la opción {string}")
    public void enterToModuleAppAndSelectOption(String section, String option) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ModuleApp.goTo(section, option)
        );

    }

    @And("El usuario selecciona el libro y lo agrega a su colección")
    public void addBookToCollection(DataTable table) {
        List<BookDTO> books = table.asList(BookDTO.class);
        OnStage.theActorInTheSpotlight().attemptsTo(
                AddBook.toCollection(books)
        );
    }

    @And("elimina el usuario logeado")
    public void eliminaElUsuarioLogeado() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                ModuleApp.goTo("Book Store Application", "Profile"),
                DeleteUser.fromTheSite()
        );
    }

    @And("valida que el usuario {string} con contraseña {string} no existe")
    public void validateUserDeleted(String user, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(user, password)
        );
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(DemoQAPage.TXT_ERROR), Matchers.containsString("Invalid username or password!")));
    }
}
