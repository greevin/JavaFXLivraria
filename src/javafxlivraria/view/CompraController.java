/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.view;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Cliente;

/**
 *
 * @author glauber
 */
public class CompraController {

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private ComboBox<String> formaPagamentoComboBox;

    @FXML
    private Label enderecoFaturamentoLabel;

    @FXML
    private Label enderecoEntregaLabel;

    @FXML
    private Label precoTotalLabel;

    @FXML
    private TextField quantidadeTextField;

    @FXML
    private TextField numeroParcelasTextField;

    private Stage dialogStage;
    private boolean concluirClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    @FXML
    private void handleConcluir() {
        if (isInputValid()) {
            
            concluirClicked = true;
            dialogStage.close();
        }
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isConcluirClicked() {
        return concluirClicked;
    }

    private boolean isInputValid() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
