package com.nttdata.glue;

import com.nttdata.steps.ConsultarMascota;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class MascotaStepDef {

    @Steps  // mascota = new ConsultarMascota();
    ConsultarMascota mascota;


    @Given("defindo la URL {string}")
    public void defindoLaURL(String url) {
        mascota.setURL_BASE(url);

    }

    @When("consulto la mascota de ID {string}")
    public void consultoLaMascotaDeID(String id) {
        mascota.consulta(id);
    }

    @And("valido el codigo de respuesta sea {int}")
    public void validoElCodigoDeRespuestaSea(int statusCodeEsperado) {
        mascota.validarStatusCode(statusCodeEsperado);
    }


    @And("valido el nombre de la mascota sea {string}")
    public void validoElNombreDeLaMascotaSea(String arg0) {
        mascota.validarNombreMascota(arg0);
    }
}
