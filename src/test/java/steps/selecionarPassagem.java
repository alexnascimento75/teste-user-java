package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class selecionarPassagem {

    @Given("que acesso o site Blazedemo")
    public void que_acesso_o_site_blazedemo() {
        System.out.println("Passo 1");

    }
    @When("seleciono a origem como {string} e destino {string}")
    public void seleciono_a_origem_como_e_destino(String string, String string2) {
        System.out.println("Passo 2");
    }
    @And("clico em Procurar Vôo")
    public void clico_em_procurar_vôo() {
        System.out.println("Passo 3");
    }
    @Then("exibe a frase indicando vôo entre {string} e {string}")
    public void exibe_a_frase_indicando_vôo_entre_e(String string, String string2) {
        System.out.println("Passo 4");


    }
}
