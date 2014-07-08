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
public class FinalizaCompraController {

    private Stage dialogStage;
    private LivrariaPrincipal mainApp;

    @FXML
    private TableView<Item> tabelaCarrinho;
    @FXML
    private TableColumn<Item, String> tituloColunaCarrinho;
    @FXML
    private TableColumn<Item, String> precoColunaCarrinho;
    @FXML
    private TableColumn<Item, String> quantidadeColunaCarrinho;
    @FXML
    private TableColumn<Item, String> totalColunaCarrinho;

    @FXML
    private ComboBox<Cliente> clienteComboBox;
    @FXML
    private Label enderecoFaturamentoLabel;
    @FXML
    private Label enderecoEntregaLabel;

    @FXML
    private ComboBox<StringProperty> formaPagamentoComboBox;
    @FXML
    private Label precoTotalLabel;
    @FXML
    private ComboBox<StringProperty> parcelasCreditoComboBox;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {

        preencheDetalhesCliente(null);

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
            preencheDetalhesCliente(selectedCliente);

        });
    }

    private void preencheDetalhesCliente(Cliente cliente) {
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
//    
//    private void preencheTabela(Cliente cliente){
//        // Listen for selection changes and show the person details when changed.
//        clienteComboBox.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> preencheDetalhesCliente(newValue));
//    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void handleCancelarCompra() {
        dialogStage.close();
    }

    @FXML
    private void handleConcluirCompra() {

    }

    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;

        formaPagamentoComboBox.setItems(mainApp.getFormaPagamentoComboBoxData());
        clienteComboBox.setItems(mainApp.getClienteComboBoxData());
    }

}
