package com.nttdata.steps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ConsultarOrdenStep {

    private Response response;
    private String orderId;

    public void definirOrden(String orderId) {
        this.orderId = orderId;
    }

    public void consultarOrden() {
        response = given()
                .when()
                .get("/store/order/" + orderId);
    }

    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validarBody(String expectedOrderId, String expectedPetId) {
        response.then()
                .body("id", equalTo(Integer.parseInt(expectedOrderId)))
                .body("petId", equalTo(Integer.parseInt(expectedPetId)));
    }
}
