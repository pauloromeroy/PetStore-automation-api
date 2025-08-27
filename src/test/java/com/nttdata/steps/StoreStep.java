
package com.nttdata.steps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StoreStep {

    private Response response;
    private String requestBody;
    private String orderId;

    // ----- Crear orden -----
    public void prepararOrden(String orderId, String petId) {
        this.orderId = orderId;
        requestBody = "{"
                + "\"id\": " + orderId + ","
                + "\"petId\": " + petId + ","
                + "\"quantity\": 1,"
                + "\"status\": \"placed\","
                + "\"complete\": true"
                + "}";
    }

    public void enviarOrden() {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/store/order");
    }

    // ----- Consultar orden -----
    public void definirOrden(String orderId) {
        this.orderId = orderId;
    }

    public void consultarOrden() {
        response = given()
                .when()
                .get("/store/order/" + orderId);
    }

    // ----- Validaciones -----
    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validarBody(String expectedOrderId, String expectedPetId) {
        response.then()
                .body("id", equalTo(Integer.parseInt(expectedOrderId)))
                .body("petId", equalTo(Integer.parseInt(expectedPetId)));
    }
}
