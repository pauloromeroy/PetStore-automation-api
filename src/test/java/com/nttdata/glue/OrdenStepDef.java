package com.nttdata.glue;

import com.nttdata.steps.OrdenStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class OrdenStepDef {

    @Steps
    OrdenStep ordenStep;

    @Given("creo una orden con id {string} y petId {string}")
    public void creoUnaOrdenConIdYPetId(String orderId, String petId) {
        ordenStep.crearOrden(orderId, petId);
    }

    @When("envio la orden al endpoint POST /store/order")
    public void envioLaOrdenAlEndpointPOSTStoreOrder() {
        ordenStep.enviarOrden();
    }

    @Then("el status code es {int}")
    public void elStatusCodeEs(int statusCode) {
        ordenStep.validarStatusCode(statusCode);
    }

    @And("el body contiene el id de orden {string} y petId {string}")
    public void elBodyContieneElIdDeOrdenYPetId(String orderId, String petId) {
        ordenStep.validarBody(orderId, petId);
    }
}
