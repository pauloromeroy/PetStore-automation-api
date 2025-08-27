package com.nttdata.steps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OrdenStep {

    private Response response;
    private String requestBody;

    public void crearOrden(String orderId, String petId) {
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

    public void validarStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    public void validarBody(String expectedOrderId, String expectedPetId) {
        response.then()
                .body("id", equalTo(Integer.parseInt(expectedOrderId)))
                .body("petId", equalTo(Integer.parseInt(expectedPetId)));
    }
}