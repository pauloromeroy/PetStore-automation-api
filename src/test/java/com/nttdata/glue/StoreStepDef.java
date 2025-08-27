package com.nttdata.glue;

import com.nttdata.steps.StoreStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class StoreStepDef {

    @Steps
    StoreStep storeStep;

    // Crear orden
    @Given("preparo una orden con id {string} y petId {string}")
    public void preparoUnaOrdenConIdYPetId(String orderId, String petId) {
        storeStep.prepararOrden(orderId, petId);
    }

    @When("envio la orden al endpoint POST /store/order")
    public void envioLaOrdenAlEndpointPOSTStoreOrder() {
        storeStep.enviarOrden();
    }

    // Consultar orden
    @Given("tengo una orden con id {string}")
    public void tengoUnaOrdenConId(String orderId) {
        storeStep.definirOrden(orderId);
    }

    @When("consulto la orden por id")
    public void consultoLaOrdenPorId() {
        storeStep.consultarOrden();
    }

    // Validaciones comunes
    @Then("el status code es {int}")
    public void elStatusCodeEs(int statusCode) {
        storeStep.validarStatusCode(statusCode);
    }

    @And("el body contiene el id de orden {string} y petId {string}")
    public void elBodyContieneElIdDeOrdenYPetId(String orderId, String petId) {
        storeStep.validarBody(orderId, petId);
    }
}