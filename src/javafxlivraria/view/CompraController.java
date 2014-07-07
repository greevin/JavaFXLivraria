/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.view;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Cliente;
import javafxlivraria.model.Item;

/**
 *
 * @author glauber
 */
public class CompraController {

    @FXML
    private ComboBox<Cliente> clienteComboBox;

    @FXML
    private ComboBox<StringProperty> formaPagamentoComboBox;

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
    
    @FXML
    private TableView<Item> itemTableItens;
    @FXML
    private TableColumn<Item, String> tituloItemColuna;
    @FXML
    private TableColumn<Item, String> precoItemColuna;

    private Stage dialogStage;
    private boolean concluirClicked = false;
    private LivrariaPrincipal mainApp;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        showClienteDetails(null);

        clienteComboBox.setCellFactory((comboBox) -> {
            return new ListCell<Cliente>() {
                @Override
                protected void updateItem(Cliente cliente, boolean empty) {
                    super.updateItem(cliente, empty);

                    if (cliente == null || empty) {
                        setText(null);
                    } else {
                        setText(cliente.getNome());
                    }
                }
            };
        });

        clienteComboBox.setConverter(new StringConverter<Cliente>() {
            @Override
            public String toString(Cliente cliente) {
                if (cliente == null) {
                    return null;
                } else {
                    return cliente.getNome();
                }
            }

            @Override
            public Cliente fromString(String clienteString) {
                return null; // No conversion fromString needed.
            }
        });

        clienteComboBox.setOnAction((event) -> {
            Cliente selectedCliente = clienteComboBox.getSelectionModel().getSelectedItem();
            showClienteDetails(selectedCliente);

        });
    }

    private void showClienteDetails(Cliente cliente) {
        if (cliente != null) {
            // Fill the labels with info from the person object.
            enderecoFaturamentoLabel.setText(cliente.getEnderecoDeFaturamento().getCidade());
            enderecoEntregaLabel.setText(cliente.getEnderecoDeEntrega().getCidade());
        } else {
            // Person is null, remove all the text.
            enderecoFaturamentoLabel.setText("");
            enderecoEntregaLabel.setText("");
        }
    }
    
    private void preencheTabela(Cliente cliente){
        // Listen for selection changes and show the person details when changed.
        clienteComboBox.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClienteDetails(newValue));
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

    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;

        formaPagamentoComboBox.setItems(mainApp.getFormaPagamentoComboBoxData());
        clienteComboBox.setItems(mainApp.getClienteComboBoxData());
    }

}
