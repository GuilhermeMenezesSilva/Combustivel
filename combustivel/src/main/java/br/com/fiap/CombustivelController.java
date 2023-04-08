package br.com.fiap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CombustivelController {

    // atributos
    @FXML
    private TextField textFieldPrecoDoAlcool;
    @FXML
    private TextField textFieldPrecoDaGasolina;
    @FXML
    private Label labelResposta;

    private double precoDoAlcool;
    private double precoDaGasolina;

    public void calcular() {
        try {
            precoDoAlcool = Double.valueOf(textFieldPrecoDoAlcool.getText());
            precoDaGasolina = Double.valueOf(textFieldPrecoDaGasolina.getText());

            if (precoDoAlcool <= 0 || precoDaGasolina <= 0)
                throw new IllegalArgumentException();

            String combustivelIdeal = "GASOLINA";
            if (precoDoAlcool / precoDaGasolina < 0.7)
                combustivelIdeal = "ALCOOL";

            labelResposta.setText("O combustivel mais vantajoso é " + combustivelIdeal);

        } catch (NumberFormatException erro) {
            Alert alerta = new Alert(AlertType.ERROR);
            mostrarMensagem("O valor digitado nos campos deve ser decimal. Não coloque texto!", "preço inválido");

        } catch (IllegalArgumentException erro) {
            mostrarMensagem("O preço deve ser maior que zero", "valor inválido");
        }
    }

    private void mostrarMensagem(String mensagem, String titulo) {
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setContentText(mensagem); // Permite alterar a mensagem exibida
        alerta.setTitle(titulo); // Altera o titulo da mensagem de erro
    }

}
