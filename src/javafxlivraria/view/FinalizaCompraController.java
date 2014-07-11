/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlivraria.view;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafxlivraria.LivrariaPrincipal;
import javafxlivraria.model.Cliente;
import javafxlivraria.model.ItemCarrinho;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author CASN
 */
public class FinalizaCompraController {

    private Stage dialogStage;
    private LivrariaPrincipal mainApp;

    @FXML
    private TableView<ItemCarrinho> tabelaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> tituloColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> precoColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> unidadesColunaCarrinho;
    @FXML
    private TableColumn<ItemCarrinho, String> totalColunaCarrinho;

    @FXML
    private ComboBox<Cliente> clienteComboBox;
    @FXML
    private Label enderecoFaturamentoLabel;
    @FXML
    private Label enderecoEntregaLabel;

    @FXML
    private ComboBox<String> formasPagamentoComboBox;
    @FXML
    private Label precoTotalLabel;
    @FXML
    private ComboBox<String> parcelasCreditoComboBox;

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

        tituloColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().tituloProperty());
        precoColunaCarrinho.setCellValueFactory(
                cellData -> cellData.getValue().precoProperty().asString());
        unidadesColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getUnidades().toString()));
        totalColunaCarrinho.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getTotal().toString()));

        tabelaCarrinho.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    Double precoTotal = 0.0;
                    for (ItemCarrinho carrinho : tabelaCarrinho.getItems()) {
                        precoTotal += carrinho.getPreco() * carrinho.getUnidades();
                    }
                    NumberFormat df = DecimalFormat.getCurrencyInstance();
                    precoTotalLabel.setText(NumberFormat.getCurrencyInstance().format(precoTotal));
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
        Action response = Dialogs.create()
                .title("Cancelar Comprar")
                .message("Deseja cancelar essa compra?")
                .showConfirm();

        if (response == Dialog.Actions.YES) {
            dialogStage.close();
        } else {
            dialogStage.show();
        }

    }

    @FXML
    private void handleConcluirCompra() {
        Dialogs.create()
                .title("Compra Finalizada")
                .message("Compra Finalizada")
                .showInformation();
        dialogStage.close();
    }

    public void setMainApp(LivrariaPrincipal mainApp) {
        this.mainApp = mainApp;

//        formaPagamentoComboBox.setItems(mainApp.getFormaPagamentoComboBoxData());
//        clienteComboBox.setItems(mainApp.getClienteComboBoxData());
    }

    public void setCarrinhoDeCompras(ObservableList<ItemCarrinho> itensCarrinho) {
        this.tabelaCarrinho.setItems(itensCarrinho);
    }

    public void setFormasDePagamento(ObservableList<String> formasDePagamento) {
        formasPagamentoComboBox.setItems(formasDePagamento);
    }

    public void setCliente(ObservableList<Cliente> clientes) {
        clienteComboBox.setItems(clientes);
    }

    public void setParcelasCredito(ObservableList<String> parcelasCredito) {
        parcelasCreditoComboBox.setItems(parcelasCredito);
    }
}
