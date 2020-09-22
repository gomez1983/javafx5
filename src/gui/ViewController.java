package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {

	@FXML
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	
// Declaração de atributo do botão
	@FXML
	private Button btSum;

// Declaração da ação de clicar no botão
	@FXML
	public void onBtSumAction() {
		try {
			Locale.setDefault(Locale.US); //Pra garantir que a leitura do número será com "." e não com a "," do português, tem que converter para "US".
			double number1 = Double.parseDouble(txtNumber1.getText()); //O valor da caixa de texto está em String. É necessário converter a String para Double.
			double number2 = Double.parseDouble(txtNumber2.getText()); //O valor da caixa de texto está em String. É necessário converter a String para Double.
			double sum = number1 + number2;
			labelResult.setText(String.format("%.2f", sum)); // Coloca o resultado do método dentro do label.
		}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

	// Executa quando o controlador for criado
@Override
public void initialize(URL url, ResourceBundle rb) {
	Constraints.setTextFieldDouble(txtNumber1); //Método para aceitar apenas double
	Constraints.setTextFieldDouble(txtNumber2); //Método para aceitar apenas double
	Constraints.setTextFieldMaxLength(txtNumber1, 12); //Método para determinar o número máximo de caracteres
	Constraints.setTextFieldMaxLength(txtNumber2, 12); //Método para determinar o número máximo de caracteres
}
}
