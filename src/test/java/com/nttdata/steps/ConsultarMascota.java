package com.nttdata.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

public class ConsultarMascota {

    private String URL_BASE;
    Response response;

    public String getURL_BASE() {
        return URL_BASE;
    }

    public void setURL_BASE(String URL_BASE) {
        this.URL_BASE = URL_BASE;
    }

    public void consulta(String id) {
        response = RestAssured
                .given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .baseUri(this.URL_BASE)
                .log().all()
                .when()
                .get("/pet/" + id)
                .then()
                .log().all()
                .extract().response();

    }

    public void validarStatusCode(int statusCodeEsperado) {
        //Assert.assertEquals("No cumple", "200", "200");
        Assert.assertEquals("Status Code", statusCodeEsperado, response.statusCode());
    }

    public void validarNombreMascota(String nombreMascota) {
        Assert.assertEquals("Comparacion de Nombres", nombreMascota, response.jsonPath().getString("name"));
    }
}
