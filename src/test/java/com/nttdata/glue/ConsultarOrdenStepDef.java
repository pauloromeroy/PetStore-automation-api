package com.nttdata.glue;

import com.nttdata.steps.ConsultarOrdenStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class ConsultarOrdenStepDef {

    @Steps
    ConsultarOrdenStep consultarOrdenStep;

    @Given("tengo una orden con id {string}")
    public void tengoUnaOrdenConId(String orderId) {
        consultarOrdenStep.definirOrden(orderId);
    }

    @When("consulto la orden por id")
    public void consultoLaOrdenPorId() {
        consultarOrdenStep.consultarOrden();
    }

    @Then("el status code es {int}")
    public void elStatusCodeEs(int statusCode) {
        consultarOrdenStep.validarStatusCode(statusCode);
    }

    @And("el body contiene el id de orden {string} y petId {string}")
    public void elBodyContieneElIdDeOrdenYPetId(String orderId, String petId) {
        consultarOrdenStep.validarBody(orderId, petId);
    }
}
